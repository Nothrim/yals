package pl.edu.pollub.yals.endpoints.crud

import org.springframework.web.bind.annotation.*
import pl.edu.pollub.yals.models.database.Student
import pl.edu.pollub.yals.repositories.StudentRepository
import java.util.*


@RestController
class StudentController(val studentRepository: StudentRepository) {
    @GetMapping("/api/private/interestedStudents")
    fun listStudents() = studentRepository.findAll()

    @GetMapping("/api/private/interestedStudents/{id}")
    fun getStudent(@PathVariable id: Long) = studentRepository.findById(id)

    @PostMapping("/api/private/interestedStudents")
    fun saveStudent(@RequestBody student: Student) = studentRepository.save(student)

    @PutMapping("/api/private/interestedStudents/{id}")
    fun putLecturer(@RequestBody student: Student, @PathVariable id: Long) {
        studentRepository.findById(id)
                .flatMap { Optional.of(studentRepository.save(Student(it.Id, student.name, student.surname,
                        student.indexNumber,student.educationYear,student.semester,student.field,student
                        .active,student.state))) }
    }

    @DeleteMapping("/api/private/interestedStudents/{id}")
    fun removeLecturer(@PathVariable id: Long) = studentRepository.deleteById(id)

}