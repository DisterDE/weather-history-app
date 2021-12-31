package pro.sky.java.weatherhistoryapp.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import pro.sky.java.weatherhistoryapp.domain.HistoryRecord;
import pro.sky.java.weatherhistoryapp.service.HistoryService;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
@RequiredArgsConstructor
public class HistoryHandler {

    private final HistoryService service;

    @NonNull
    public Mono<ServerResponse> find(ServerRequest serverRequest) {
        return serverRequest.queryParam("amount")
                .map(amount -> ok().body(service.find(Integer.parseInt(amount)), HistoryRecord.class))
                .orElseGet(() -> ok().body(service.findAll(), HistoryRecord.class));
    }

    @NonNull
    public Mono<ServerResponse> save(ServerRequest serverRequest) {
        return ok().body(
                serverRequest.bodyToMono(HistoryRecord.class)
                        .doOnSuccess(service::save),
                HistoryRecord.class
        );
    }

    @NonNull
    public Mono<ServerResponse> delete(ServerRequest serverRequest) {
        return ok().body(service.deleteAll(), Void.class);
    }
}
