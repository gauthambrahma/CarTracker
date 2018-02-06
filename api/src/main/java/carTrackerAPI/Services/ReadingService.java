package carTrackerAPI.Services;

import carTrackerAPI.Entites.Reading;
import carTrackerAPI.Entites.Vehicle;
import carTrackerAPI.Repositories.IVehicleRepository;
import carTrackerAPI.Repositories.IReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReadingService {
    @Autowired
    private IReadingRepository readingRepository;
    @Autowired
    private IVehicleRepository vehicleRepository;

    @Autowired
    private AlertService alertService;

    public boolean saveReadingData( Reading readingData){
        Vehicle vehicleData=vehicleRepository.findByvin(readingData.getVin());
        Reading readingObj=new Reading();
        readingObj.setVin(readingData.getVin());
        readingObj.setLatitude(readingData.getLatitude());
        readingObj.setLongitude(readingData.getLongitude());
        readingObj.setTimestamp(readingData.getTimestamp());
        readingObj.setFuelVolume(readingData.getFuelVolume());
        readingObj.setSpeed(readingData.getSpeed());
        readingObj.setEngineHp(readingData.getEngineHp());
        readingObj.setCheckEngineLightOn(readingData.isCheckEngineLightOn());
        readingObj.setEngineCoolantLow(readingData.isEngineCoolantLow());
        readingObj.setCruiseControlOn(readingData.isCruiseControlOn());
        readingObj.setEngineRpm(readingData.getEngineRpm());
        readingObj.setTires(readingData.getTires());
        readingRepository.save(readingObj);
        boolean checksuccessful = alertService.checkForAlerts(vehicleData,readingObj);
        return true;
    }

    public List<Reading> getReadingsByvin(String vehicle_vin) {
        List<Reading> readingList=new ArrayList<Reading>();
//        for (Reading r:readingRepository.findAllByvin(vehicle_vin)) {
//            readingList.add(r);
//        }
        return readingRepository.findAllByvin(vehicle_vin);
    }
}
