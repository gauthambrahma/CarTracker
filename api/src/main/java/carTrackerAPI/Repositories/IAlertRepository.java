package carTrackerAPI.Repositories;

import carTrackerAPI.Entites.Alert;
import org.springframework.data.repository.CrudRepository;


public interface IAlertRepository extends CrudRepository<Alert, Long> {

}
