package pl.edu.pollub.yals.models.database

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonManagedReference
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Lecture(
        @Id @GeneratedValue val Id: Long = -1
        , val name: String = ""
        , @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
        val date: LocalDateTime = LocalDateTime.now()
        , var confirmed: Boolean = false
        , val state: String = "active"
        ,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS") val presenceCheck: LocalDateTime = LocalDateTime.now().plusMinutes(30)
        , val studentLimit: Long = -1
){

        @JsonManagedReference
        @ManyToMany(cascade = [(CascadeType.ALL)], fetch = FetchType.EAGER)
        @JoinTable(name = "interested_students",
                joinColumns = [(JoinColumn(name = "lecture_id", referencedColumnName = "id"))],
                inverseJoinColumns = [(JoinColumn(name = "student_id", referencedColumnName = "id"))])
        val interestedStudents: MutableSet<Student> = mutableSetOf()

        @JsonManagedReference
        @ManyToMany(cascade = [(CascadeType.ALL)], fetch = FetchType.EAGER)
        @JoinTable(name = "present_students",
                joinColumns = [(JoinColumn(name = "lecture_id", referencedColumnName = "id"))],
                inverseJoinColumns = [(JoinColumn(name = "student_id", referencedColumnName = "id"))])
        val presentStudents: MutableSet<Student> = mutableSetOf()

        @JsonManagedReference
        @ManyToMany(cascade = [(CascadeType.ALL)], fetch = FetchType.EAGER)
        @JoinTable(name = "assigned_lecturers",
                joinColumns = [(JoinColumn(name = "lecture_id", referencedColumnName = "id"))],
                inverseJoinColumns = [(JoinColumn(name = "lecturer_id", referencedColumnName = "id"))])
        val lecturers: MutableSet<Lecturer> = mutableSetOf()
}