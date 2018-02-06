package carTrackerAPI.Repositories;

import carTrackerAPI.Entites.Reading;
import carTrackerAPI.Entites.Vehicle;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IReadingRepository extends CrudRepository<Reading, Long> {
    List<Reading> findAllByvin(String vin);
}
