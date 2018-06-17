package pl.edu.pollub.yals.models.database

import javax.persistence.*

@Entity
data class Company(
        @Id @GeneratedValue val Id: Long = -1
        , val name: String = ""
        , val state: String = ""
        ,   @OneToMany(fetch=FetchType.LAZY, cascade = [CascadeType.ALL], mappedBy="company")
        val lecturers:Set<Lecturer> = HashSet()
)