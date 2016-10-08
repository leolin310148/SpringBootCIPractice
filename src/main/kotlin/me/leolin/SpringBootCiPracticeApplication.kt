package me.leolin

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
open class SpringBootCiPracticeApplication

fun main(args: Array<String>) {
    SpringApplication.run(SpringBootCiPracticeApplication::class.java, *args)aa
}

data class HelloRes(val message: String)
@RestController open class HelloController {

    @RequestMapping("/api/hello")
    open fun hello(): HelloRes = HelloRes("welcome")
}
