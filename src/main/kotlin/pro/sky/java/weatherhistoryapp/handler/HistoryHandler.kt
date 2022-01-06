package pro.sky.java.weatherhistoryapp.handler

import kotlinx.coroutines.flow.first
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*
import org.springframework.web.reactive.function.server.ServerResponse.ok
import pro.sky.java.weatherhistoryapp.domain.HistoryRecord
import pro.sky.java.weatherhistoryapp.service.HistoryService

@Component
class HistoryHandler(
    private val service: HistoryService
) {
    suspend fun find(serverRequest: ServerRequest): ServerResponse {
        return ok().bodyValueAndAwait(
            serverRequest.queryParamOrNull("amount")
                ?.let { service.find(it.toInt()) }
                ?: service.findAll()
        )
    }

    suspend fun save(serverRequest: ServerRequest): ServerResponse {
        return service.save(serverRequest.bodyToFlow<HistoryRecord>().first())
            .run { ok().bodyValueAndAwait(this) }
    }

    suspend fun delete(serverRequest: ServerRequest): ServerResponse {
        return service.deleteAll().run { ok().buildAndAwait() }
    }
}