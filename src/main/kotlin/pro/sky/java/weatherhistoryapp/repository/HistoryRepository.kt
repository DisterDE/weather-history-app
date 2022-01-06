package pro.sky.java.weatherhistoryapp.repository

import org.springframework.data.repository.kotlin.CoroutineSortingRepository
import org.springframework.stereotype.Repository
import pro.sky.java.weatherhistoryapp.domain.HistoryRecord

@Repository
interface HistoryRepository : CoroutineSortingRepository<HistoryRecord, Int>