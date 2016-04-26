package com.lukas.verstraete.wiezendomain.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Game implements Serializable{
    
    public enum GameState
    {
        STARTING,
        STARTED,
        FINISHED
    }
    
    @Id
    @GeneratedValue
    private long id;
    private List<Player> players;
    private GameState state;
    private List<Round> rounds;
    private Round currentRound;
    
    public Game() 
    {
        players = new ArrayList<>();
        state = GameState.STARTING;
        rounds = new ArrayList<>();
        currentRound = null;
    }
    
    public long getId()
    {
        return id;
    }
    
    public void setId(long id)
    {
        this.id = id;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public void setRounds(List<Round> rounds) {
        this.rounds = rounds;
    }
    
    public Round getCurrentRound()
    {
        return currentRound;
    }
    
    public void setCurrentRound(Round currentRound)
    {
        this.currentRound = currentRound;
    }
    
    public void addPlayer(Player player)
    {
        if(state == GameState.STARTING)
            players.add(player);
    }
    
    public void newRound(Round round)
    {
        if(state == GameState.STARTING)
        {
            currentRound = round;
            state = GameState.STARTED;
        }
    }
    
    public void endRound()
    {
        if(state == GameState.STARTED)
        {
            state = GameState.STARTING;
            rounds.add(currentRound);
            currentRound = null;
        }
    }
    
    public void endGame()
    {
        endRound();
        state = GameState.FINISHED;
    }
}
