package CollectionPractice;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class DeviceServiceTest {

    @Mock
    DeviceClient deviceClient;

    @Mock
    MetricClient metricClient;

    DeviceService deviceService;

    List<UUID> uuids;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        ZoneId zoneId = ZoneId.of("UTC-5");
        uuids = List.of(UUID.randomUUID(), UUID.randomUUID());
        List<Device> devicesList = List.of(new Device(uuids.get(0), "test 1", ZonedDateTime.of(2022, 10, 12, 16, 00, 00, 00, zoneId)),
                new Device(uuids.get(1), "test 2", ZonedDateTime.of(2022, 10, 12, 17, 00, 00, 00, zoneId)));
        List<Metric> metricList = List.of(new Metric(UUID.randomUUID(), uuids.get(0), ZonedDateTime.of(2022, 10, 12, 15, 59, 59, 00, zoneId), new BigDecimal(11)),
                new Metric(UUID.randomUUID(), uuids.get(0), ZonedDateTime.of(2022, 10, 12, 16, 01, 59, 00, zoneId), new BigDecimal(12)),
                new Metric(UUID.randomUUID(), uuids.get(1), ZonedDateTime.of(2022, 10, 12, 17, 01, 59, 00, zoneId), new BigDecimal(13)));


        when(deviceClient.getAllByIdIn(any(List.class))).thenReturn(devicesList);

        when(metricClient.getAllByDeviceIdIn(any(List.class))).thenReturn(metricList);

        deviceService = new DeviceService(deviceClient, metricClient);
    }

    @Test
    public void getDevicesDetailsTest(){


        List<DeviceDetailsDto> result = deviceService.getDevicesDetails( new HashSet<UUID>(uuids));

    }
}
