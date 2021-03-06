package pl.edu.pollub.yals.models.database

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
data class Student(
        @Id @GeneratedValue val Id: Long = -1
        , val name: String =""
        , val surname: String=""
        , val indexNumber: String =""
        , val educationYear: Int=-1
        , val semester: Int=-1
        , val field: String=""
        , val active: Boolean=true
        , val state: String="active"
        ,val idToken:String = ""
        ,
        @JsonBackReference
        @ManyToMany(mappedBy = "interestedStudents",fetch = FetchType.EAGER)
        var lecturesIsInterestedIn: MutableSet<Lecture> = mutableSetOf()
        ,@JsonBackReference
        @ManyToMany(mappedBy = "presentStudents",fetch = FetchType.EAGER)
        var lecturesPresentAt: MutableSet<Lecture> = mutableSetOf()
)