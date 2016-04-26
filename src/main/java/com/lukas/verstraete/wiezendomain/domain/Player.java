package com.lukas.verstraete.wiezendomain.domain;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Player implements Serializable {
    
    @Id
    @GeneratedValue
    private long id;
    private String username;
    private String name;
    private String familyName;
    private String password;
    
    private Score score;
    
    public Player()
    {
        score = new Score();
    }
    
    public long getId() 
    {
        return id;
    }

    public void setId(long id) 
    {
        //this.id = id;
    }

    public String getUsername() 
    {
        return username;
    }

    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getFamilyName() 
    {
        return familyName;
    }

    public void setFamilyName(String familyName) 
    {
        this.familyName = familyName;
    }

    public String getPassword() 
    {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
}
