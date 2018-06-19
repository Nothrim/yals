package pl.edu.pollub.yals.endpoints.crud

import org.springframework.web.bind.annotation.*
import pl.edu.pollub.yals.models.database.Lecturer
import pl.edu.pollub.yals.repositories.CompanyRepository
import pl.edu.pollub.yals.repositories.LectureRepository
import pl.edu.pollub.yals.repositories.LecturerRepository
import java.util.*


@RestController
class LecturerController(val lecturerRepository: LecturerRepository, val companyRepository: CompanyRepository, val lectureRepository: LectureRepository) {
    @GetMapping("/api/private/lecturers")
    fun listLecturers() = lecturerRepository.findAll()

    @GetMapping("/api/private/lecturers/{id}/company")
    fun getCompany(@PathVariable id: Long) = lecturerRepository.findById(id).flatMap({
        val lecturer = it;
        Optional.ofNullable(companyRepository.findAll().find { it.lecturers.contains(lecturer) })
    })

    @GetMapping("/api/private/lecturers/{id}/lectures")
    fun getLectures(@PathVariable id: Long) = lecturerRepository.findById(id).flatMap {
        val lecturer = it;
        Optional.of(lectureRepository.findAll().filter { it.lecturers.contains(lecturer) })
    }

    @GetMapping("/api/private/lecturers/{id}")
    fun getLecturer(@PathVariable id: Long) = lecturerRepository.findById(id)

    @PostMapping("/api/private/lecturers")
    fun saveLecturer(@RequestBody lecturer: Lecturer) = lecturerRepository.save(lecturer)

    @PutMapping("/api/private/lecturers/{id}")
    fun putLecturer(@RequestBody lecturer: Lecturer, @PathVariable id: Long) {
        lecturerRepository.findById(id)
                .flatMap { Optional.of(lecturerRepository.save(Lecturer(it.Id, lecturer.name, lecturer.surname, lecturer.state, lecturer.company))) }
    }

    @DeleteMapping("/api/private/lecturers/{id}")
    fun removeLecturer(@PathVariable id: Long) = lecturerRepository.deleteById(id)

}