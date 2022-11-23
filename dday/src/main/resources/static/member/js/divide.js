$(document).ready(function(){
    $('#owner_join').click(admin);
    $('#basic_join').click(basic);
});

function admin(){
   sellerForm.submit();
}

function basic(){
    userForm.submit();
}