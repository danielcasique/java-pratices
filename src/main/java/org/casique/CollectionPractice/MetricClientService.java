package org.casique.CollectionPractice;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class MetricClientService implements MetricClient {
    @Override
    public List<Metric> getAllByDeviceIdIn(Collection<UUID> deviceIds) {
        return null;
    }
}
