package com.narij.narijsocialnetwork.model;

/**
 * Created by kami on 8/20/2017.
 */

public class Member {

    private long memberId;
    private String fullName;
    private String phone;
    private String email;
    private String password;
    private boolean active;
    private String verificationCode;


    public Member() {
    }

    public Member(long memberId, String fullName, String phone, String email, String password, boolean active, String verificationCode) {
        this.memberId = memberId;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.active = active;
        this.verificationCode = verificationCode;
    }


    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }
}
