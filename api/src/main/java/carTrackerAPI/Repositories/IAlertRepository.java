package carTrackerAPI.Repositories;

import carTrackerAPI.Entites.Alert;
import carTrackerAPI.Entites.Reading;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface IAlertRepository extends CrudRepository<Alert, Long> {
    List<Alert> findAllByvin(String vin);
}
