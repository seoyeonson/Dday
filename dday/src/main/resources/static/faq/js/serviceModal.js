$('button.submitButton').on('click', function(){
    $('div.modal').fadeIn();
});

$('div.okModal').click(function(){
    console.log('들어옴');
    $('div.modal').fadeOut();
    $(location).attr("href", "serviceQuestion.html");
});
    


