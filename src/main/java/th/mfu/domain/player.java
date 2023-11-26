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

    public player()
    {

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

/*package th.mfu;

import java.util.Date;
@Entity
public class Player {
    
    //TODO: add attributes
    private int id;
    private int number;
    private Date date;
    private String description;

    public Player() {
    }

    public Player(int id, String description) {
        //TODO: set attributes
        this.id=id;
        this.description=description;
    }

    //TODO: add getters and setters for all attributes
    // You can use Source action/generate getter setter function
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
     public int getNumber() {
        return number;
    }
    public void setNumber(int no) {
        this.number = no;
    }

    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
 

} */
