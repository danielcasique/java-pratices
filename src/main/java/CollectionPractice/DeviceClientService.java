package CollectionPractice;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class DeviceClientService implements DeviceClient{

    @Override
    public List<Device> getAllByIdIn(Collection<UUID> ids) {
        return null;
    }
}
