package com.lukas.verstraete.wiezendomain.domain.gametypes;

import com.lukas.verstraete.wiezendomain.domain.Player;
import com.lukas.verstraete.wiezendomain.domain.Score;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameType_Troel implements GameType, Serializable {
    
    protected int goal = 9;
    protected int points = 16;
    protected int points_double = 30;
    
    public GameType_Troel() {
    }

    @Override
    public Map<Player, Score> getScores(List<Player> players, List<Player> opponents, int wins) {
        Score playersScore = new Score();
        Score opponentsScore = new Score();
        wins = wins < 0 ? 0 : wins;
        if(goal <= wins)
        {
            playersScore.setPoints(points);
            if(wins >= 13) playersScore.setPoints(points_double);
            opponentsScore.setPoints(0);
        }
        else
        {
            playersScore.setPoints(0);
            opponentsScore.add(points);
        }
        HashMap<Player,Score> scores = new HashMap<>();
        for(Player p : players) scores.put(p, playersScore);
        for(Player p : opponents) scores.put(p, opponentsScore);
        return scores;
    }
    
}
