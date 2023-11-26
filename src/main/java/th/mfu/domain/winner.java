package th.mfu.domain;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity

public class winner {
     @Id
    private long id;  
    private String name;
    @OneToOne(cascade =CascadeType.ALL )
    private player player;
    public String getName() 
    {
        return name;
    }
    public player getPlayer()
    {
        return player;
    }
    public void setPlayer(player player) {
        this.player = player;
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

/*package th.mfu.domain;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import javax.persistence.Entity;

@Entity
public class Score
{
    @Id
    private long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    private game  game;

}*/
