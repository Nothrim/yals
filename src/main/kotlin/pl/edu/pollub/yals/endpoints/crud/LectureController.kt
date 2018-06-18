package pl.edu.pollub.yals.endpoints.crud

import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.*
import pl.edu.pollub.yals.models.StudentLecturePair
import pl.edu.pollub.yals.models.database.Lecture
import pl.edu.pollub.yals.repositories.LectureRepository
import pl.edu.pollub.yals.repositories.StudentRepository
import pl.edu.pollub.yals.services.lecture.LectureService
import reactor.core.publisher.Flux
import java.util.*

@RestController
@CrossOrigin(origins = ["http://localhost:4200"], methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.HEAD, RequestMethod.PUT, RequestMethod.DELETE])
class LectureController(val lectureRepository: LectureRepository, val studentRepository: StudentRepository, val lectureService: LectureService) {
    @GetMapping("/api/private/lectures",produces = ["application/stream+json"])
    fun getLectures() = Flux.fromIterable(lectureRepository.findAll())

    @GetMapping("/api/private/lectures/student/{id}")
    fun getLecturesForStudent(@PathVariable id: Long) = studentRepository.findById(id).flatMap { Optional.of(it.lecturesIsInterestedIn) }


    @GetMapping("/api/private/lectures/{id}")
    fun getLecture(@PathVariable id: Long) = lectureRepository.findById(id)

    @PostMapping("/api/private/lectures")
    fun addLecture(@RequestBody lecture: Lecture) = lectureRepository.save(lecture)

    @PutMapping("/api/private/lectures/{id}")
    fun putCompany(@RequestBody lecture: Lecture, @PathVariable id: Long) =
        lectureRepository.findById(id)
                .flatMap { Optional.of(lectureRepository.save(Lecture(it.Id, lecture.name, lecture.date, lecture.time, lecture.confirmed, lecture.state))) }


    @PostMapping("/api/private/lectures/assign")
    fun assignToLecture(@RequestBody studentLecturePair: StudentLecturePair) {
        lectureRepository.findById(studentLecturePair.lectureId).ifPresent(
                {
                    val lecture = it;
                    studentRepository.findById(studentLecturePair.studentId).ifPresent({
                        lectureService.assignStudent(it, lecture)
                    })
                }
        )
    }

    @PostMapping("api/private/lecture/confirm/{id}")
    fun confirmLecture(@PathVariable id: Long) {
        lectureRepository.findById(id).ifPresent({
            lectureService.confirmLecture(it)
        })
    }
}