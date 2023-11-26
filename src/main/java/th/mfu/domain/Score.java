package th.mfu.domain;

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

}
