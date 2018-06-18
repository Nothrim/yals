package pl.edu.pollub.yals.models.database

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
data class Lecturer(
        @Id @GeneratedValue val Id: Long = -1
        , val name: String = ""
        , val surname: String = ""
        , val state: String = "active"
        ,
        @JsonBackReference
        @ManyToOne(cascade = [CascadeType.ALL])
        var company: Company? = null
)