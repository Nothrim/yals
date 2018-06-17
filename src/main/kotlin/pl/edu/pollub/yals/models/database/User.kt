package pl.edu.pollub.yals.models.database

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "YalsUser")
data class User(
        val identityDocumentNumber: String = "",
        @Id @GeneratedValue val id: Long = -1
)
