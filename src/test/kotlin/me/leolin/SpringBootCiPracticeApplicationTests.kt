package me.leolin

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.context.embedded.LocalServerPort
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringBootCiPracticeApplicationTests {

    @LocalServerPort
    private var serverPort: Int = 0

    lateinit var helloApi: HelloApi

    @Before
    fun setUp() {
        helloApi = Retrofit.Builder()
                .baseUrl("http://localhost:${serverPort}")
                .addConverterFactory(JacksonConverterFactory.create(jacksonObjectMapper()))
                .build()
                .create(HelloApi::class.java)
    }

    @Test
    fun contextLoads() {

        val message = helloApi.hello().execute().body().message
        assert(message == "welcome")

    }


}
