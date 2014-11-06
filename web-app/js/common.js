/**
 * Created by fabien on 24/10/14.
 */

$( document ).ready(function() {
    var pathname = window.location.pathname;
    if(pathname.indexOf("login/auth?login_error=") >= 0){
        $("form-connect").hide();
    }
});

var getApplicationUrl = function () {

    var pathname = window.location.pathname;
    var baseUrl = "/";

    if(pathname.indexOf("ShareSport") >= 0){
        baseUrl += "ShareSport/";
    }

    return baseUrl;
}