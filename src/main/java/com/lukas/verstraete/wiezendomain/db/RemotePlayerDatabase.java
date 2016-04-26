package com.lukas.verstraete.wiezendomain.db;

import com.lukas.verstraete.wiezendomain.domain.Player;
import com.lukas.verstraete.wiezendomain.util.DatabaseException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class RemotePlayerDatabase implements Database<Player>
{
    
    private EntityManagerFactory factory;
    private EntityManager entityManager;
    
    public RemotePlayerDatabase(String pu) throws DatabaseException
    {
        factory = Persistence.createEntityManagerFactory(pu);
        entityManager = factory.createEntityManager();
    }
    
    @Override
    public void add(Player player) throws DatabaseException {
        try
        {
            entityManager.getTransaction().begin();
            entityManager.persist(player);
            entityManager.flush();
            entityManager.getTransaction().commit();
        }
        catch(Exception e)
        {
            throw new DatabaseException(e.getMessage(), e);
        }
    }

    @Override
    public void update(Player player) throws DatabaseException {
        try
        {
            entityManager.getTransaction().begin();
            entityManager.merge(player);
            entityManager.flush();
            entityManager.getTransaction().commit();
        }
        catch(Exception e)
        {
            throw new DatabaseException(e.getMessage(), e);
        }
    }

    @Override
    public Player get(Object id) throws DatabaseException {
        try
        {
            return entityManager.find(Player.class, (Long)id);
        }
        catch(Exception e)
        {
            throw new DatabaseException(e.getMessage(), e);
        }
    }

    @Override
    public List<Player> getAll() throws DatabaseException {
        try
        {
            Query query = entityManager.createQuery("select player from Player player");
            return new ArrayList<Player>(query.getResultList());
        }
        catch(Exception e)
        {
            throw new DatabaseException(e.getMessage(), e);
        }    
    }

    @Override
    public void delete(Player player) throws DatabaseException {
        try
        {
            entityManager.getTransaction().begin();
            entityManager.remove(player);
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