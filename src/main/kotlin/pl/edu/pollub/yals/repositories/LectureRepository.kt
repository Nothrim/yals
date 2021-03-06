package pl.edu.pollub.yals.repositories

import org.springframework.data.repository.PagingAndSortingRepository
import pl.edu.pollub.yals.models.database.Lecture
import pl.edu.pollub.yals.models.database.Student

interface LectureRepository : PagingAndSortingRepository<Lecture, Long> {
}