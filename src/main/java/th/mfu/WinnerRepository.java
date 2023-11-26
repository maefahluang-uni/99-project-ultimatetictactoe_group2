package th.mfu;
import th.mfu.domain.winner;
import org.springframework.data.repository.CrudRepository;
public interface WinnerRepository  extends CrudRepository<winner, Long>
{
    
}
