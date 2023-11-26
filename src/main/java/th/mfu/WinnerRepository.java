package th.mfu;
import org.springframework.data.repository.CrudRepository;
import th.mfu.domain.winner;
public interface WinnerRepository  extends CrudRepository<winner, Long>{
    
}
