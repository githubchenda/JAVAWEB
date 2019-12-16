package com.example.testone.demo;

import java.io.Serializable;
import java.util.Date;
@SuppressWarnings("serial")

public class Users implements Serializable {

    private String id;
    private String nickname;
    private String mobile;
    private String password;
    private String role;
    private String mail;
    private String address;

    public String getId(){
        return id;
    }


    public void setId(String id){
        this.id = id;
    }


    public String getNickname(){
        return nickname;
    }


    public void setNickname(String nickname){
        this.nickname =nickname;
    }

    public String getMobile(){
        return mobile;
    }


    public void setMobile(String mobile){
        this.mobile =mobile;
    }

    public String getPassword(){
        return password;
    }


    public void setPassword(String password){
        this.password=password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public String getMail() {
        return mail;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
