(function () {
    var app=angular.module('CarTracker',[
        'ngRoute'
    ]);

    app.config(function ($routeProvider) {
        $routeProvider.when('/home',{
            templateUrl: '../App/Views/home.html',
            controller: 'homeController',
            controllerAs: 'homeCtrl'
        }).otherwise({
            redirectTo: '/home'
        });
    });
})();
