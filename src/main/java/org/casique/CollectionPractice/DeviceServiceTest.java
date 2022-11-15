package org.casique.CollectionPractice;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class DeviceServiceTest {

    List<UUID> uuids;

    List<Device> devicesList;

    List<Metric> metricList;

    @Before
    public void setUp(){
        ZoneId zoneId = ZoneId.of("UTC-5");
        uuids = List.of(UUID.randomUUID(), UUID.randomUUID());
        devicesList = List.of(new Device(uuids.get(0), "test 1", ZonedDateTime.of(2022, 10, 12, 16, 00, 00, 00, zoneId)),
                new Device(uuids.get(1), "test 2", ZonedDateTime.of(2022, 10, 12, 17, 00, 00, 00, zoneId)));
        metricList = List.of(new Metric(UUID.randomUUID(), uuids.get(0), ZonedDateTime.of(2022, 10, 12, 15, 59, 59, 00, zoneId), new BigDecimal(11)),
                new Metric(UUID.randomUUID(), uuids.get(0), ZonedDateTime.of(2022, 10, 12, 16, 01, 59, 00, zoneId), new BigDecimal(12)),
                new Metric(UUID.randomUUID(), uuids.get(1), ZonedDateTime.of(2022, 10, 12, 17, 01, 59, 00, zoneId), new BigDecimal(13)));
    }

    @Test
    public void getDevicesDetailsTest(){
        DeviceClient deviceClient = Mockito.mock(DeviceClientService.class);
        MetricClient metricClient = Mockito.mock(MetricClientService.class);
        DeviceService service =  new DeviceService(deviceClient, metricClient);
        when(deviceClient.getAllByIdIn(any(Collection.class))).thenReturn(devicesList);
        when(metricClient.getAllByDeviceIdIn(any(Collection.class))).thenReturn(metricList);
        List<DeviceDetailsDto> result = service.getDevicesDetails( new HashSet<UUID>(uuids));
        /**
         * 0 = {DeviceDetailsDto@2814} "DeviceDetailsDto(id=7f7fa47f-6a83-45b0-b95f-1e734b715e59, name=test 1, lastRebootTime=2022-10-12T16:00-05:00[UTC-05:00], lastMetrics=[DeviceDetailsDto.MetricDto(id=5184d5fe-4e69-4ecb-9a52-d9da31ad1951, time=2022-10-12T16:01:59-05:00[UTC-05:00], value=12), DeviceDetailsDto.MetricDto(id=c0d48a93-328a-4814-89b1-27e4576fa0d0, time=2022-10-12T17:01:59-05:00[UTC-05:00], value=13)])"
         * 1 = {DeviceDetailsDto@2815} "DeviceDetailsDto(id=aa6f799a-3fc1-432f-84e5-9753d937edc3, name=test 2, lastRebootTime=2022-10-12T17:00-05:00[UTC-05:00], lastMetrics=[DeviceDetailsDto.MetricDto(id=5184d5fe-4e69-4ecb-9a52-d9da31ad1951, time=2022-10-12T16:01:59-05:00[UTC-05:00], value=12), DeviceDetailsDto.MetricDto(id=c0d48a93-328a-4814-89b1-27e4576fa0d0, time=2022-10-12T17:01:59-05:00[UTC-05:00], value=13)])"
         */
    }
}
