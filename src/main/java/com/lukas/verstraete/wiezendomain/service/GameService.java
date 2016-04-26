package com.lukas.verstraete.wiezendomain.service;

import com.lukas.verstraete.wiezendomain.db.Database;
import com.lukas.verstraete.wiezendomain.db.DatabaseFactory;
import com.lukas.verstraete.wiezendomain.domain.Game;
import com.lukas.verstraete.wiezendomain.domain.Player;
import com.lukas.verstraete.wiezendomain.domain.Round;
import com.lukas.verstraete.wiezendomain.util.MemoryLocation;
import com.lukas.verstraete.wiezendomain.util.ServiceException;
import java.util.List;

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
    
    public void addPlayerToGame(long id, Player player)
    {
        try
        {
            Game game = get(id);
            game.addPlayer(player);
            update(game);
        }
        catch(Exception e)
        {
            
        }
    }

    public Game get(long id) throws ServiceException 
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

    public List<Game> getAll() throws ServiceException
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

    public void update(Game game) throws ServiceException
    {
        try{
            gameDatabase.update(game);
        } 
        catch(Exception e)
        {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public void delete(Game game) throws ServiceException
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