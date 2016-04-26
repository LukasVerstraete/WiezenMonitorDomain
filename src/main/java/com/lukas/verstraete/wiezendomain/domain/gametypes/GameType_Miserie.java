package com.lukas.verstraete.wiezendomain.domain.gametypes;

import com.lukas.verstraete.wiezendomain.domain.Player;
import com.lukas.verstraete.wiezendomain.domain.Score;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameType_Miserie extends GameType {

    protected int goal;
    protected int points_max;
    protected int points_opponent_one;
    protected int points_opponent_two;
    
    public GameType_Miserie(List<Player> players, List<Player> opponents, int allowedWins, int points, int pointsOpponentOne, int pointsOpponentTwo) {
        super(players, opponents);
        setGoals(allowedWins);
        setPoints_max(points);
        setPoints_opponent_one(points_opponent_one);
        setPoints_opponent_two(points_opponent_two);
    }

    public void setGoals(int goal) {
        if(goal < 0) goal = 0;
        this.goal = goal;
    }

    public void setPoints_max(int points_max) {
        this.points_max = points_max;
    }

    public void setPoints_opponent_one(int points_opponent_one) {
        this.points_opponent_one = points_opponent_one;
    }

    public void setPoints_opponent_two(int points_opponent_two) {
        this.points_opponent_two = points_opponent_two;
    }

    @Override
    public Map<Player, Score> getScores(int wins) {
        Score playersScore = new Score();
        Score opponentsScore = new Score();
        wins = wins < 0 ? 0 : wins;
        if(goal == wins)
        {
            playersScore.setPoints(points_max);
            opponentsScore.setPoints(0);
        }
        else
        {
            playersScore.subtract(points_max);
            opponentsScore.add(points_opponent_one);
            if(wins - goal > 1) opponentsScore.add(points_opponent_two);
        }
        HashMap<Player,Score> scores = new HashMap<>();
        for(Player p : players) scores.put(p, playersScore);
        for(Player p : opponents) scores.put(p, opponentsScore);
        return scores;
    }
    
}
