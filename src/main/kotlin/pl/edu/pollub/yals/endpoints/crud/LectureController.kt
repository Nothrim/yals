package pl.edu.pollub.yals.endpoints.crud

import org.springframework.web.bind.annotation.*
import pl.edu.pollub.yals.models.LectureDataChange
import pl.edu.pollub.yals.models.StudentLecturePair
import pl.edu.pollub.yals.models.database.Lecture
import pl.edu.pollub.yals.repositories.LectureRepository
import pl.edu.pollub.yals.repositories.StudentRepository
import pl.edu.pollub.yals.services.lecture.LectureService
import java.util.*

@RestController
@CrossOrigin(origins = ["http://localhost:4200"], methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.HEAD, RequestMethod.PUT, RequestMethod.DELETE])
class LectureController(val lectureRepository: LectureRepository, val studentRepository: StudentRepository, val lectureService: LectureService) {
    @GetMapping("/api/private/lectures")
    fun getLectures() = lectureRepository.findAll()

    @GetMapping("/api/private/lectures/student/{id}")
    fun getLecturesForStudent(@PathVariable id: Long) =
            studentRepository.findById(id).flatMap({
                val student = it
                Optional.of(lectureRepository.findAll().filter { it.interestedStudents.contains(student) })
            })

    @GetMapping("/api/private/lectures/student/present/{id}")
    fun getPresentForStudent(@PathVariable id: Long) =
            studentRepository.findById(id).flatMap({
                val student = it
                Optional.of(lectureRepository.findAll().filter { it.presentStudents.contains(student) })
            })


    @GetMapping("/api/private/lectures/{id}")
    fun getLecture(@PathVariable id: Long) = lectureRepository.findById(id)

    @DeleteMapping("/api/private/lectures/{id}")
    fun deleteLecture(@PathVariable id: Long) = lectureRepository.findById(id).ifPresent({ lectureRepository.delete(it) })

    @PostMapping("/api/private/lectures")
    fun addLecture(@RequestBody lecture: LectureDataChange) = lectureRepository.save(Lecture(name = lecture.name, date = lecture.date, studentLimit = lecture.studentLimit))

    @PutMapping("/api/private/lectures/{id}")
    fun putLecture(@RequestBody lecture: LectureDataChange, @PathVariable id: Long) =
            lectureRepository.findById(id)
                    .flatMap { Optional.of(lectureRepository.save(Lecture(it.Id, lecture.name, lecture.date, studentLimit = lecture.studentLimit))) }


    @PostMapping("/api/private/lectures/signup/{id}")
    fun signupToLecture(@PathVariable id: Long) {

        lectureRepository.findById(id).ifPresent(
                {
                    val lecture = it;
                    studentRepository.findBySurname("Ilczuk").ifPresent({
                        lectureService.assignStudent(it, lecture)
                    })
                }
        )
    }

    @PostMapping("/api/private/lectures/leave")
    fun leaveLecture(@RequestBody studentLecturePair: StudentLecturePair) = lectureRepository.findById(studentLecturePair.lectureId)
            .ifPresent({
                val lecture = it
                studentRepository.findById(studentLecturePair.studentId).ifPresent({
                    if (lecture.interestedStudents.contains(it)) {
                        lecture.interestedStudents.remove(it)
                        lectureRepository.save(lecture)
                    }
                })
            })

    @PostMapping("/api/private/lectures/confirm/{id}")
    fun confirmLecture(@PathVariable id: Long) {
        lectureRepository.findById(id).ifPresent({
            lectureService.confirmLecture(it)
        })
    }
}