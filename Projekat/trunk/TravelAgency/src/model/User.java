/***********************************************************************
 * Module:  User.java
 * Author:  Nikola
 * Purpose: Defines the Class User
 ***********************************************************************/

package model;

import java.util.*;

/** @pdOid ad3ee6e5-fe5b-40bb-9a5b-812b83598efd */
public class User {
   private int id;
   private String username;
   private String password;
   private int userType;
   private String firstName;
   private String lastName;
   private String identificationNumber;
   private String emailAddress = null;
   private String phoneNumber = null;
   
   
   
   public static User instance;
   
   public User() {
	// TODO Auto-generated constructor stub
   }
   
   public static User getInstance() {
      if(instance == null)
      {
    	  instance = new User();
      }
      return instance;
   }
   
   public static void setInstance(User instance) {
	User.instance = instance;
}

public int getId() {
      return id;
   }
   
   public void setId(int newId) {
      id = newId;
   }

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getUserType() {
		return userType;
	}
	
	public void setUserType(int usertype) {
		this.userType = usertype;
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
	
	public String getIdentificationNumber() {
		return identificationNumber;
	}
	
	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
   
   
}