$('#listButton').on("click", function(){
    $(location).attr("href", "/serviceCenter/html/serviceNotice.html");
});

$('li.answer').hide();
$('li.faq').on("click", function(){
    $('li.answer').toggle();
});

$('button.questionButton').on("click", function(){
    $(location).attr("href", "/serviceCenter/html/questionForm.html");
});

function typeChange(e) {
    var detailType_01 = ["상세유형을 선택해주세요", "주문취소 해주세요", "상품 반품을 원해요", "상품 교환을 원해요", "주문/결제는 어떻게 하나요?", "오류로 주문/결제가 안 돼요", "기타(직접 입력)"];
    var detailType_02 = ["상세유형을 선택해주세요", "쿠폰 관련 문의드려요","적립금 관련 문의드려요", "이벤트 관련 문의드려요", "증정품 관련 문의드려요", "할인 관련 문의드려요", "기타(직접 입력)"];
    var detailType_03 = ["상세유형을 선택해주세요", "불량상품 환불 해주세요", "파손 상품 환불 해주세요", "상품에 대해 알려주세요", "기타(직접 입력)"];
    var detailType_04 = ["상세유형을 선택해주세요", "상품이 다른곳으로 갔어요","배송 상품이 안 왔어요", "배송정보 변경 해주세요", "포장 상태가 좋지 않아요", "상품이 회수되지 않았어요", "배송비에 대해 궁금합니다", "기타(직접 입력)"];
    var detailType_05 = ["상세유형을 선택해주세요", "누락된 상품 환불해주세요","다른 상품와서 환불 원해요", "기타(직접 입력)"];
    var detailType_06 = ["상세유형을 선택해주세요", "로그인/회원 문의하고 싶어요", "이용 중 오류가 발생했어요", "컬리패스에 대해 알고싶어요", "퍼플박스에 대해 알고싶어요", "컬리에게 제안하고 싶어요", "기타(직접 입력)"];
    var target = document.getElementById("detailType");
   
    if(e.value == "01") var d = detailType_01;
    else if(e.value == "02") var d = detailType_02;
    else if(e.value == "03") var d = detailType_03;
    else if(e.value == "04") var d = detailType_04;
    else if(e.value == "05") var d = detailType_04;
    else if(e.value == "06") var d = detailType_06;
   
    target.options.length = 0;
   
    for (x in d) {
      var opt = document.createElement("option");
      opt.value = d[x];
      opt.innerHTML = d[x];
      target.appendChild(opt);
    } 
  }

$('textArea.contentsArea').on("click", function(){
    $('div.placeholder').hide();
});

$('button.photoButton').on("click", function(){
    $('input.fileInput').click();
})

$('#thumb').hide();
$("#fileInput").on("change", function(event) {

    var file = event.target.files[0];

    var reader = new FileReader(); 
    reader.onload = function(e) {
        $("#thumb").attr("src", e.target.result);
    }
    reader.readAsDataURL(file);
    $('#thumb').show();
    $('button.photoButton').hide();
});


$(function(){
    let num=0;
    $('img.agreeImage').on('click', function(){
        if(num == 0){
            $('img.agreeImage').attr('src','data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyNCIgaGVpZ2h0PSIyNCIgdmlld0JveD0iMCAwIDI0IDI0Ij4KICAgIDxnIGZpbGw9Im5vbmUiIGZpbGwtcnVsZT0iZXZlbm9kZCI+CiAgICAgICAgPGcgc3Ryb2tlPSIjREREIj4KICAgICAgICAgICAgPGc+CiAgICAgICAgICAgICAgICA8Zz4KICAgICAgICAgICAgICAgICAgICA8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSgtNjY5LjAwMDAwMCwgLTEwOTAuMDAwMDAwKSB0cmFuc2xhdGUoMTAwLjAwMDAwMCwgOTM2LjAwMDAwMCkgdHJhbnNsYXRlKDU1My4wMDAwMDAsIDE0Mi4wMDAwMDApIHRyYW5zbGF0ZSgxNi4wMDAwMDAsIDEyLjAwMDAwMCkiPgogICAgICAgICAgICAgICAgICAgICAgICA8Y2lyY2xlIGN4PSIxMiIgY3k9IjEyIiByPSIxMS41Ii8+CiAgICAgICAgICAgICAgICAgICAgICAgIDxwYXRoIHN0cm9rZS1saW5lY2FwPSJyb3VuZCIgc3Ryb2tlLWxpbmVqb2luPSJyb3VuZCIgc3Ryb2tlLXdpZHRoPSIxLjUiIGQ9Ik03IDEyLjY2N0wxMC4zODUgMTYgMTggOC41Ii8+CiAgICAgICAgICAgICAgICAgICAgPC9nPgogICAgICAgICAgICAgICAgPC9nPgogICAgICAgICAgICA8L2c+CiAgICAgICAgPC9nPgogICAgPC9nPgo8L3N2Zz4K')
            num=1;
        }else {
            $('img.agreeImage').attr('src', 'data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyNCIgaGVpZ2h0PSIyNCIgdmlld0JveD0iMCAwIDI0IDI0Ij4KICAgIDxnIGZpbGw9Im5vbmUiIGZpbGwtcnVsZT0iZXZlbm9kZCI+CiAgICAgICAgPGc+CiAgICAgICAgICAgIDxnPgogICAgICAgICAgICAgICAgPGc+CiAgICAgICAgICAgICAgICAgICAgPGcgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoLTE3Ni4wMDAwMDAsIC0xMDkwLjAwMDAwMCkgdHJhbnNsYXRlKDEwMC4wMDAwMDAsIDkzNi4wMDAwMDApIHRyYW5zbGF0ZSg2MC4wMDAwMDAsIDE0Mi4wMDAwMDApIHRyYW5zbGF0ZSgxNi4wMDAwMDAsIDEyLjAwMDAwMCkiPgogICAgICAgICAgICAgICAgICAgICAgICA8Y2lyY2xlIGN4PSIxMiIgY3k9IjEyIiByPSIxMiIgZmlsbD0iIzVGMDA4MCIvPgogICAgICAgICAgICAgICAgICAgICAgICA8cGF0aCBzdHJva2U9IiNGRkYiIHN0cm9rZS1saW5lY2FwPSJyb3VuZCIgc3Ryb2tlLWxpbmVqb2luPSJyb3VuZCIgc3Ryb2tlLXdpZHRoPSIxLjUiIGQ9Ik03IDEyLjY2N0wxMC4zODUgMTYgMTggOC41Ii8+CiAgICAgICAgICAgICAgICAgICAgPC9nPgogICAgICAgICAgICAgICAgPC9nPgogICAgICAgICAgICA8L2c+CiAgICAgICAgPC9nPgogICAgPC9nPgo8L3N2Zz4K')
            num = 0;
        }
    });
});

$('#contentsArea').keyup(function (e) {
    let content = $(this).val();
    var titleCheck = $('input.inputTitle').val(); 
    var btnSubmit = $('button.submitButton');
    if (titleCheck === '' || content == '') {
        btnSubmit.removeClass('on');
    } else {
        btnSubmit.addClass('on');
    }
});

$('#contentsArea').keyup(function (e) {
	let content = $(this).val();
    
    // 글자수 세기
    if (content.length == 0 || content == '') {
    	$('.textCount').text('0자');
    } else {
    	$('.textCount').text(content.length + '자');
    }
    
    // 글자수 제한
    if (content.length > 5000) {
    	// 5000자 부터는 타이핑 되지 않도록
        $(this).val($(this).val().substring(0, 5000));
        alert('글자수는 5000자까지 입력 가능합니다.');
    };
});