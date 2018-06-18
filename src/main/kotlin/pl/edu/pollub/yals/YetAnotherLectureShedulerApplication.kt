package pl.edu.pollub.yals

import org.springframework.boot.CommandLineRunner


import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.reactive.config.EnableWebFlux
import pl.edu.pollub.yals.models.database.Company
import pl.edu.pollub.yals.models.database.Lecture
import pl.edu.pollub.yals.models.database.Lecturer
import pl.edu.pollub.yals.models.database.Student
import pl.edu.pollub.yals.repositories.CompanyRepository
import pl.edu.pollub.yals.repositories.LectureRepository
import pl.edu.pollub.yals.repositories.LecturerRepository
import pl.edu.pollub.yals.repositories.StudentRepository

//https://git.heroku.com/yals-app.git -heroku git deploy
//localhost:5432 - localhost db
@SpringBootApplication
@EnableWebFlux
class YetAnotherLectureShedulerApplication(val companyRepository: CompanyRepository, val lecturerRepository: LecturerRepository, val lectureRepository: LectureRepository
,val studentRepository: StudentRepository) : CommandLineRunner {
    override fun run(vararg args: String?) {
        companyRepository.save(Company(name = "Other company", state = "Some"))
        companyRepository.save(Company(name = "Some company", state = "active"))
        val company = companyRepository.save(Company(name = "Weird state company", state = "active"))
        lecturerRepository.save(Lecturer(name = "Adolf", surname = "Wimbledon", state = "active", company = company))
        lecturerRepository.save(Lecturer(name = "John", surname = "Wick", state = "active", company = company))
        val s1 =studentRepository.save(Student(name = "John",surname = "John",indexNumber = "0001",educationYear = 1,semester = 2,field = "IT",active = true,state = "active"))
        val s2=studentRepository.save(Student(name = "Adam",surname = "John",indexNumber = "0002",educationYear = 1,semester = 2,field = "IT",active = true,state = "active"))
        val s3=studentRepository.save(Student(name = "Victoria",surname = "Copperfield",indexNumber = "0003",educationYear = 2,semester = 2,field = "IT",active = true,state = "active"))
        lectureRepository.save(Lecture(name = "Angular", studentLimit = 30,interestedStudents = setOf(s1,s2,s3)))
    }
}

fun main(args: Array<String>) {
    runApplication<YetAnotherLectureShedulerApplication>(*args)
}
