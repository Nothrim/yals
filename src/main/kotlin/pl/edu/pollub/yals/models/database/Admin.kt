package pl.edu.pollub.yals.models.database

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Admin(
        @Id @GeneratedValue val Id: Long = -1
        , val name: String
        , val surname: String
)