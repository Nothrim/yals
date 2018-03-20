package pl.edu.pollub.yals.repositories

import org.springframework.data.repository.CrudRepository
import pl.edu.pollub.yals.models.database.User

interface UserRepository : CrudRepository<User, Long>