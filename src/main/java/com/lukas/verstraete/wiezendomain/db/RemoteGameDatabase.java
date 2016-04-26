package com.lukas.verstraete.wiezendomain.db;

import com.lukas.verstraete.wiezendomain.domain.Game;
import com.lukas.verstraete.wiezendomain.domain.Player;
import com.lukas.verstraete.wiezendomain.util.DatabaseException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class RemoteGameDatabase implements Database<Game>
{

    private EntityManagerFactory factory;
    private EntityManager entityManager;
    
    public RemoteGameDatabase(String pu) throws DatabaseException
    {
        factory = Persistence.createEntityManagerFactory(pu);
        entityManager = factory.createEntityManager();
    }
    
    @Override
    public void add(Game game) throws DatabaseException {
        try
        {
            entityManager.getTransaction().begin();
            entityManager.persist(game);
            entityManager.flush();
            entityManager.getTransaction().commit();
        }
        catch(Exception e)
        {
            throw new DatabaseException(e.getMessage(), e);
        }
    }

    @Override
    public void update(Game game) throws DatabaseException {
        try
        {
            entityManager.getTransaction().begin();
            entityManager.merge(game);
            entityManager.flush();
            entityManager.getTransaction().commit();
        }
        catch(Exception e)
        {
            throw new DatabaseException(e.getMessage(), e);
        }
    }

    @Override
    public Game get(Object id) throws DatabaseException {
        try
        {
            return entityManager.find(Game.class, (Long)id);
        }
        catch(Exception e)
        {
            throw new DatabaseException(e.getMessage(), e);
        }
    }

    @Override
    public List<Game> getAll() throws DatabaseException {
        try
        {
            Query query = entityManager.createQuery("select game from Game game");
            return new ArrayList<Game>(query.getResultList());
        }
        catch(Exception e)
        {
            throw new DatabaseException(e.getMessage(), e);
        }    
    }

    @Override
    public void delete(Game game) throws DatabaseException {
        try
        {
            entityManager.getTransaction().begin();
            entityManager.remove(game);
            entityManager.flush();
            entityManager.getTransaction().commit();
        }
        catch(Exception e)
        {
            throw new DatabaseException(e.getMessage(), e);
        }
    }

    @Override
    public void closeConnection() throws DatabaseException {
        try
        {
            entityManager.close();
            factory.close();
        }
        catch(Exception e)
        {
            throw new DatabaseException(e.getMessage(), e);
        }
    }
    
}