package pl.edu.pollub.yals.endpoints.test

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import reactor.core.publisher.Mono

@Controller
class TestHandler {
    @GetMapping("/hello")
    @ResponseBody
    fun handle(): Mono<String> {
        return Mono.just("Hello")
    }
}