package th.mfu.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class player 
{
     @Id
    private long id;  
    private String name;

    @ManyToOne(cascade = CascadeType.MERGE)
    private game  game;

    public String getName() 
    {
        return name;
    }

    

    public player(long id, String name) 
    {
        this.id = id;
        this.name = name;
    }

    public player(){

    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public long getId() 
    {
        return id;
    }

    public void setId(long id) 
    {
        this.id = id;
    }

    
}