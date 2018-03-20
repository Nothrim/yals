package pl.edu.pollub.yals.endpoints.test

import org.springframework.http.MediaType.TEXT_PLAIN
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono
import java.util.concurrent.Flow

@Controller
class TestHandler {
    @GetMapping("/hello")
    @ResponseBody
    fun handle(): Mono<String> {
        return Mono.just("Hello")
    }
}