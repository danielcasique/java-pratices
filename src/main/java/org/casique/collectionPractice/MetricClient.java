package org.casique.collectionPractice;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface MetricClient {

    List<Metric> getAllByDeviceIdIn(Collection<UUID> deviceIds);

}
