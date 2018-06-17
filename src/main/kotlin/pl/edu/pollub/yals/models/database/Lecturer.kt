package pl.edu.pollub.yals.models.database

import javax.persistence.*

@Entity
data class Lecturer(
        @Id @GeneratedValue val Id: Long = -1
        , val name: String
        , val surname: String
        , val state: String
        , @ManyToOne(fetch=FetchType.LAZY)
        var company:Company?
)