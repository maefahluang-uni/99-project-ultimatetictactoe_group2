package th.mfu;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class player {
     @Id
    private long id;  
    private String name;

    public String getName() {
        return name;
    }

    public player(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public player(){

    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    
}