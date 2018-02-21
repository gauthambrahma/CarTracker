IoT Pet project. Objective was to get my hands dirty with Java Spring framework.

## application walkthrough:
home page contains details of all vehicle as shown in the screenshots below. Full details can be seen by clicking on the *view details* button.

![Image](client/App/Resources/screenshots/vehicle_details1.png "ss1")

![Image](client/App/Resources/screenshots/vehicle_details2.png "ss2")

when clicked on the view details button, it takes user to vehicle details page which contains a map showing location history of last 20 minutes as shown below.

![Image](client/App/Resources/screenshots/location_map_v_2.png "ss3")

A different tab shows history of all alerts for the vehicle color coded by warning type

![Image](client/App/Resources/screenshots/alert_table_v_2.png "ss4")

When clicked on signal hostory two drop downs appear. One to select signal type and other to select the time period. 

![Image](client/App/Resources/screenshots/history_signal.png "ss5")

Hit visualize to create a chart below as shown in the below two screenshots

![Image](client/App/Resources/screenshots/history_signal_visualization.png "ss6")

## directory structure:

**`client`** [*module-client*]: contains ui app (HTML, CSS, JS, fonts, images)      
**`api`** [*module-api*]: contains REST API

## mock sensor: 
[http://mocker.egen.io](http://mocker.egen.io)
