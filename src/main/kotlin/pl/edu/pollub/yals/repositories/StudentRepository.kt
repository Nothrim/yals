package pl.edu.pollub.yals.repositories

import org.springframework.data.repository.PagingAndSortingRepository
import pl.edu.pollub.yals.models.database.Student
import java.util.*

interface StudentRepository : PagingAndSortingRepository<Student, Long> {
    fun findBySurname(surname: String): Optional<Student>
}