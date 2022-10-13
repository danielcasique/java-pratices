package CollectionPractice;

import lombok.Data;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

@Data
public class Metric {

    private UUID id;

    private UUID deviceId;

    private ZonedDateTime time;

    private BigDecimal value;

    public Metric() {
    }

    public Metric(UUID id, UUID deviceId, ZonedDateTime time, BigDecimal value) {
        this.id = id;
        this.deviceId = deviceId;
        this.time = time;
        this.value = value;
    }
}
