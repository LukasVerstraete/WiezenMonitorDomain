package com.lukas.verstraete.wiezendomain.service;

import com.lukas.verstraete.wiezendomain.db.Database;
import com.lukas.verstraete.wiezendomain.db.DatabaseFactory;
import com.lukas.verstraete.wiezendomain.domain.Player;
import com.lukas.verstraete.wiezendomain.util.MemoryLocation;
import com.lukas.verstraete.wiezendomain.util.ServiceException;
import java.util.List;

public class PlayerService
{
    
    private Database<Player> database;
    
    public PlayerService(MemoryLocation location)
    {
        DatabaseFactory factory = new DatabaseFactory();
        database = factory.getDatabase(location, Player.class);
    }
    
    public void add(Player player) throws ServiceException 
    {
        try{
            database.add(player);
        } 
        catch(Exception e)
        {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public Player get(long id) throws ServiceException 
    {
        try
        {
            return database.get(id);
        }
        catch(Exception e)
        {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public List<Player> getAll() throws ServiceException
    {
        try
        {
            return database.getAll();
        }
        catch(Exception e)
        {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public void update(Player player) throws ServiceException
    {
        try{
            database.update(player);
        } 
        catch(Exception e)
        {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public void delete(Player player) throws ServiceException
    {
        try{
            database.delete(player);
        } 
        catch(Exception e)
        {
            throw new ServiceException(e.getMessage(), e);
        }
    }
    
    public void closeConnection() throws ServiceException
    {
        database.closeConnection();
    }
}