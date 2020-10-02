package juices.data;

import org.springframework.data.repository.CrudRepository;

import juices.Juice;

public interface JuiceRepository 
         extends CrudRepository<Juice, Long> {

}
