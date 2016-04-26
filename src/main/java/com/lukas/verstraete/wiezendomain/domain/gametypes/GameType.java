package com.lukas.verstraete.wiezendomain.domain.gametypes;

import com.lukas.verstraete.wiezendomain.domain.Player;
import com.lukas.verstraete.wiezendomain.domain.Score;
import java.util.List;
import java.util.Map;


public abstract class GameType {
    protected List<Player> players;
    protected List<Player> opponents;
    
    public GameType(List<Player> players, List<Player> opponents)
    {
        setPlayers(players);
        setOpponents(opponents);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Player> getOpponents() {
        return opponents;
    }

    public void setOpponents(List<Player> opponents) {
        this.opponents = opponents;
    }
    
    public abstract Map<Player,Score> getScores(int wins);
}
