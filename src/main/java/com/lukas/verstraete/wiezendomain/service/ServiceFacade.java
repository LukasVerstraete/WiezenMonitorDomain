package com.lukas.verstraete.wiezendomain.service;

import com.lukas.verstraete.wiezendomain.domain.Game;
import com.lukas.verstraete.wiezendomain.domain.Player;
import com.lukas.verstraete.wiezendomain.domain.Round;
import com.lukas.verstraete.wiezendomain.domain.Score;
import com.lukas.verstraete.wiezendomain.util.MemoryLocation;
import com.lukas.verstraete.wiezendomain.util.ServiceException;
import java.util.List;
import java.util.Map;

public class ServiceFacade {
        
    private PlayerService playerService;
    private GameService gameService;
    
    public ServiceFacade(MemoryLocation location)
    {
        playerService = new PlayerService(location);
        gameService = new GameService(location);
    }
    
    //playerService methods.
    public void addPlayer(Player player) throws ServiceException
    {
        playerService.add(player);
    }
    
    public Player getPlayer(long id) throws ServiceException
    {
        return playerService.get(id);
    }
    
    public List<Player> getAllPlayers() throws ServiceException
    {
        return playerService.getAll();
    }
    
    public void updatePlayer(Player player) throws ServiceException
    {
        playerService.update(player);
    }
    
    public void deletePlayer(Player player) throws ServiceException
    {
        playerService.delete(player);
    }
    
    //gameService methods
    
    public long createGame() throws ServiceException
    {
        return gameService.createGame();
    }
    
    public void addPlayerToGame(long gameId, Player player) throws ServiceException
    {
        gameService.addPlayerToGame(gameId, player);
    }
    
    public void startRound(long gameId, Round round) throws ServiceException
    {
        gameService.startRound(gameId, round);
    }
    
    public Map<Player,Score> endRound(long gameId, int wins) throws ServiceException
    {
        return gameService.endRound(gameId, wins);
    }
    
    public void endGame(long gameId) throws ServiceException
    {
        gameService.endGame(gameId);
    }
    
    public Game getGame(long id) throws ServiceException
    {
        return gameService.getGame(id);
    }
    
    public List<Game> getAllGames() throws ServiceException
    {
        return gameService.getAllGames();
    }
    
    public void deleteGame(Game game) throws ServiceException
    {
        gameService.deleteGame(game);
    }
    
    public void closeConnection() throws ServiceException
    {
        playerService.closeConnection();
        gameService.closeConnection();
    }
}
