package pl.edu.pollub.yals.endpoints.crud

import org.springframework.web.bind.annotation.*
import pl.edu.pollub.yals.models.database.Lecturer
import pl.edu.pollub.yals.repositories.LecturerRepository
import java.util.*


@RestController
class LecturerController(val lecturerRepository: LecturerRepository) {
    @GetMapping("/api/private/lecturers")
    fun listLecturers() = lecturerRepository.findAll()

    @GetMapping("/api/private/lecturers/{id}")
    fun getLecturer(@PathVariable id: Long) = lecturerRepository.findById(id)

    @PostMapping("/api/private/lecturers")
    fun saveLecturer(@RequestBody lecturer: Lecturer) = lecturerRepository.save(lecturer)

    @PutMapping("/api/private/lecturers/{id}")
    fun putLecturer(@RequestBody lecturer: Lecturer, @PathVariable id: Long) {
        lecturerRepository.findById(id)
                .flatMap { Optional.of(lecturerRepository.save(Lecturer(it.Id, lecturer.name, lecturer.surname, lecturer.state,lecturer.company))) }
    }

    @DeleteMapping("/api/private/lecturers/{id}")
    fun removeLecturer(@PathVariable id: Long) = lecturerRepository.deleteById(id)

}