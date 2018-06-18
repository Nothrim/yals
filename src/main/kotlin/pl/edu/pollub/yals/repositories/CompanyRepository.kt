package pl.edu.pollub.yals.repositories

import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import pl.edu.pollub.yals.models.database.Company

interface CompanyRepository : PagingAndSortingRepository<Company, Long>