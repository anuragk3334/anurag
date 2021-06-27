package com.example.demo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_EMPTY) 
public class SupportTicket {
	
	private Long ticketOwnerUserId;
	private Long supportTickeId;
	private String description;
	private List<String> skillSets;
	private Double bidPrice ;
	
	private Long ticketInterestUserId;
	private Long ticketConnectUserId;
	
	private List<UserDetails> interestedUsers;
	
	private String statusAfterConnect;
	
	
	
	
	public String getStatusAfterConnect() {
		return statusAfterConnect;
	}
	public void setStatusAfterConnect(String statusAfterConnect) {
		this.statusAfterConnect = statusAfterConnect;
	}
	public List<UserDetails> getInterestedUsers() {
		return interestedUsers;
	}
	public void setInterestedUsers(List<UserDetails> interestedUsers) {
		this.interestedUsers = interestedUsers;
	}
	public Long getTicketOwnerUserId() {
		return ticketOwnerUserId;
	}
	public void setTicketOwnerUserId(Long ticketOwnerUserId) {
		this.ticketOwnerUserId = ticketOwnerUserId;
	}
	public Long getSupportTickeId() {
		return supportTickeId;
	}
	public void setSupportTickeId(Long supportTickeId) {
		this.supportTickeId = supportTickeId;
	}
	public Long getTicketInterestUserId() {
		return ticketInterestUserId;
	}
	public void setTicketInterestUserId(Long ticketInterestUserId) {
		this.ticketInterestUserId = ticketInterestUserId;
	}
	public Long getTicketConnectUserId() {
		return ticketConnectUserId;
	}
	public void setTicketConnectUserId(Long ticketConnectUserId) {
		this.ticketConnectUserId = ticketConnectUserId;
	}
	private String ticketStatus ;
	private List<UserDetails> usersInterseted ;
	private UserDetails userConneted;


	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getSkillSets() {
		return skillSets;
	}
	public void setSkillSets(List<String> skillSets) {
		this.skillSets = skillSets;
	}
	public Double getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(Double bidPrice) {
		this.bidPrice = bidPrice;
	}
	public String getTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	public List<UserDetails> getUsersInterseted() {
		return usersInterseted;
	}
	public void setUsersInterseted(List<UserDetails> usersInterseted) {
		this.usersInterseted = usersInterseted;
	}
	public UserDetails getUserConneted() {
		return userConneted;
	}
	public void setUserConneted(UserDetails userConneted) {
		this.userConneted = userConneted;
	}
	
	
	

}
