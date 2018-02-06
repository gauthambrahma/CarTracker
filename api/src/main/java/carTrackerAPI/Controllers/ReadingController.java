package carTrackerAPI.Controllers;

import carTrackerAPI.Entites.Reading;
import carTrackerAPI.Services.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class    ReadingController {

    @Autowired
    ReadingService readingService;

    @RequestMapping(value="/postReading", method = RequestMethod.POST)
    public ResponseEntity postReadingData(@RequestBody Reading readingData){
        boolean success=readingService.saveReadingData(readingData);
        if(success) {
            return new ResponseEntity(HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value="/getVehicleDetails", method = RequestMethod.GET)
    public List<Reading> getVehicleDetails(@RequestParam(value = "vehicle_vin") String vehicle_vin){
        List<Reading> readings = readingService.getReadingsByvin(vehicle_vin);
        return readings;
    }
}
