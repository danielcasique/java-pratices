package CollectionPractice;

import lombok.Data;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class DeviceDetailsDto {

    private UUID id;

    private String name;

    private ZonedDateTime lastRebootTime;

    private List<MetricDto> lastMetrics;

    public DeviceDetailsDto(){

    }

    public DeviceDetailsDto(UUID id, String name, ZonedDateTime lastRebootTime, List<MetricDto> lastMetrics) {
        this.id = id;
        this.name = name;
        this.lastRebootTime = lastRebootTime;
        this.lastMetrics = lastMetrics;
    }

    @Data
    public static class MetricDto {

        private UUID id;

        private ZonedDateTime time;

        private BigDecimal value;

        public MetricDto() {
        }

        public MetricDto(UUID id, ZonedDateTime time, BigDecimal value) {
            this.id = id;
            this.time = time;
            this.value = value;
        }
    }
}
