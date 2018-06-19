package pl.edu.pollub.yals.models

public data class StudentDTO(
        val name: String = ""
        , val surname: String = ""
        , val indexNumber: String = ""
        , val educationYear: Int = -1
        , val semester: Int = -1
        , val field: String = ""
)