

package th.mfu.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class game
 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public long getId() 
    {
        return id;
    }

    public void setId(long id) 
    {
       this.id=id;
    }
 
}
/*package th.mfu.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Gameboard
 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public long getId() 
    {
        return id;
    }

    public void setId(long id) 
    {
       this.id=id;
    }
 
} */