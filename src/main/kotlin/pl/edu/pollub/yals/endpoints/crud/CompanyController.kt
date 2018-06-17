package pl.edu.pollub.yals.endpoints.crud

import org.springframework.web.bind.annotation.*
import pl.edu.pollub.yals.models.database.Company
import pl.edu.pollub.yals.repositories.CompanyRepository
import java.util.*


@RestController
class CompanyController(val companyRepository: CompanyRepository) {
    @GetMapping("/api/private/companies")
    fun listCompanies() = companyRepository.findAll()

    @GetMapping("/api/private/companies/{id}")
    fun getCompany(@PathVariable id: Long) = companyRepository.findById(id)

    @PostMapping("/api/private/companies")
    fun saveCompany(@RequestBody company: Company) = companyRepository.save(company)

    @PutMapping("/api/private/companies/{id}")
    fun putCompany(@RequestBody company: Company, @PathVariable id: Long) {
        companyRepository.findById(id)
                .flatMap { Optional.of(companyRepository.save(Company(it.Id, company.name, company.state))) }
    }

    @DeleteMapping("/api/private/companies/{id}")
    fun removeCompany(@PathVariable id: Long) = companyRepository.deleteById(id)

}