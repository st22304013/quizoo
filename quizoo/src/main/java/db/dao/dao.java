package db.dao; 
public abstract class Dao { 
    protected static Connection cn; 
    public abstract void connect(); 
    public abstract void close(); 
} 
