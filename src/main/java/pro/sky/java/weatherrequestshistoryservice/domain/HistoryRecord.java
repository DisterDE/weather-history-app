package pro.sky.java.weatherrequestshistoryservice.domain;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class HistoryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cityName;
    @ColumnDefault("now()")
    private LocalDateTime createdAt;
    private String result;

    public HistoryRecord() {
    }

    public HistoryRecord(String cityName, LocalDateTime createdAt, String result) {
        this.cityName = cityName;
        this.createdAt = createdAt;
        this.result = result;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HistoryRecord)) return false;
        HistoryRecord that = (HistoryRecord) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "HistoryRecordDTO{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                ", createdAt=" + createdAt +
                ", result='" + result + '\'' +
                '}';
    }
}
