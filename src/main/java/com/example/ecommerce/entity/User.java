package com.example.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private int id;
    private String userid;
    private String password;
    private String name;
    private String surname;
    private String houseid;
    private String road;
    private String province;
    private String postid;

    public User() {
    }

    public User(int id, String userId, String password, String name, String surname, String houseId, String road, String province, String postId) {
        this.id = id;
        this.userid = userId;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.houseid = houseId;
        this.road = road;
        this.province = province;
        this.postid = postId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userid;
    }

    public void setUserId(String userId) {
        this.userid = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getHouseId() {
        return houseid;
    }

    public void setHouseId(String houseId) {
        this.houseid = houseId;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostId() {
        return postid;
    }

    public void setPostId(String postId) {
        this.postid = postId;
    }
}
