package juices.data;
import org.springframework.data.repository.CrudRepository;

import juices.User;

public interface UserRepository extends CrudRepository<User, Long> {

  User findByUsername(String username);
  
}
