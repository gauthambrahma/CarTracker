package carTrackerAPI.Services;

import carTrackerAPI.Entites.Vehicle;
import carTrackerAPI.Repositories.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleService {

    @Autowired
    IVehicleRepository vehicleRepository;

    public boolean saveVehicleData(Vehicle[] vehicleData){
        Vehicle vehicleObj=new Vehicle();
        for (Vehicle vehicle :vehicleData) {
            vehicleObj.setVin(vehicle.getVin());
            vehicleObj.setMake(vehicle.getMake());
            vehicleObj.setModel(vehicle.getModel());
            vehicleObj.setYear(vehicle.getYear());
            vehicleObj.setRedlineRpm(vehicle.getRedlineRpm());
            vehicleObj.setMaxFuelVolume(vehicle.getMaxFuelVolume());
            vehicleObj.setLastServiceDate(vehicle.getLastServiceDate());
            vehicleRepository.save(vehicleObj);
        }
        return true;
    }

    public List<Vehicle> getVehicleData(){
        List<Vehicle> vehicleList=new ArrayList<Vehicle>();
        for (Vehicle v:vehicleRepository.findAll()) {
         vehicleList.add(v);
        }
        return vehicleList;
    }
}
