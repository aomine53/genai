package com.genai.ecommerce.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password; // You should hash passwords in a real implementation

    @Column(nullable = false)
    private String email;

    @Column
    private String otp;

    @Column
    private LocalDateTime otpExpiration;

    @Column
    private String phoneNumber;

    // Constructors, getters, setters


    public User() {
    }

    public User(Long id, String username, String password, String email, String otp, LocalDateTime otpExpiration, String phoneNumber) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.otp = otp;
        this.otpExpiration = otpExpiration;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public LocalDateTime getOtpExpiration() {
        return otpExpiration;
    }

    public void setOtpExpiration(LocalDateTime otpExpiration) {
        this.otpExpiration = otpExpiration;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setOtpSentTime(LocalDateTime now) {
        this.otpExpiration = now;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", otp='" + otp + '\'' +
                ", otpExpiration=" + otpExpiration +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
