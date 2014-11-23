/**
 * Created by fabien on 23/11/14.
 */

var userName = null;
var lastId = -1;
var intervalTchat;
var eventId = null;

$(document).ready(function() {

    if ( $( "#id-event" ).length ) {
        loadEventId();
        loadUsername();
        loadTchat();

        /*
        intervalTchat = setInterval(function () {
            loadTchat();
        },3000);
        */
    }

    $('#input-tchat').keypress(function(event) {
        if (event.keyCode == 13) {
            sendMessage();
        }
    });

});

var loadEventId = function() {
    eventId = $("#id-event").html();
}

var loadUsername = function () {

    var baseUrl = getApplicationUrl();

    var xmlRequest = $.ajax({
        url: baseUrl+"user/getUsername",
        type: "POST",
        dataType: "json"
    });

    xmlRequest.done(function( response ) {
        if(response.userName != undefined){
            userName = response.userName;
        }
    });
    xmlRequest.fail(function( jqXHR, textStatus ) {
        console.log( "Request failed: " + textStatus );
    });

};

var loadTchat = function () {

    var baseUrl = getApplicationUrl();

    var xmlRequest = $.ajax({
        url: baseUrl+"event/getAllMessage",
        type: "POST",
        data: {idLast : lastId, idEvent: eventId},
        dataType: "json"
    });

    xmlRequest.done(function( response ) {
        displayTchat(response);
    });
    xmlRequest.fail(function( jqXHR, textStatus ) {
        console.log( "Request failed: " + textStatus );
    });

};

var displayTchat = function (messagesJson) {

    var baseUrl = getApplicationUrl();
    var userPicture = baseUrl + "user/getImage/?user=";
    var scroll = false;
    var side = "";

    if(checkIfTchatScrollBottom()){
        scroll = true;
    }

    $.each(messagesJson, function(key, data){

        var content = "";
        if(data.mId > lastId){
            if(data.mAuteur === userName){
                side = "right";
            }
            else{
                side = "left";
            }
            content += "<div class='message-"+side+"'>";
            content += "<div class='message-picture-"+side+"'>"
            content += "<img src='" + userPicture + data.mAuteur +"' height='50' width='50'/>";
            content += "</div>";
            content += "<div id='mess"+data.mId+"' class='mgg-tect message-text-"+side+"'>";
            content += "</div>";
            content += "<div style='clear: both;'/>"
            content += "</div>";

            lastId = data.mId;
            $("#box-messages").append(content);
            $("#mess"+data.mId).html(textToLink(data.mMessage));
            $("#mess"+data.mId).append("<br><span class='grey-text'>" + data.mAuteur + " - " + getDateToDateText(data.mDate) + "</span>");

        }

    });

    if(scroll){
        scrollTchat();
    }

};

var scrollTchat = function() {
    $('#box-messages').scrollTop($('#box-messages')[0].scrollHeight);
};

var checkIfTchatScrollBottom = function() {

    if($("#box-messages").scrollTop() + $("#box-messages").innerHeight()>=$("#box-messages")[0].scrollHeight)
    {
        return true;
    }

    return false;
};

var sendMessage = function() {
    var baseUrl = getApplicationUrl();

    var xmlRequest = $.ajax({
        url: baseUrl+"event/sendMessage",
        type: "POST",
        data: { message : $( "#input-tchat").val(), idEvent : eventId},
        dataType: "json"
    });

    xmlRequest.done(function( response ) {
        if(response.valid == "ok"){
            loadTchat();
            $( "#input-tchat").val("");
        }
    });
    xmlRequest.fail(function( jqXHR, textStatus ) {
        console.log( "Request failed: " + textStatus );
    });
};

var getDateToDateText = function (date) {
    var res = date.split("T")[0].split("-");
    var month = getMonthToMonthText(res[1]);
    var day = getDayToDayText(res[2]);
    return day + " " + month + " " + res[0];
};

var getDayToDayText = function (day) {
    if(day.substr(0,1) == "0"){
        return day.substring(1);
    }

    return day;
};

var getMonthToMonthText = function (monthNumber) {
    switch(monthNumber) {

        case "01":
            return "Janvier";
        case "02":
            return "Fevrier";
        case "03":
            return "Mars";
        case "04":
            return "Avril";
        case "05":
            return "Mai";
        case "06":
            return "Juin";
        case "07":
            return "Juillet";
        case "08":
            return "Aout";
        case "09":
            return "Septembre";
        case "10":
            return "Octobre";
        case "11":
            return "Novembre";
        case "12":
            return "Decembre";
        default :
            return monthNumber;
    }
};

var textToLink = function(text) {
    var regex = /((([A-Za-z]{3,9}:(?:\/\/)?)(?:[-;:&=\+\$,\w]+@)?[A-Za-z0-9.-]+|(?:www.|[-;:&=\+\$,\w]+@)[A-Za-z0-9.-]+)((?:\/[\+~%\/.\w-_]*)?\??(?:[-\+=&;%@.\w_]*)#?(?:[\w]*))?)/
    return text.replace(regex, "<a class='link-tchat' href='$1' target='_blank'>$1</a>");
};