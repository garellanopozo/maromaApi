/**
 * Created by germa on 3/11/2016.
 */
angular.module('myApp.filter', [])
    .filter('capitalizeFirst', ['$filter',function ($filter) {
        return function (data) {
            /*
             * this is other way using java script only
             * console.log(data.charAt(0).toUpperCase() + (data.toLowerCase()).substring(1));
             * */
            if( data !== undefined ){
                return $filter('uppercase')($filter('limitTo')(data,1)) + $filter('lowercase')(data.substring(1));
            }
        };
    }])
    .filter('capitalize', ['$filter',function ($filter) {
        return function (data) {
            if( data !== undefined ){
                return (!!data) ? data.replace(/([^\W_]+[^\s-]*) */g, function(txt){return txt.charAt(0).toUpperCase() + txt.substr(1).toLowerCase();}) : '';
            }
        };
    }])
    .filter('getById', function() {
        return function(input, id) {
            var i=0, len=input.length;
            for (; i<len; i++) {
                if (+input[i].id == +id) {
                    return input[i];
                }
            }
            return null;
        }
    });