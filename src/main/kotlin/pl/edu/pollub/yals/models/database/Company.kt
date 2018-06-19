package pl.edu.pollub.yals.models.database

import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
data class Company(
        @Id @GeneratedValue val Id: Long = -1
        , val name: String = ""
        , val state: String = ""

){
        @JsonManagedReference
        @OneToMany(fetch = FetchType.EAGER, mappedBy = "company")
        var lecturers: MutableSet<Lecturer> = mutableSetOf()
}