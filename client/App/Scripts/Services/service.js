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

    app.service('lastnMinutesReadingData',function () {
        return function (readingDataObj,parameterToFilterWith,howMantMinutesBack) {
            //sort the object based on object literal property
            readingDataObj.sort((a,b)=> (b[parameterToFilterWith]-a[parameterToFilterWith]));
            var latestReadingObj =readingDataObj[0];
            //filter out everything outside specified timestamp
            var filteredData=readingDataObj.filter(obj=>{
                var difference=latestReadingObj["timestamp"]-obj["timestamp"];
                var minutesDifference = Math.floor(difference/1000/60);
                if(minutesDifference>howMantMinutesBack){
                    return false;
                }
                return true;
            });
            return filteredData;
        }
    });
})();