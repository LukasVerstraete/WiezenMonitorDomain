package com.lukas.verstraete.wiezendomain.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
        if(state == GameState.STARTING && players.size() >= 4)
        {
            currentRound = round;
            state = GameState.STARTED;
        }
    }
    
    public Map<Player,Score> endRound(int wins)
    {
        if(state == GameState.STARTED)
        {
            state = GameState.STARTING;
            rounds.add(currentRound);
            Map<Player,Score> scores = currentRound.getScores(wins);
            currentRound = null;
            return scores;
        }
        return null;
    }
    
    public void endGame()
    {
        currentRound = null;
        state = GameState.FINISHED;
    }
}
