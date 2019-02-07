package lab3.demo.Repository;
import  lab3.demo.Entity.Emergency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface EmergencyRepository extends JpaRepository<Emergency, Long>{

}
