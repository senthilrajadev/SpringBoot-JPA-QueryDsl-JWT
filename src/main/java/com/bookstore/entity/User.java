package com.bookstore.entity;

import com.bookstore.common.Constant;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String gender;
    @Column(name="email_id")
    private String emailId;
    @Column(name="phone_number")
    private String phoneNumber;
    @Column(name="user_type")
    private String userType = Constant.USER_TYPE.USER;
    private String password;
    @Column(name="is_active")
    private Boolean isActive = true;
    @Column(name="login_count")
    private Integer loginCount = 0;
    @Column(name="sso_type")
    private String ssoType;
    @Column(name="login_at")
    private LocalDateTime loginAt;
    @Column(name="created_at")
    private LocalDateTime createdAt;
    @Column(name="updated_at")
    private LocalDateTime updatedAt;
    public User() {
    }

    public User(Long id, String name, String gender, String emailId, String phoneNumber, String userType, String password, Boolean isActive, Integer loginCount, String ssoType, LocalDateTime loginAt, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
        this.password = password;
        this.isActive = isActive;
        this.loginCount = loginCount;
        this.ssoType = ssoType;
        this.loginAt = loginAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    public String getSsoType() {
        return ssoType;
    }

    public void setSsoType(String ssoType) {
        this.ssoType = ssoType;
    }

    public LocalDateTime getLoginAt() {
        return loginAt;
    }

    public void setLoginAt(LocalDateTime loginAt) {
        this.loginAt = loginAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @PrePersist
    public void onSave(){
        LocalDateTime localDateTime = LocalDateTime.now();
        this.createdAt = localDateTime;
        this.updatedAt = localDateTime;
    }

    @PostPersist
    public  void onUpdate(){
        LocalDateTime localDateTime = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();

    }



}
