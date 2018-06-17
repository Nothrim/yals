package pl.edu.pollub.yals.endpoints.test

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import reactor.core.publisher.Mono

@Controller
class TestHandler {
    @GetMapping("/api/public/hello")
    @ResponseBody
    fun handle(): Mono<String> {
        return Mono.just("Hello")
    }

    @GetMapping("/api/private/hello")
    @ResponseBody
    fun handlePrivate(): Mono<String> {
        return Mono.just("Hello user!")
    }
}