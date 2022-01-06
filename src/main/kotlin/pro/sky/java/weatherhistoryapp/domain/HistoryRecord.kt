package pro.sky.java.weatherhistoryapp.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table
class HistoryRecord {
    @Id
    var id: Int? = null
    var cityName: String? = null

    @CreatedDate
    var createdAt: LocalDateTime? = null
    var result: String? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is HistoryRecord) return false

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id ?: 0
    }

    override fun toString(): String {
        return "HistoryRecord(id=$id, cityName=$cityName, createdAt=$createdAt, result=$result)"
    }
}
