package com.lukas.verstraete.wiezendomain.db;

import com.lukas.verstraete.wiezendomain.domain.Game;
import com.lukas.verstraete.wiezendomain.domain.Player;
import com.lukas.verstraete.wiezendomain.domain.RoundFactory;
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
        
        //Creating dummy data.
        
//        Game game = new Game();
//        Player p1 = new Player();
//        p1.setUsername("Lukas");
//        Player p2 = new Player();
//        p2.setUsername("Cedric");
//        Player p3 = new Player();
//        p3.setUsername("Nico");
//        Player p4 = new Player();
//        p4.setUsername("Boubleize");
//        game.addPlayer(p1);
//        game.addPlayer(p2);
//        game.addPlayer(p3);
//        game.addPlayer(p4);
//        List<Player> players = new ArrayList<>();
//        players.add(p3);
//        players.add(p4);
//        List<Player> opponents = new ArrayList<>();
//        opponents.add(p1);
//        opponents.add(p2);
//        RoundFactory rFactory = new RoundFactory();
//        game.newRound(rFactory.createRound(RoundFactory.Type.TROEL, players, opponents));
//        game.endRound(9);
//        game.newRound(rFactory.createRound(RoundFactory.Type.SAMEN_10, players, opponents));
//        game.endRound(8);
//        game.endGame();
//        add(game);
        
        /////////////////////////////////
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