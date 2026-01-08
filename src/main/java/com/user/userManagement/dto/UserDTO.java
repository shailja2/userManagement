package com.user.userManagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UserDTO {

    @NotEmpty

    private String name;
    @NotEmpty(message = "Email should not be empty!")
    @Email
    private String email;
    @NotEmpty
    @Size(min = 4, max = 10, message = "Password has to be minimum 4 characters")
    private String pwd;
    private String phoneNo;
    private String usrAddress;
    private Long userId;
    @NotBlank(message = "Role is required")
    private String role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getUsrAddress() {
        return usrAddress;
    }

    public void setUsrAddress(String usrAddress) {
        this.usrAddress = usrAddress;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
