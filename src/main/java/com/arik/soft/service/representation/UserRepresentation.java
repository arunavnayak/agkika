package com.arik.soft.service.representation;

import com.arik.soft.domain.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class UserRepresentation {
    private Long userId;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String phoneNo;
    private String address;
    private String password;

    public UserRepresentation(User user) {
        this.userId = user.getUserId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.userName = user.getUserName();
        this.email = user.getEmail();
        this.phoneNo = user.getPhoneNo();
        this.address = user.getAddress();
        this.password = user.getPassword();
    }

    public static User getUser(UserRepresentation userRepresentation){
        User user = new User();
        user.setFirstName(userRepresentation.getFirstName());
        user.setLastName(userRepresentation.getLastName());
        user.setUserName(userRepresentation.getUserName());
        user.setEmail(userRepresentation.getEmail());
        user.setAddress(userRepresentation.getAddress());
        user.setPhoneNo(userRepresentation.getPhoneNo());
        user.setPassword(userRepresentation.getPassword());

        return user;
    }

    public Long getUserId() {
        return userId;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
