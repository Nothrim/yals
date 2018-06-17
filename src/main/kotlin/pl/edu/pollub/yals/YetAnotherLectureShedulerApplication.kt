package pl.edu.pollub.yals

import org.springframework.boot.CommandLineRunner


import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.reactive.config.EnableWebFlux
import pl.edu.pollub.yals.models.database.Company
import pl.edu.pollub.yals.repositories.CompanyRepository
//https://git.heroku.com/yals-app.git -heroku git deploy
//localhost:5432 - localhost db
@SpringBootApplication
@EnableWebFlux
class YetAnotherLectureShedulerApplication(val companyRepository: CompanyRepository) : CommandLineRunner {
    override fun run(vararg args: String?) {
        companyRepository.save(Company(name = "Other company", state = "Some"))
        companyRepository.save(Company(name = "Some company", state = "active"))
        companyRepository.save(Company(name = "Other company", state = "active"))


    }
}

fun main(args: Array<String>) {
    runApplication<YetAnotherLectureShedulerApplication>(*args)
}
