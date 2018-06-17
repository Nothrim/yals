package pl.edu.pollub.yals.services.presence

class PresenceTimeExpiredException(override var message: String) : Exception(message)
class AlreadyPresentAtLectureException(override var message: String) : Exception(message)