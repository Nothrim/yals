package pl.edu.pollub.yals

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.reactive.config.EnableWebFlux
import pl.edu.pollub.yals.models.database.User
import pl.edu.pollub.yals.repositories.UserRepository


//https://git.heroku.com/yals-app.git -heroku git deploy
//localhost:5432 - localhost db
@SpringBootApplication
@EnableWebFlux
class YetAnotherLectureShedulerApplication(val userRepository: UserRepository) : CommandLineRunner {
    override fun run(vararg args: String?) {
    }
}

fun main(args: Array<String>) {
    runApplication<YetAnotherLectureShedulerApplication>(*args)
}
