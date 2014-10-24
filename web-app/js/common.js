/**
 * Created by fabien on 24/10/14.
 */

var getApplicationUrl = function () {

    var pathname = window.location.pathname;
    var baseUrl = "/";

    if(pathname.indexOf("ShareSport") >= 0){
        baseUrl += "ShareSport/";
    }

    return baseUrl;
}