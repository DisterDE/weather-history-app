package pro.sky.java.weatherhistoryapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import pro.sky.java.weatherhistoryapp.handler.HistoryHandler;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@SpringBootApplication
public class WeatherHistoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherHistoryApplication.class, args);
    }

    @Bean
    public RouterFunction<ServerResponse> router(HistoryHandler handler) {
        return route().path("/records", builder -> builder
                        .GET(handler::find)
                        .POST(handler::save)
                        .DELETE(handler::delete))
                .build();
    }
}
