(function () {
    var app=angular.module("CarTracker");

    app.service('getVehicledata',function ($http) {
        return function (url,successFn) {
            $http.get(url).then(successFn);
        }
    })
})();