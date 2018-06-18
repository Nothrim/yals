package pl.edu.pollub.yals.models.database

import com.fasterxml.jackson.annotation.JsonManagedReference
import java.sql.Time
import java.util.*
import javax.persistence.*
import kotlin.collections.HashSet

@Entity
class Lecture(
        @Id @GeneratedValue val Id: Long = -1
        , val name: String = ""
        , val date: Date = Date()
        , val time: Time = Time(System.currentTimeMillis())
        , var confirmed: Boolean = false
        , val state: String = "active"
        , val validPresent: Long = System.currentTimeMillis() + 30000
        , val studentLimit: Long = -1
        ,
        @JsonManagedReference
        @ManyToMany(cascade = [(CascadeType.ALL)],fetch = FetchType.EAGER)
        @JoinTable(name = "interested_students",
                joinColumns = [(JoinColumn(name = "lecture_id", referencedColumnName = "id"))],
                inverseJoinColumns = [(JoinColumn(name = "student_id", referencedColumnName = "id"))])
        val interestedStudents: Set<Student> = HashSet()
        ,
        @JsonManagedReference
        @ManyToMany(cascade = [(CascadeType.ALL)],fetch = FetchType.EAGER)
        @JoinTable(name = "present_students",
                joinColumns = [(JoinColumn(name = "lecture_id", referencedColumnName = "id"))],
                inverseJoinColumns = [(JoinColumn(name = "student_id", referencedColumnName = "id"))])
        val presentStudents: Set<Student> = HashSet()
)