package pro.sky.java.weatherhistoryapp.service

import pro.sky.java.weatherhistoryapp.domain.HistoryRecord

interface HistoryService {
    suspend fun save(record: HistoryRecord): HistoryRecord
    suspend fun find(amount: Int): List<HistoryRecord>
    suspend fun findAll(): List<HistoryRecord>
    suspend fun deleteAll()
}