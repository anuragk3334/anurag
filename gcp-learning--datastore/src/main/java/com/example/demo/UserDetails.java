package com.example.demo;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_EMPTY) 
public class UserDetails {
	
	public static void main(String[] args) throws JsonProcessingException {
		UserDetails details =new UserDetails();
		details.setEmail("kr35anurag@gmail.com");
		details.setFirstName("Anurag");
		details.setLastName("Kumar");
		details.setContactNumber("9356007435");
		
		List<String> asList = Arrays.asList("Java","GCP");
		details.setUserId("5632499082330112");
		details.setSkillsets(asList);
		
		ObjectMapper mapper = new ObjectMapper();
		String userdetailAsJson = mapper.writeValueAsString( details );
		System.out.println(userdetailAsJson);
		
	}
	private String userId;
	private String email;
	private String contactNumber;
	
	private String intersetdon;
	
	
	public String getIntersetdon() {
		return intersetdon;
	}
	public void setIntersetdon(String intersetdon) {
		this.intersetdon = intersetdon;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	private List<String> skillsets;
	private String firstName;
	private String lastName;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public List<String> getSkillsets() {
		return skillsets;
	}
	public void setSkillsets(List<String> skillsets) {
		this.skillsets = skillsets;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

}
