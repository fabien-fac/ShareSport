/**
 * Created by fabien on 23/10/14.
 */

$( document ).ready(function() {

    $( "#button-connect" ).click(function() {

        var valid = true;

        if( $( "#password-connect" ).val().length < 8 ){
            valid = false;
            $( "#password-connect" ).addClass("error");
        }
        else {
            $( "#password-connect" ).removeClass("error");
        }

        if( !isEmailValid( $( "#email-connect").val() ) ){
            valid = false;
            $( "#email-connect" ).addClass("error");
        }
        else {
            $( "#email-connect" ).removeClass("error");
        }

        if( valid ) {

            var xmlRequest = $.ajax({
                type: "POST",
                url: "/ShareSport/user/login",
                data: {"email": $( "#email-connect").val(), "password": $( "#password-connect").val()}
            });

            xmlRequest.done( function(response){
                processingLoginResponse(response);
            });

        }

    });

});

var processingLoginResponse = function (response) {
    console.log(response);
    if(response.succeed == "true"){
        $( "#password-connect" ).removeClass("error");
        $( "#email-connect" ).removeClass("error");
        console.log("succeed");
        window.location.replace(window.location.href + response.url);
    }
    else{
        $( "#password-connect" ).addClass("error");
        $( "#email-connect" ).addClass("error");
    }
};