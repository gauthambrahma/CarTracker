package carTrackerAPI.Controllers;

import carTrackerAPI.Entites.Alert;
import carTrackerAPI.Entites.Reading;
import carTrackerAPI.Services.AlertService;
import carTrackerAPI.Services.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class AlertController {

    @Autowired
    AlertService alertService;

    @RequestMapping(value="/getAlerts", method = RequestMethod.GET)
    public List<Alert> getAlerts(@RequestParam(value = "vehicle_vin") String vin){
        List<Alert> alerts = alertService.getAlertsForvin(vin);
        return alerts;
    }
}
