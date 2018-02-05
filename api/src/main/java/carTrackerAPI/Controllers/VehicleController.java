package carTrackerAPI.Controllers;

import carTrackerAPI.Entites.Vehicle;
import carTrackerAPI.Repositories.IVehicleRepository;
import carTrackerAPI.Services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @RequestMapping(value="/putvehicles", method = RequestMethod.PUT)
    public ResponseEntity putVehicleData(@RequestBody Vehicle[] vehicleData){
        boolean success=vehicleService.saveVehicleData(vehicleData);
        if(success) {
            return new ResponseEntity(HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
