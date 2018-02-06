(function () {
    var app=angular.module('CarTracker',[
        'ngRoute'
    ]);

    app.config(function ($routeProvider) {
        $routeProvider.when('/home',{
            templateUrl: '../App/Views/home.html',
            controller: 'homeController',
            controllerAs: 'homeCtrl'
        }).when('/home/:vehiclevin',{
            templateUrl: '../App/Views/vehicle.html',
            controller: 'vehicleController',
            controllerAs: 'vehicleCtrl'
        }).otherwise({
            redirectTo: '/home'
        });
    });
})();
