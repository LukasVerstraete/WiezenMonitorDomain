package com.lukas.verstraete.wiezendomain.service;

import com.lukas.verstraete.wiezendomain.db.Database;
import com.lukas.verstraete.wiezendomain.db.DatabaseFactory;
import com.lukas.verstraete.wiezendomain.domain.Game;
import com.lukas.verstraete.wiezendomain.domain.Player;
import com.lukas.verstraete.wiezendomain.domain.Round;
import com.lukas.verstraete.wiezendomain.domain.Score;
import com.lukas.verstraete.wiezendomain.util.MemoryLocation;
import com.lukas.verstraete.wiezendomain.util.ServiceException;
import java.util.List;
import java.util.Map;

public class GameService
{
    
    private Database<Game> gameDatabase;
    private Database<Round> roundDatabase;
    
    public GameService(MemoryLocation location)
    {
        DatabaseFactory factory = new DatabaseFactory();
        gameDatabase = factory.getDatabase(location, Game.class);
        roundDatabase = factory.getDatabase(location, Round.class);
    }
    
    public long createGame() throws ServiceException 
    {
        try {
            Game game = new Game();
            gameDatabase.add(game);
            return game.getId();
        } 
        catch(Exception e)
        {
            throw new ServiceException(e.getMessage(), e);
        }
    }
    
    public void addPlayerToGame(long id, Player player) throws ServiceException
    {
        try
        {
            Game game = getGame(id);
            game.addPlayer(player);
            updateGame(game);
        }
        catch(Exception e)
        {
            throw new ServiceException(e.getMessage(), e);
        }
    }
    
    public void startRound(long id, Round round) throws ServiceException
    {
        try
        {
            Game game = getGame(id);
            game.newRound(round);
            updateGame(game);
        }
        catch(Exception e)
        {
            throw new ServiceException(e.getMessage(), e);
        }
    }
    
    public Map<Player,Score> endRound(long id, int wins) throws ServiceException
    {
        try
        {
            Map<Player,Score> scores;
            Game game = getGame(id);
            scores = game.endRound(wins);
            updateGame(game);
            return scores;
        }
        catch(Exception e)
        {
            throw new ServiceException(e.getMessage(), e);
        }
    }
    
    public void endGame(long id) throws ServiceException
    {
        try
        {
            Game game = getGame(id);
            game.endGame();
            updateGame(game);
        }
        catch(Exception e)
        {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public Game getGame(long id) throws ServiceException 
    {
        try
        {
            return gameDatabase.get(id);
        }
        catch(Exception e)
        {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public List<Game> getAllGames() throws ServiceException
    {
        try
        {
            return gameDatabase.getAll();
        }
        catch(Exception e)
        {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public void updateGame(Game game) throws ServiceException
    {
        try{
            gameDatabase.update(game);
        } 
        catch(Exception e)
        {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public void deleteGame(Game game) throws ServiceException
    {
        try{
            gameDatabase.delete(game);
        } 
        catch(Exception e)
        {
            throw new ServiceException(e.getMessage(), e);
        }
    }
    
    public void closeConnection() throws ServiceException
    {
        gameDatabase.closeConnection();
        roundDatabase.closeConnection();
    }
    
}