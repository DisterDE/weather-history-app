package pro.sky.java.weatherhistoryapp.service

import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import pro.sky.java.weatherhistoryapp.domain.HistoryRecord
import pro.sky.java.weatherhistoryapp.repository.HistoryRepository

@Service
class HistoryServiceImpl(
    private val repository: HistoryRepository
) : HistoryService {

    override suspend fun save(record: HistoryRecord): HistoryRecord {
        return repository.save(record)
    }

    override suspend fun find(amount: Int): List<HistoryRecord> {
        return repository.findAll(Sort.by("created_at").descending())
            .take(amount)
            .toList()
    }

    override suspend fun findAll(): List<HistoryRecord> {
        return repository.findAll(Sort.by("created_at").descending())
            .toList()
    }

    override suspend fun deleteAll() {
        repository.deleteAll()
    }
}