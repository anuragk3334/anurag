package com.example.demo.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.SupportTicket;
import com.example.demo.UserDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.IncompleteKey;
import com.google.cloud.datastore.KeyFactory;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StructuredQuery.CompositeFilter;
import com.google.cloud.datastore.StructuredQuery.PropertyFilter;
import com.google.common.collect.Lists;
import com.google.cloud.datastore.Key;


@RestController
public class ModelController {
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody UserDetails userDetails) throws JsonProcessingException {
		
		Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

		KeyFactory keyFactory = datastore.newKeyFactory().setKind("userDetails");
		
		IncompleteKey key = keyFactory.newKey();
		
		ObjectMapper mapper = new ObjectMapper();
		String userdetailAsJson = mapper.writeValueAsString( userDetails );
		
		FullEntity<IncompleteKey> fullEntity = Entity.newBuilder(key).
				  set("emailId", userDetails.getEmail())
				 .set("contactNumber", userDetails.getContactNumber())
				 .set("metaData", userdetailAsJson)
				 .set("name", userDetails.getFirstName().concat(" ").concat(userDetails.getFirstName()))
				 .build();
		
		
		Entity put = datastore.put(fullEntity);
		String primaryKey=put.getKey().getId().toString();
		
		return ResponseEntity.ok(primaryKey);
	}
	
	@PostMapping("/userProfileEdit")
	public ResponseEntity<String> editProfile( @RequestBody UserDetails userDetails) throws JsonProcessingException {
		
		Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

		KeyFactory keyFactory = datastore.newKeyFactory().setKind("userDetails");
		
		Key newKey = keyFactory.newKey(Long.valueOf(userDetails.getUserId()));
		
		Entity entity= datastore.get(newKey);
		
		List<String> skillsets = userDetails.getSkillsets();
		
		String skillSets = skillsets.stream().collect(Collectors.joining(","));
		
		
		
		 entity = Entity.newBuilder(entity)
			        .set("profiles", skillSets)
			       
			        .build();
			    datastore.update(entity);
		
		
		
		
		return ResponseEntity.ok("Anurag");
	}
	

	@GetMapping("/getdata")
	public String create() throws JsonProcessingException {

		Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

		KeyFactory keyFactory = datastore.newKeyFactory().setKind("userGroup");

		IncompleteKey key = keyFactory.newKey();

		FullEntity<IncompleteKey> fullEntity = Entity.newBuilder(key).set("groupId", 2)
				.set("groupName", "taskSupporter").build();
		datastore.put(fullEntity);

	
		return "hello";

	}
	
	
	@PostMapping("/createSupportRequest")
	public ResponseEntity<String> editProfile( @RequestBody SupportTicket supportTicket) throws JsonProcessingException {
		
		Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

		KeyFactory keyFactory = datastore.newKeyFactory().setKind("workFlowTicket");
		
		IncompleteKey key = keyFactory.newKey();
		
		List<String> skillSets = supportTicket.getSkillSets();
		
		String technoloySkill = skillSets.stream().collect(Collectors.joining(","));
		
		FullEntity<IncompleteKey> fullEntity = Entity.newBuilder(key).
				  set("description", supportTicket.getDescription())
				 .set("bidPrice", supportTicket.getBidPrice())
				 .set("userId", supportTicket.getTicketOwnerUserId())
				 .set("status", "OPEN")
				 .set("technology",technoloySkill)
				 .build();
		
		
		Entity put = datastore.put(fullEntity);
		String primaryKey=put.getKey().getId().toString();
		
		return ResponseEntity.ok(primaryKey);
	}
	
	@GetMapping("/getAllMatchingRequest")
	public ResponseEntity<List<SupportTicket>> getAllMatching(@RequestParam("userId")Long userId) {
		
		Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

		KeyFactory keyFactory = datastore.newKeyFactory().setKind("userDetails");
		
		Key newKey = keyFactory.newKey(userId);
		
		Entity entity= datastore.get(newKey);
		
		String profiles=entity.getString("profiles");
		
		List<String> profileList=Stream.of(profiles.split(",")).collect(Collectors.toList());
		
		Query<Entity> query = Query.newEntityQueryBuilder()
			    .setKind("workFlowTicket")
			    .setFilter(CompositeFilter.and(
			        PropertyFilter.eq("status", "OPEN")))
			   .build();
		
		QueryResults<Entity> results = datastore.run(query);
		
		List<SupportTicket> tickets=Lists.newArrayList();
		
		while(results.hasNext()) {
			Entity next = results.next();
			SupportTicket ticket =new SupportTicket();
			String status=next.getString("status");
			String technology = next.getString("technology");
			List<String> technologies = Stream.of(technology.split(",")).collect(Collectors.toList());
			String description =next.getString("description");
			Long user = next.getLong("userId");
			Long questionId=next.getKey().getId();
			
			Double bidPrice=next.getDouble("bidPrice");
			
			
			ticket.setTicketStatus(status);
			ticket.setSkillSets(technologies);
			ticket.setDescription(description);
			ticket.setSupportTickeId(questionId);
			ticket.setBidPrice(bidPrice);
			ticket.setTicketOwnerUserId(Long.valueOf(user));
			ticket.setDescription(next.getString("description"));
			
			tickets.add(ticket);
			
		}
		
		List<SupportTicket> filteredCollection = tickets.stream().
				filter(ticket->(ticket.getTicketOwnerUserId()!=userId && profileList.containsAll(ticket.getSkillSets())))
				.collect(Collectors.toList());
		
		
		return  ResponseEntity.ok(filteredCollection);
	}
	
	@PostMapping("/showInterest")
	public ResponseEntity<String> showInterset(@RequestBody SupportTicket supportTicket) {
		
	
		Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

		KeyFactory keyFactory = datastore.newKeyFactory().setKind("workFlowInterest");

		IncompleteKey key = keyFactory.newKey();

		FullEntity<IncompleteKey> fullEntity = Entity.newBuilder(key).
				set("ticketId", supportTicket.getSupportTickeId()).
				set("interestedUserId", supportTicket.getTicketInterestUserId()).
				set("createdOn", new Date().toString()).
				build();
		datastore.put(fullEntity);
		
		return ResponseEntity.ok("Interset created successfully !!") ;
	}
	
	@GetMapping("/getTickets")
	public Map<Long, SupportTicket> getMyTickets(@RequestParam("userId") Long ticketCreatoruserid) {
		
		Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

		KeyFactory keyFactory = datastore.newKeyFactory().setKind("workFlowTicket");
		
		Query<Entity> query = Query.newEntityQueryBuilder()
			    .setKind("workFlowTicket")
			    .setFilter(CompositeFilter.and(
			        PropertyFilter.eq("userId", ticketCreatoruserid)))
			   .build();
		
		QueryResults<Entity> workFlowTickets = datastore.run(query);
		
		List<SupportTicket> supportTickets=Lists.newArrayList() ;
		
		while(workFlowTickets.hasNext()) {
			SupportTicket ticket=new SupportTicket();
			Entity next = workFlowTickets.next();
			
			String status=next.getString("status");
			String technology = next.getString("technology");
			List<String> technologies = Stream.of(technology.split(",")).collect(Collectors.toList());
			String description =next.getString("description");
			Long user = next.getLong("userId");
			Long questionId=next.getKey().getId();
			
			Double bidPrice=next.getDouble("bidPrice");
			
			
			ticket.setTicketStatus(status);
			ticket.setSkillSets(technologies);
			ticket.setDescription(description);
			ticket.setSupportTickeId(questionId);
			ticket.setBidPrice(bidPrice);
			ticket.setTicketOwnerUserId(Long.valueOf(user));
			ticket.setDescription(next.getString("description"));
			
			supportTickets.add(ticket);
			
		}
		
	
		
		Map<Long, SupportTicket> ticketIdMap = supportTickets.stream().collect(Collectors.toMap(SupportTicket::getSupportTickeId,Function.identity()));
		
		ticketIdMap.forEach((k,v)->{
		
			Query<Entity> query1 = Query.newEntityQueryBuilder()
				    .setKind("workFlowInterest")
				    .setFilter(CompositeFilter.and(
				        PropertyFilter.eq("ticketId", k)))
				   .build();
			
			QueryResults<Entity> workFlowInterset = datastore.run(query1);
			List<UserDetails> interestedUsers =Lists.newArrayList() ;
			
			while(workFlowInterset.hasNext()) {
				Entity workInterset = workFlowInterset.next();
				
				Long intersetedUserId =workInterset.getLong("interestedUserId");
				
				String  intersetedOn =workInterset.getString("createdOn");
				
				KeyFactory keyFactory2 = datastore.newKeyFactory().setKind("userDetails");
				
				Key newKey2 = keyFactory2.newKey(Long.valueOf(intersetedUserId));
				
				Entity entity2= datastore.get(newKey2);
				
				UserDetails userdetail=new UserDetails();
				
				String contactNumber=entity2.getString("contactNumber");
				
				String emailId=entity2.getString("emailId");
				
				userdetail.setContactNumber(contactNumber);
				
				userdetail.setEmail(emailId);
				
				userdetail.setIntersetdon(intersetedOn);
				
				interestedUsers.add(userdetail);
				
				
			}
			
			v.setInterestedUsers(interestedUsers);
		});
		
		return ticketIdMap;
	
	}
	
	@PostMapping("/connect")
	public ResponseEntity<String> workFlowConnect(@RequestBody SupportTicket supportTicket) {
		
	
		Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

		KeyFactory keyFactory = datastore.newKeyFactory().setKind("workFlowConnect");

		IncompleteKey key = keyFactory.newKey();

		FullEntity<IncompleteKey> fullEntity = Entity.newBuilder(key).
				set("ticketId", supportTicket.getSupportTickeId()).
				set("connectedUserId", supportTicket.getTicketInterestUserId()).
				set("connectedOn", new Date().toString()).
				set("workFlowStatus" ,"CONNECTED").
				set("ticketOwnerUserId",supportTicket.getTicketOwnerUserId()).
				build();
		datastore.put(fullEntity);
		
		KeyFactory keyFactory1 = datastore.newKeyFactory().setKind("workFlowTicket");
		
       Key newKey1 = keyFactory1.newKey(supportTicket.getSupportTickeId());
		
		Entity entity1= datastore.get(newKey1);
		
		 entity1 = Entity.newBuilder(entity1)
			        .set("status", "CONNECTED")
			       
			        .build();
			    datastore.update(entity1);
		
		return ResponseEntity.ok("Connected with User !!") ;
	}
	
	@PostMapping("/actionAfterConnect")
	public String actionAfterConnect(@RequestBody SupportTicket supportTicket) {
		
		String connectFinalStatus=supportTicket.getStatusAfterConnect();
		
		Long connectUserId= supportTicket.getTicketInterestUserId();
		
		Long supportTickeId = supportTicket.getSupportTickeId();
		
		Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

		KeyFactory keyFactory = datastore.newKeyFactory().setKind("workFlowConnect");
		
		Query<Entity> query = Query.newEntityQueryBuilder()
			    .setKind("workFlowConnect")
			    .setFilter(CompositeFilter.and(
			        PropertyFilter.eq("connectedUserId", connectUserId)).and(
			        PropertyFilter.eq("ticketId", supportTickeId)))
			   .build();
		
		QueryResults<Entity> results = datastore.run(query);
		
		while(results.hasNext()) {
			Entity next = results.next();
			next = Entity.newBuilder(next)
				        .set("status", connectFinalStatus)
				        .set("finalActionOn", new Date().toString())
				        .build();
			datastore.update(next);
		}
		
		KeyFactory keyFactory1 = datastore.newKeyFactory().setKind("workFlowTicket");
		
	       Key newKey1 = keyFactory1.newKey(supportTicket.getSupportTickeId());
			
			Entity entity1= datastore.get(newKey1);
			
			 entity1 = Entity.newBuilder(entity1)
				        .set("status", connectFinalStatus)
				       
				        .build();
				    datastore.update(entity1);
		
		
		return "Final Action Taken";
	}
	

}
