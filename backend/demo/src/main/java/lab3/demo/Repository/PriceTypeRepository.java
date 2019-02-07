package lab3.demo.Repository;
import lab3.demo.Entity.PriceType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface PriceTypeRepository extends JpaRepository<PriceType, Long>{
 
}