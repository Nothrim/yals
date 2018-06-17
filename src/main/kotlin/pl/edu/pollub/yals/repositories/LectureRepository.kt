package pl.edu.pollub.yals.repositories

import org.springframework.data.repository.CrudRepository
import pl.edu.pollub.yals.models.database.Lecture
import pl.edu.pollub.yals.models.database.Student

interface LectureRepository : CrudRepository<Lecture, Long> {
    fun findByInterestedStudents(interestedStudents: List<Student>):List<Lecture>
}