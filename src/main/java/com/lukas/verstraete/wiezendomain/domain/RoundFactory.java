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
                return new Round(new GameType_Samen(8), allPlayers, players, opponents);
            case SAMEN_9:
                return new Round(new GameType_Samen(9), allPlayers, players, opponents);
            case SAMEN_10:
                return new Round(new GameType_Samen(10), allPlayers, players, opponents);
            case SAMEN_11:
                return new Round(new GameType_Samen(11), allPlayers, players, opponents);
            case SAMEN_12:
                return new Round(new GameType_Samen(12), allPlayers, players, opponents);
            case SAMEN_13:
                return new Round(new GameType_Samen(13), allPlayers, players, opponents);
            case SOLO_6:
                return new Round(new GameType_Solo(6), allPlayers, players, opponents);
            case SOLO_7:
                return new Round(new GameType_Solo(7), allPlayers, players, opponents);
            case SOLO_8:
                return new Round(new GameType_Solo(8), allPlayers, players, opponents);
            case KLEINE_MISERIE:
                return new Round(new GameType_Miserie(0, 18, 12, 18), allPlayers, players, opponents);
            case PICCOLO:
                return new Round(new GameType_Miserie(1, 24, 16, 24), allPlayers, players, opponents);
            case GROTE_MISERIE:
                return new Round(new GameType_Miserie(0, 36, 24, 36), allPlayers, players, opponents);
            case BLOTE_MISERIE:
                return new Round(new GameType_Miserie(0, 75, 32, 48), allPlayers, players, opponents);
            case TROEL:
                return new Round(new GameType_Troel(), allPlayers, players, opponents);
            case ABONDANCE_9:
                return new Round(new GameType_Abondance(9, 32, 21), allPlayers, players, opponents);
            case ABONDANCE_10:
                return new Round(new GameType_Abondance(10, 42, 25), allPlayers, players, opponents);
            case ABONDANCE_11:
                return new Round(new GameType_Abondance(11, 60, 27), allPlayers, players, opponents);
            case KLEINE_SOLOSLIM:
                return new Round(new GameType_Abondance(12, 100, 33), allPlayers, players, opponents);
            case GROTE_SOLOSLIM:
                return new Round(new GameType_Abondance(13, 200, 66), allPlayers, players, opponents);
        }
        return null;
    }
}
