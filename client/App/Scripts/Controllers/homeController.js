(function(){
    var app=angular.module("CarTracker");

    app.controller('homeController',['$scope','$http','getVehicledata',function ($scope,$http,getVehicledata) {

        getVehicledata("http://localhost:8080/getVehicles",handleVehicleData);

        function handleVehicleData(vehicledata) {
            if(vehicledata.status==200){
                console.log(vehicledata.data);
                $scope.vehicleData=vehicledata.data;
            }
        }
    }]);
})();