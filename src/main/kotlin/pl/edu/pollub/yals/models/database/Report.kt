package pl.edu.pollub.yals.models.database

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Report(
        @Id @GeneratedValue val Id: Long = -1
        , val reportCode: String
        , val reportType: String
        , val path: String
)