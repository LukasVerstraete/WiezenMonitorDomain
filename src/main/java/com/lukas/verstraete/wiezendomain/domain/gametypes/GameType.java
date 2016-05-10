package com.lukas.verstraete.wiezendomain.domain.gametypes;

import com.lukas.verstraete.wiezendomain.domain.Player;
import com.lukas.verstraete.wiezendomain.domain.Score;
import java.io.Serializable;
import java.util.List;
import java.util.Map;


public interface GameType {
    
    public abstract Map<Player,Score> getScores(List<Player> players, List<Player> opponents, int wins);
}
