package pl.edu.pollub.yals.repositories

import org.springframework.data.repository.CrudRepository
import pl.edu.pollub.yals.models.database.Admin

interface AdminRepository : CrudRepository<Admin, Long>