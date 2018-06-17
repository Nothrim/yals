package pl.edu.pollub.yals.repositories

import org.springframework.data.repository.CrudRepository
import pl.edu.pollub.yals.models.database.Lecturer

interface LecturerRepository : CrudRepository<Lecturer, Long>