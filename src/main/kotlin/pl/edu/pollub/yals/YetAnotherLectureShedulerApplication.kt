package pl.edu.pollub.yals

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import pl.edu.pollub.yals.models.database.User
import pl.edu.pollub.yals.repositories.UserRepository

@SpringBootApplication
class YetAnotherLectureShedulerApplication(val userRepository: UserRepository) : CommandLineRunner {
    override fun run(vararg args: String?) {
        userRepository.save(User("e"))
        userRepository.save(User("f"))
        userRepository.findAll().forEach({ print(it)})
    }
}

fun main(args: Array<String>) {
    runApplication<YetAnotherLectureShedulerApplication>(*args)
}
