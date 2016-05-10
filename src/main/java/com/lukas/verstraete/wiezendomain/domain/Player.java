package com.lukas.verstraete.wiezendomain.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Player implements Serializable {
    
    @Id
    @GeneratedValue
    private long id;
    
    @NotEmpty(message = "Choose a name for this player.")
    private String username;
    
    @NotNull(message = "The score for this player can not be null.")
    @OneToOne(cascade = CascadeType.PERSIST)
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

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
    
    public String toString()
    {
        return "ID: " + id + "  username: " + username;
    }
    
    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = result*prime + username.hashCode();
        result = result*prime + ((Long)id).hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }
}
