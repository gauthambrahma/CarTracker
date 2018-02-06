(function(){
    var app=angular.module("CarTracker");

    app.controller('vehicleController',['$scope','$http','$routeParams','$window','REST_with_params',function ($scope,$http,$routeParams,$window,REST_with_params) {
        //map API key: AIzaSyB03rnwGLDoD_ECO1uxaBf2mKUdpFAM2MY
        var vehiclevin = $routeParams.vehiclevin;
        $scope.markers = [];

        //get readings data for a vehicle
        REST_with_params("GET","http://localhost:8080/getVehicleDetails",{"vehicle_vin":vehiclevin},handleVehicleData);

        function handleVehicleData(vehicledata) {
            if(vehicledata.status==200){
                //converting timestamp to human readable form
                vehicledata.data.map(obj =>obj.timestamp = new Date(obj.timestamp));
                $scope.vehicleReadingsData=vehicledata.data;
                //sorting data by timestamp starting from latest time
                $scope.vehicleReadingsData.sort((a,b)=> (b.timestamp-a.timestamp));
                var latestTimeStamp=$scope.vehicleReadingsData[0].timestamp;
                var lastHalfHour=$scope.vehicleReadingsData.filter(obj=>{
                    var difference=latestTimeStamp-obj.timestamp;
                    var minutesDifference = Math.floor(difference/1000/60);
                    if(minutesDifference>40){
                        return false;
                    }
                    return true;
                });
                //plotting points on google maps
                for(var i=0;i<lastHalfHour.length;i++){
                    var obj = lastHalfHour[i];
                    var latLng = new google.maps.LatLng(obj.latitude, obj.longitude);
                    var marker = new google.maps.Marker({
                        position: latLng,
                        title: obj.vin
                    });
                    var content =
                        '<div id="content">' +
                        '<div class="row">' +
                        '<div class="col-md-12">' +
                        '<p><strong>Date</strong>: ' + obj.timestamp + '</p>' +
                        '<p><strong>vin</strong>: ' + obj.vin+ '</p>'+
                        '<p><strong>Latitude</strong>: ' + obj.latitude + '</p>' +
                        '<p><strong>Longitude</strong>: ' + obj.longitude + '</p>' +
                        '</div>' +
                        '</div>' +
                        '</div>';

                    $scope.markers.push(marker);

                    var infowindow = new google.maps.InfoWindow({
                        minWidth: 400,
                        maxWidth: 500
                    });

                    google.maps.event.addListener(marker, 'click', (function (marker, content, infowindow) {
                        return function () {
                            infowindow.setContent(content);
                            infowindow.open($scope.map, marker);
                        }
                    })(marker, content, infowindow));

                    var options = {
                        maxZoom: 13,
                        imagePath: 'images/m'
                    };

                    $scope.cluster = new MarkerClusterer($scope.map, $scope.markers, options);
                }
            }
        }

        $scope.initMap = function (){
            var myLatlng = new google.maps.LatLng(41.803194, -88.144406);

            var mapOptions = {
                zoom: 2,
                center: myLatlng
            };

            $scope.map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
        }

        //get alert data for a vehicle
        REST_with_params("GET","http://localhost:8080/getAlerts",{"vehicle_vin":vehiclevin},handleVehicleAlertData);

        function handleVehicleAlertData(vehicleAlertData) {
            vehicleAlertData.data.map(obj =>obj.timestamp = new Date(obj.timestamp));
            $scope.alerts=vehicleAlertData.data;
            console.log(vehicleAlertData);
        }
    }]);
})();