package pl.edu.pollub.yals.endpoints.crud

import org.springframework.web.bind.annotation.*
import pl.edu.pollub.yals.models.StudentLecturePair
import pl.edu.pollub.yals.repositories.LectureRepository
import pl.edu.pollub.yals.repositories.StudentRepository
import pl.edu.pollub.yals.services.presence.PresenceService
import java.util.*

@RestController
@CrossOrigin(origins = ["http://localhost:4200"], methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.HEAD, RequestMethod.PUT, RequestMethod.DELETE])
class PresenceController(val lectureRepository: LectureRepository, val studentRepository: StudentRepository, val presenceService: PresenceService) {
    @GetMapping("/api/private/presences/lecture/{id}")
    fun getPresencesForLecture(@PathVariable id: Long) = lectureRepository.findById(id).flatMap { Optional.of(it.presentStudents) }

    @GetMapping("/api/private/presences/student/{id}")
    fun getPresencesForStudent(@PathVariable id: Long) = studentRepository.findById(id).flatMap { Optional.of(it.lecturesPresentAt) }


    @PutMapping("/api/private/presences")
    fun setPresent(@RequestBody studentLecturePair: StudentLecturePair) {
        lectureRepository.findById(studentLecturePair.lectureId).ifPresent({
            val lecture = it
            studentRepository.findById(studentLecturePair.studentId).ifPresent(
                    {
                        presenceService.confirmPresence(it, lecture)
                    }
            )
        })
    }
}