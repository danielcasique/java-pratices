package CollectionPractice;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface DeviceClient {

    List<Device> getAllByIdIn(Collection<UUID> ids);

}
