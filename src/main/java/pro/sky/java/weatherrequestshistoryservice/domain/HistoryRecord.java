package pro.sky.java.weatherrequestshistoryservice.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class HistoryRecord {
    @Id
    private Integer id;
    private String cityName;
    @CreatedDate
    private LocalDateTime createdAt;
    private String result;
}
