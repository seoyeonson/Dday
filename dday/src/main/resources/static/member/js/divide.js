$(document).ready(function(){
    $('#partner_join').click(admin);
    $('#basic_join').click(basic);
});

function admin(){
   sellerForm.submit();
}

function basic(){
    userForm.submit();
}