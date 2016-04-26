package com.lukas.verstraete.wiezendomain.domain;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Score implements Serializable {
    
    @Id
    @GeneratedValue
    private long id;
    private int points;
    
    public Score()
    {
        this(0);
    }
    
    public Score(int points)
    {
        this.points = points;
    }
    
    public int getPoints()
    {
        return points;
    }
    
    public void setPoints(int points)
    {
        this.points = points;
    }
    
    public int add(int points)
    {
        return this.points + points;
    }
    
    public int subtract(int points)
    {
        return this.points - points;
    }
    
    public int multiply(int points)
    {
        return this.points * points;
    }
    
    public int divide(int points)
    {
        return this.points / points;
    }
    
    public int add(Score score)
    {
        return add(score.getPoints());
    }
    
    public int subtract(Score score)
    {
        return subtract(score.getPoints());
    }
    
    public int multiply(Score score)
    {
        return multiply(score.getPoints());
    }
    
    public int divide(Score score)
    {
        return divide(score.getPoints());
    }
}
