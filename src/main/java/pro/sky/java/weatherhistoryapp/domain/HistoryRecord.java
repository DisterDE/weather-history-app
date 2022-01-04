package pro.sky.java.weatherhistoryapp.domain;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table
@Getter
@Setter
@ToString
@Accessors(chain = true)
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class HistoryRecord {
    @Id
    private Integer id;
    private String cityName;
    @CreatedDate
    private LocalDateTime createdAt;
    private String result;
}
