package com.lukas.verstraete.wiezendomain.ui;

import com.lukas.verstraete.wiezendomain.domain.Player;
import com.lukas.verstraete.wiezendomain.domain.RoundFactory;
import com.lukas.verstraete.wiezendomain.service.GameService;
import com.lukas.verstraete.wiezendomain.service.PlayerService;
import com.lukas.verstraete.wiezendomain.util.MemoryLocation;
import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args)
    {
        PlayerService playerService = new PlayerService(MemoryLocation.REMOTE);
        GameService gameService = new GameService(MemoryLocation.REMOTE);
        RoundFactory factory = new RoundFactory();
        
        Player player1 = createPlayer();
        Player player2 = createPlayer();
        Player player3 = createPlayer();
        Player player4 = createPlayer();
        
        playerService.add(player1);
        playerService.add(player2);
        playerService.add(player3);
        playerService.add(player4);
        
        long gameId = gameService.createGame();
        gameService.addPlayerToGame(gameId, player1);
        gameService.addPlayerToGame(gameId, player2);
        gameService.addPlayerToGame(gameId, player3);
        gameService.addPlayerToGame(gameId, player4);
        
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        ArrayList<Player> opponents = new ArrayList<>();
        opponents.add(player2);
        opponents.add(player3);
        opponents.add(player4);
        
        gameService.startRound(gameId, factory.createRound(RoundFactory.Type.PICCOLO, players, opponents, gameService.getGame(gameId).getPlayers()));
        
        gameService.endRound(gameId, 0);
        
        gameService.deleteGame(gameService.getGame(gameId));
        
        playerService.closeConnection();
        gameService.closeConnection();
    }
    
    
    private static Player createPlayer()
    {
        Player player = new Player();
        player.setUsername("Lukas");
        return player;
    }
}
