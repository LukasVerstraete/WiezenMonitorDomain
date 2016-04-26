package com.lukas.verstraete.wiezendomain.db;

import com.lukas.verstraete.wiezendomain.domain.Player;
import com.lukas.verstraete.wiezendomain.domain.Round;
import com.lukas.verstraete.wiezendomain.util.DatabaseException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class RemoteRoundDatabase implements Database<Round>
{
    
    private EntityManagerFactory factory;
    private EntityManager entityManager;
    
    public RemoteRoundDatabase(String pu) throws DatabaseException
    {
        factory = Persistence.createEntityManagerFactory(pu);
        entityManager = factory.createEntityManager();
    }
    
    @Override
    public void add(Round round) throws DatabaseException {
        try
        {
            entityManager.getTransaction().begin();
            entityManager.persist(round);
            entityManager.flush();
            entityManager.getTransaction().commit();
        }
        catch(Exception e)
        {
            throw new DatabaseException(e.getMessage(), e);
        }
    }

    @Override
    public void update(Round round) throws DatabaseException {
        try
        {
            entityManager.getTransaction().begin();
            entityManager.merge(round);
            entityManager.flush();
            entityManager.getTransaction().commit();
        }
        catch(Exception e)
        {
            throw new DatabaseException(e.getMessage(), e);
        }
    }

    @Override
    public Round get(Object id) throws DatabaseException {
        try
        {
            return entityManager.find(Round.class, (Long)id);
        }
        catch(Exception e)
        {
            throw new DatabaseException(e.getMessage(), e);
        }
    }

    @Override
    public List<Round> getAll() throws DatabaseException {
        try
        {
            Query query = entityManager.createQuery("select round from Round round");
            return new ArrayList<Round>(query.getResultList());
        }
        catch(Exception e)
        {
            throw new DatabaseException(e.getMessage(), e);
        }
    }

    @Override
    public void delete(Round round) throws DatabaseException {
        try
        {
            entityManager.getTransaction().begin();
            entityManager.remove(round);
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