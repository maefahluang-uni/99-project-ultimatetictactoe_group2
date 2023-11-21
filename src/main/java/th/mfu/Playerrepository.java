package th.mfu;

import org.springframework.data.repository.CrudRepository;

import th.mfu.domain.player;

public interface Playerrepository  extends CrudRepository<player, Long>{
    
}
