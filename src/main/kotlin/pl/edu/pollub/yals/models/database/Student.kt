package pl.edu.pollub.yals.models.database

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToMany

@Entity
data class Student(
        @Id @GeneratedValue val Id: Long = -1
        , val name: String
        , val surname: String
        , val indexNumber: String
        , val educationYear: Int
        , val semester: Int
        , val field: String
        , val active: Boolean
        , val state: String
        , @ManyToMany(mappedBy = "interestedStudents")
        var lecturesIsInterestedIn: Set<Lecture> = HashSet()
        , @ManyToMany(mappedBy = "presentStudents")
        var lecturesPresentAt: Set<Lecture> = HashSet()
)