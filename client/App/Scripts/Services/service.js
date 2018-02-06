(function () {
    var app=angular.module("CarTracker");

    app.service('getdata',function ($http) {
        return function (url,successFn) {
            $http.get(url).then(successFn);
        }
    });

    app.service('REST_with_params',function ($http) {
        return function (method, url, params,successFn) {
            $http({
                method:method,
                url:url,
                params: params
            }).then(successFn);
        }
    });
})();