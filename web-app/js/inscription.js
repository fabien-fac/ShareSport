
$( document ).ready(function() {

    $( "#button-signin" ).click(function() {

        var valid = true;

        if(!isEmailValid( $( "#email-signin").val() )){
            $( "#msg-email-signin").html("Adresse email invalide");
            valid = false;
        }
        else{
            $( "#msg-email-signin").html("");
        }

        if(!isLoginValid( $( "#login-signin").val() )){
            $( "#msg-login-signin").html("Login invalide");
            valid = false;
        }
        else{
            $( "#msg-login-signin").html("");
        }

        if(!isPasswordValid( $( "#password-signin").val() )){
            $( "#msg-password-signin").html("Mot de passe invalide");
            valid = false;
        }
        else{
            $( "#msg-password-signin").html("");
        }

        if(valid){
            var baseUrl = getApplicationUrl();

            var xmlRequest = $.ajax({
                type: "POST",
                url: baseUrl+"user/signUp",
                data: {"email": $( "#email-signin").val(), "login": $( "#login-signin").val(), "password": $( "#password-signin").val()}
            });

            xmlRequest.done( function(response){
                processingInscriptionResponse(response);
            });

            xmlRequest.fail( function() {
                $.fancybox("<strong>Une erreur serveur est survenue</strong>");
            });
        }

    });
});

var isEmailValid = function (emailAddress){
    var pattern = new RegExp(/^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i);
    return pattern.test(emailAddress);
};

var isLoginValid = function (login) {
    return ( login.length > 3 && login.length < 21 );
};

var isPasswordValid = function (password) {
    return ( password.length > 7 && password.length < 41);
};

var processingInscriptionResponse = function (responseInscription) {
    if(responseInscription.succeed == "true"){
        $.fancybox("<strong>Inscription réussie</strong>");
        $( "#email-signin").val("");
        $( "#login-signin").val("");
        $( "#password-signin").val("");
    }
    else{
        if(responseInscription.emailError != "") {
            $( "#msg-email-signin").html("Email déjà utilisé");
        }
        if(responseInscription.loginError != ""){
            $( "#msg-login-signin").html("Login déjà utilisé");
        }
    }
};