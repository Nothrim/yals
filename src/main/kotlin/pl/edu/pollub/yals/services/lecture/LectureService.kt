package pl.edu.pollub.yals.services.lecture

import org.springframework.stereotype.Service
import pl.edu.pollub.yals.models.database.Lecture
import pl.edu.pollub.yals.models.database.Student
import pl.edu.pollub.yals.repositories.LectureRepository

@Service
class LectureService(val lectureRepository: LectureRepository) {
    fun assignStudent(student: Student, lecture: Lecture) {
        if (!lecture.confirmed) {
            throw LectureNotConfirmedException("${lecture.name} is not yet confirmed")
        }
        if (lecture.interestedStudents.count() < lecture.studentLimit) {
            lecture.interestedStudents.toMutableSet().add(student)
            lectureRepository.save(lecture)
        } else {
            throw LectureIsFullException("Unable to assign additional interestedStudents for lecture lecture size limit is " +
                    "${lecture.studentLimit}")
        }
    }
    fun confirmLecture(lecture:Lecture) {
        lecture.confirmed =true;
        lectureRepository.save(lecture)
    }
}