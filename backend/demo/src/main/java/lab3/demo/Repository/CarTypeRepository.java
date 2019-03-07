package lab3.demo.Repository;
import lab3.demo.Entity.CarType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface CarTypeRepository extends JpaRepository<CarType, Long>{
    CarType findByname(String name);
}