package th.mfu.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long gameId;


    public long getId() {
        return gameId;
    }

    public void setId(long gameId) {
        this.gameId = gameId;
    }
 
}
