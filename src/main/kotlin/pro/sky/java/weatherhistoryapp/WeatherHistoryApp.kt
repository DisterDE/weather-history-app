package pro.sky.java.weatherhistoryapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.reactive.function.server.coRouter
import pro.sky.java.weatherhistoryapp.handler.HistoryHandler

@SpringBootApplication
class WeatherHistoryApp {
    @Bean
    fun router(handler: HistoryHandler) = coRouter {
        GET("/records", handler::find)
        POST("/records", handler::save)
        DELETE("/records", handler::delete)
    }
}


fun main(args: Array<String>) {
    runApplication<WeatherHistoryApp>(*args)
}
