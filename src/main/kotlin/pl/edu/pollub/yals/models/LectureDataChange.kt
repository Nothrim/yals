package pl.edu.pollub.yals.models

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime

data class LectureDataChange(
        val name: String = ""
        , @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
        val date: LocalDateTime = LocalDateTime.now()
        , val studentLimit: Long = -1
)