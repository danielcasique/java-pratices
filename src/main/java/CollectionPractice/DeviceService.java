package CollectionPractice;

import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;

/*
  Assume we have 2 clients - DeviceClient and MetricClient.
  DeviceClient may return short info about devices by their ids.
  MetricClient may return all metrics for the list of devices by their ids.
  Both clients are configured as Spring beans that can be autowired to other beans.

  You need to implement a method getDevicesDetails(Set<UUID> ids) in DeviceManager class.
  The method must return the list of devices details.

  !!!IMPORTANT  metrics history in device details must contain
                ONLY items registered after the last device reboot time.

  !!!NOTE  code style will also be taken into account when the solution is evaluated.
*/
public class DeviceService {

    private DeviceClient deviceClient;

    private MetricClient metricClient;

    public DeviceService() {
        this.deviceClient = new DeviceClientService();
        this.metricClient = new MetricClientService();
    }

    public DeviceService(DeviceClient deviceClient, MetricClient metricClient) {
        this.deviceClient = deviceClient;
        this.metricClient = metricClient;
    }

    public List<DeviceDetailsDto> getDevicesDetails(Set<UUID> ids) {
        List<Device> deviceList = this.deviceClient.getAllByIdIn(ids);
        Map<UUID, ZonedDateTime> devicesMap = deviceList.stream().collect(Collectors.toMap(Device::getId, Device::getLastRebootTime));
        List<Metric> metricList = this.metricClient.getAllByDeviceIdIn(ids)
                                                    .stream()
                                                    .filter(x -> Objects.nonNull(devicesMap.get(x.getDeviceId())) && x.getTime().isAfter(devicesMap.get(x.getId())))
                                                    .collect(Collectors.toList());
        List<DeviceDetailsDto> result = deviceList.stream()
                .map(x -> new DeviceDetailsDto(x.getId(),x.getName(),x.getLastRebootTime(),
                        metricList.stream().map(x1 -> new DeviceDetailsDto.MetricDto(x1.getId(), x1.getTime(), x1.getValue())).collect(Collectors.toList())))
                .collect(Collectors.toList());
        return result;
    }
}
