package com.enigmacamp.learnspring.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "customers")
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "full_name")
    private String fullName;
    @Column(unique = true,nullable = false)
    private String email;

    private String address;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "no_telp")
    private String noTelp;

    @CreatedDate
    @Column(updatable = false)
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss a",timezone = "Asia/Jakarta")
    private Date createdAt;

    @LastModifiedDate
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss a",timezone = "Asia/Jakarta")
    private Date updatedAt;

    @PrePersist
    private void createdDate(){
        if(getCreatedAt() == null) setCreatedAt(new Date());
        if(getUpdatedAt() == null) setUpdatedAt(new Date());
    }

    @PreUpdate
    private void updatedDate(){
        this.setUpdatedAt(new Date());
    }

    public Customers(Integer id, String fullName, String email, String address, Date birthDate, String noTelp, Date createdAt, Date updatedAt) {
        this.id = id;
        this.fullName= fullName;
        this.email = email;
        this.address = address;
        this.birthDate = birthDate;
        this.noTelp = noTelp;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Customers(){};

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return fullName;
    }

    public void setFirstName(String firstName) {
        this.fullName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return fullName;
    }

    public void setLastName(String lastName) {
        this.fullName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }
}
