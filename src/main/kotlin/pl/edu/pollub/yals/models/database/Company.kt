package pl.edu.pollub.yals.models.database

import javax.persistence.*

@Entity
data class Company(
        @Id @GeneratedValue val Id: Long = -1
        , val name: String = ""
        , val state: String = ""
        , @OneToMany(fetch = FetchType.EAGER,cascade = [CascadeType.ALL], mappedBy = "company")
        var lecturers: List<Lecturer>? = ArrayList()
)