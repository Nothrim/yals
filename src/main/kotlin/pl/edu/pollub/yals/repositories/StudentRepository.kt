package pl.edu.pollub.yals.repositories

import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import pl.edu.pollub.yals.models.database.Student

interface StudentRepository : PagingAndSortingRepository<Student, Long> {

}