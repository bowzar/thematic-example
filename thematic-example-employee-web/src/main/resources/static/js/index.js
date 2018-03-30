$(function(){

    $("#btnRequest").click(function(e){

    var msg = $("#message").val();
        $.get("/employee/echo/"+ msg).then(function (val){

        $("#result").val(val);

        },function(err){

                $("#result").val(err);
        });
    });
})