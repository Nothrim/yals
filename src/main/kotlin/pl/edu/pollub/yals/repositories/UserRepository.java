package pl.edu.pollub.yals.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import pl.edu.pollub.yals.models.database.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
