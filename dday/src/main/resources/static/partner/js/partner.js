$('input.submitButton').on("click", function(){
    $(location).attr("href","/partner/partner_management");
});

$('input.removeButton').on("click", function(){
    $(location).attr("href","/partner/partner_management");
});

$('form.registForm').attr('id', 'writeForm');

$('form.todayRegistForm').hide();

$showTodayForm = function() {
        $('#checkToday1').prop('checked',false);
        $('form.todayRegistForm').attr('id', 'writeForm');
        $('form.registForm').removeAttr('id', 'writeForm');
        $('form.registForm').hide();
        $('form.todayRegistForm').show();
}

$showRegistForm = function(){
    $('#checkToday2').prop('checked',true);
    $('form.registForm').attr('id', 'writeForm');
    $('form.todayRegistForm').removeAttr('id', 'writeForm');
    $('form.todayRegistForm').hide();
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
    alert('송장번호: ' + delieveryNum + '등록되었습니다');
    $('p.changeDeliveryStatus').text("방문예정");
}




// 파트너 인증 버튼 클릭시
$('input.partnerSubmitButton').on('click', function(){
    alert('인증되었습니다');
    //사업자 인증 api
});

$("input[type=radio]").on('click',function(e){
    $('p.changeDeliveryStatus').text(e.target.value);
});

