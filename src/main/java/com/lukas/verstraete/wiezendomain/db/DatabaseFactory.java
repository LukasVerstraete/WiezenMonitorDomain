package com.lukas.verstraete.wiezendomain.db;

import com.lukas.verstraete.wiezendomain.domain.*;
import com.lukas.verstraete.wiezendomain.util.DatabaseException;
import com.lukas.verstraete.wiezendomain.util.MemoryLocation;



public class DatabaseFactory {
    
    public DatabaseFactory() {}
    
    public Database getDatabase(MemoryLocation location, Class type) throws DatabaseException
    {
        Database database = null;
//        if(location == MemoryLocation.LOCAL)
//            database = getLocalDatabase(type);
        if(location == MemoryLocation.REMOTE)
            database = getRemoteDatabase(type);
        return database;
    }
    
//    private Database getLocalDatabase(Class type) throws DatabaseException
//    {
//        if(type.getCanonicalName().equals(Player.class.getCanonicalName()))
//            return new LocalPlayerDatabase();
//        else if(type.getCanonicalName().equals(Game.class.getCanonicalName()))
//            return new LocalGameDatabase();
//        else
//            throw new DatabaseException("Undefined database classtype: " + type.getSimpleName());
//    }
    
    private Database getRemoteDatabase(Class type)
    {
        if(type.getCanonicalName().equals(Player.class.getCanonicalName()))
            return new RemotePlayerDatabase("DomainMonitorPU");
        else if(type.getCanonicalName().equals(Game.class.getCanonicalName()))
            return new RemoteGameDatabase("DomainMonitorPU");
        else if(type.getCanonicalName().equals(Round.class.getCanonicalName()))
            return new RemoteRoundDatabase("DomainMonitorPU");
        else
            throw new DatabaseException("Undefined database classtype: " + type.getSimpleName());
    }
}
