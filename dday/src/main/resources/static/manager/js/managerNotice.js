
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
$('button.photoButton1').on("click", function(){
    $('input.fileInput').click();
})

$('#thumb1').hide();
$("#fileInput").on("change", function(event) {

    var file = event.target.files[0];

    var reader = new FileReader(); 
    reader.onload = function(e) {
        $("#thumb1").attr("src", e.target.result);
    }
    reader.readAsDataURL(file);
    $('#thumb1').show();
    $('button.photoButton1').hide();
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

function check() {
    let move = confirm("글을 저장하시겠습니까?");
    if ($(".inputTitle").val() == "") {
        alert("제목을 적어주세요.");
        return false;
    } else if ($(".contentsArea").val() == "") {
        alert("글을 작성해주세요.");
        return false;
    }else if ($("#mainType").val() == "공지유형을 선택해주세요") {
        alert("유형을 선택해주세요.");
        return false;
    }else {
       if(move) {
           location.href ='/Project/serviceCenter/html/noticeBoardListDetail.html'
           alert("공지가 등록되었습니다.")
       }else{

       }

    }

}
function bannerSubmit() {
    let move = confirm("배너를 등록하시겠습니까?");
    if ($("#mainType").val() == "배너 번호를 선택해주세요") {
        alert("배너 번호를 선택해주세요.");
        return false;
    } else if ($(".contentsArea").val() == "") {
        alert("배너 이미지 설명을 작성해주세요.");
        return false;
    }else if ($(".inputLink").val() == "") {
        alert("배너 링크 주소를 적어주세요.");
        return false;
    }else if ($("#fileInput").val() == "") {
        alert("배너 이미지를 넣어주세요.");
        return false;
    }else {
       if(move) {
           location.href ='/Project/manager/html/banner/managerBanner.html'
           alert("배너가 등록되었습니다.")
       }else{

       }

    }

}
function bannerSubmit2() {
    let move = confirm("배너를 수정하시겠습니까?");
    if ($("#mainType").val() == "배너 번호를 선택해주세요") {
        alert("배너 번호를 선택해주세요.");
        return false;
    } else if ($(".contentsArea").val() == "") {
        alert("배너 이미지 설명을 작성해주세요.");
        return false;
    }else if ($(".inputLink").val() == "") {
        alert("배너 링크 주소를 적어주세요.");
        return false;
    }else if ($("#fileInput").val() == "") {
        alert("배너 이미지를 넣어주세요.");
        return false;
    }else {
       if(move) {
           location.href ='/Project/manager/html/banner/managerBanner.html'
           alert("배너가 수정되었습니다.")
       }else{

       }

    }

}