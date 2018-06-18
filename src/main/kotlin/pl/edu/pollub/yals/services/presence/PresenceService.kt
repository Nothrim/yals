package pl.edu.pollub.yals.services.presence

import org.springframework.stereotype.Service
import pl.edu.pollub.yals.models.database.Lecture
import pl.edu.pollub.yals.models.database.Student
import pl.edu.pollub.yals.repositories.LectureRepository
import java.time.LocalDate
import java.time.LocalDateTime


@Service
class PresenceService(val lectureRepository: LectureRepository) {
    fun confirmPresence(student: Student, lecture: Lecture) {
        if (LocalDateTime.now().isAfter(lecture.presenceCheck)) {
            throw PresenceTimeExpiredException("Time to assign yourself as present has expired")
        }
        if (lecture.presentStudents.contains(student)) {
            throw AlreadyPresentAtLectureException("Student is already present at lecture")
        }
        lecture.presentStudents.toHashSet().add(student)
        lectureRepository.save(lecture)
    }
}