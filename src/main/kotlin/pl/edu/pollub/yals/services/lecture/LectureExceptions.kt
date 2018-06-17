package pl.edu.pollub.yals.services.lecture

class LectureNotConfirmedException(override var message: String) : Exception(message)
class LectureIsFullException(override var message: String) : Exception(message)