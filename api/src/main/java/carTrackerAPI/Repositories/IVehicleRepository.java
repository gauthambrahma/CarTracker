package carTrackerAPI.Repositories;
import carTrackerAPI.Entites.Vehicle;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IVehicleRepository extends CrudRepository<Vehicle, Long> {
    Vehicle findByvin(String vin);
}
