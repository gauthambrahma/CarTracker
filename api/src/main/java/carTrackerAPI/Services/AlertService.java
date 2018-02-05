package carTrackerAPI.Services;


import carTrackerAPI.Entites.Alert;
import carTrackerAPI.Entites.Reading;
import carTrackerAPI.Entites.Vehicle;
import carTrackerAPI.Repositories.IAlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import carTrackerAPI.Entites.AlertMessages;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


@Service
public class AlertService {

    @Autowired
    private IAlertRepository alertRepository;

    public boolean checkForAlerts(Vehicle vehicle, Reading reading){
        String alert_priority;
        String alert_message;
        if(reading.getEngineRpm()>vehicle.getRedlineRpm()){
            alert_priority=AlertMessages.RULE1.getPriority();
            alert_message=AlertMessages.RULE1.getRule();
            SaveAlert(alert_message,alert_priority,vehicle.getVin());
        }
        if(reading.getFuelVolume()<(vehicle.getRedlineRpm()/10)){
            alert_priority=AlertMessages.RULE2.getPriority();
            alert_message=AlertMessages.RULE2.getRule();
            SaveAlert(alert_message,alert_priority,vehicle.getVin());
        }
        if(32>reading.getTires().getFrontLeft()||reading.getTires().getFrontLeft()>36||
                32>reading.getTires().getFrontRight()||reading.getTires().getFrontRight()>36||
                32>reading.getTires().getRearLeft()||reading.getTires().getRearLeft()>36||
                32>reading.getTires().getRearRight()||reading.getTires().getRearRight()>36){
            alert_priority=AlertMessages.RULE3.getPriority();
            alert_message=AlertMessages.RULE3.getRule();
            SaveAlert(alert_message,alert_priority,vehicle.getVin());
        }
        if(reading.isEngineCoolantLow()){
            alert_priority=AlertMessages.RULE4.getPriority();
            alert_message=AlertMessages.RULE4.getRule();
            SaveAlert(alert_message,alert_priority,vehicle.getVin());
        }
        if(reading.isCheckEngineLightOn()){
            alert_priority=AlertMessages.RULE5.getPriority();
            alert_message=AlertMessages.RULE5.getRule();
            SaveAlert(alert_message,alert_priority,vehicle.getVin());
        }
        return false;
    }

    private void SaveAlert(String alert_message, String alert_priority,String vin) {
        Alert alert=new Alert();
        alert.setRule(alert_message);
        alert.setPriority(alert_priority);
        Date date = new Date();
        alert.setTimestamp(new Timestamp(date.getTime()));
        alert.setVin(vin);
        alertRepository.save(alert);
    }

    public List<Alert> getAlertsForvin(String vin){
        return null;
    }
}
