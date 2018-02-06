(function(){
    var app=angular.module("CarTracker");

    app.controller('homeController',['$scope','$http','$location','getdata',function ($scope,$http,$location,getdata) {

        getdata("http://localhost:8080/getVehicles",handleVehicleData);

        function handleVehicleData(vehicledata) {
            if(vehicledata.status==200){
                console.log(vehicledata.data);
                vehicledata.data.map(obj =>obj.timestamp = new Date(obj.timestamp));
                $scope.vehicleData=vehicledata.data;
            }
        }

        $scope.gotoVehicle=function (_vehiclevin) {
            var vehiclevin = _vehiclevin;
            $location.path('/home/' + vehiclevin);
        }


    }]);
})();