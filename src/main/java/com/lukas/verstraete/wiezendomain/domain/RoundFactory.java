package com.lukas.verstraete.wiezendomain.domain;

import com.lukas.verstraete.wiezendomain.domain.gametypes.*;
import java.util.List;


public class RoundFactory {
    
    public enum Type
    {
        SAMEN_8,
        SAMEN_9,
        SOLO_6,
        SAMEN_10,
        SOLO_7,
        SAMEN_11,
        KLEINE_MISERIE,
        SAMEN_12,
        SOLO_8,
        PICCOLO,
        SAMEN_13,
        ABONDANCE_9,
        TROEL,
        GROTE_MISERIE,
        ABONDANCE_10,
        ABONDANCE_11,
        BLOTE_MISERIE,
        KLEINE_SOLOSLIM,
        GROTE_SOLOSLIM;
    }
    
    public RoundFactory() {}
    
    public Round createRound(Type type, List<Player> allPlayers, List<Player> players, List<Player> opponents)
    {
        switch(type)
        {
            case SAMEN_8:
                return new Round(new GameType_Samen(players, opponents, 8), allPlayers);
            case SAMEN_9:
                return new Round(new GameType_Samen(players, opponents, 9), allPlayers);
            case SAMEN_10:
                return new Round(new GameType_Samen(players, opponents, 10), allPlayers);
            case SAMEN_11:
                return new Round(new GameType_Samen(players, opponents, 11), allPlayers);
            case SAMEN_12:
                return new Round(new GameType_Samen(players, opponents, 12), allPlayers);
            case SAMEN_13:
                return new Round(new GameType_Samen(players, opponents, 13), allPlayers);
            case SOLO_6:
                return new Round(new GameType_Solo(players, opponents, 6), allPlayers);
            case SOLO_7:
                return new Round(new GameType_Solo(players, opponents, 7), allPlayers);
            case SOLO_8:
                return new Round(new GameType_Solo(players, opponents, 8), allPlayers);
            case KLEINE_MISERIE:
                return new Round(new GameType_Miserie(players, opponents, 0, 18, 12, 18), allPlayers);
            case PICCOLO:
                return new Round(new GameType_Miserie(players, opponents, 1, 24, 16, 24), allPlayers);
            case GROTE_MISERIE:
                return new Round(new GameType_Miserie(players, opponents, 0, 36, 24, 36), allPlayers);
            case BLOTE_MISERIE:
                return new Round(new GameType_Miserie(players, opponents, 0, 75, 32, 48), allPlayers);
            case TROEL:
                return new Round(new GameType_Troel(players, opponents), allPlayers);
            case ABONDANCE_9:
                return new Round(new GameType_Abondance(players, opponents, 9, 32, 21), allPlayers);
            case ABONDANCE_10:
                return new Round(new GameType_Abondance(players, opponents, 10, 42, 25), allPlayers);
            case ABONDANCE_11:
                return new Round(new GameType_Abondance(players, opponents, 11, 60, 27), allPlayers);
            case KLEINE_SOLOSLIM:
                return new Round(new GameType_Abondance(players, opponents, 12, 100, 33), allPlayers);
            case GROTE_SOLOSLIM:
                return new Round(new GameType_Abondance(players, opponents, 13, 200, 66), allPlayers);
        }
        return null;
    }
}
