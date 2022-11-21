$('input.submitButton').on("click", function(){
    $(location).attr("href","/Project/partner/html/partner_management.html");
});

$('input.removeButton').on("click", function(){
    $(location).attr("href","/Project/partner/html/partner_management.html");
});


$('form.todayResgistForm').hide();

$showTodayForm = function() {
        $('#checkToday1').prop('checked',false);
        $('form.registForm').hide();
        $('form.todayResgistForm').show();
}

$showRegistForm = function(){
    $('#checkToday2').prop('checked',true);
    $('form.todayResgistForm').hide();
    $('form.registForm').show();
}

$('#checkToday1').on('change',function(){
    $showTodayForm();
});
$('#checkToday2').on('change',function(){
    $showRegistForm();
});

var delieveryNum = "";
function getDelieveryNumber(){
    delieveryNum = $('input.deliveryNumber').val();
    var inputURL = 'https://apis.tracker.delivery/carriers/kr.epost/tracks/' + delieveryNum;
    window.open(inputURL,'송장등록', 'width:500px, height:500px;');
}

function delieveryDetail(){
    var fullURL = 'https://tracker.delivery/#/kr.epost/'+delieveryNum;
    window.open(fullURL, '배달현황', 'width:500px, height:500px;');
    // $(location).attr('href', '"https://tracker.delivery/#/kr.epost/" + delieveryNum');
    // <a href="https://tracker.delivery/#/kr.epost/1111111111111" target="_blank"></a>
}