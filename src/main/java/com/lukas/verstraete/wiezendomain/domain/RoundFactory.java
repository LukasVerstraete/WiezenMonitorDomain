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
    
    public Round createRound(Type type, List<Player> players, List<Player> opponents)
    {
        switch(type)
        {
            case SAMEN_8:
                return new Round(new GameType_Samen(players, opponents, 8));
            case SAMEN_9:
                return new Round(new GameType_Samen(players, opponents, 9));
            case SAMEN_10:
                return new Round(new GameType_Samen(players, opponents, 10));
            case SAMEN_11:
                return new Round(new GameType_Samen(players, opponents, 11));
            case SAMEN_12:
                return new Round(new GameType_Samen(players, opponents, 12));
            case SAMEN_13:
                return new Round(new GameType_Samen(players, opponents, 13));
            case SOLO_6:
                return new Round(new GameType_Solo(players, opponents, 6));
            case SOLO_7:
                return new Round(new GameType_Solo(players, opponents, 7));
            case SOLO_8:
                return new Round(new GameType_Solo(players, opponents, 8));
            case KLEINE_MISERIE:
                return new Round(new GameType_Miserie(players, opponents, 0, 18, 12, 18));
            case PICCOLO:
                return new Round(new GameType_Miserie(players, opponents, 1, 24, 16, 24));
            case GROTE_MISERIE:
                return new Round(new GameType_Miserie(players, opponents, 0, 36, 24, 36));
            case BLOTE_MISERIE:
                return new Round(new GameType_Miserie(players, opponents, 0, 75, 32, 48));
            case TROEL:
                return new Round(new GameType_Troel(players, opponents));
            case ABONDANCE_9:
                return new Round(new GameType_Abondance(players, opponents, 9, 32, 21));
            case ABONDANCE_10:
                return new Round(new GameType_Abondance(players, opponents, 10, 42, 25));
            case ABONDANCE_11:
                return new Round(new GameType_Abondance(players, opponents, 11, 60, 27));
            case KLEINE_SOLOSLIM:
                return new Round(new GameType_Abondance(players, opponents, 12, 100, 33));
            case GROTE_SOLOSLIM:
                return new Round(new GameType_Abondance(players, opponents, 13, 200, 66));
        }
        return null;
    }
}
