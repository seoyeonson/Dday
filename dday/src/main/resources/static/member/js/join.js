// 비밀번호 정규식
$("#memberPw").on("blur", function(){
    if(!checkPw()){
        $("#checkPw_msg").closest(".msg").css("padding", "10px 0px");
    } else {
        $("#checkPw_msg").closest(".msg").css("padding", "");
    }
});

function checkPw(){
    let memberPw = $("#memberPw").val();
    let num = memberPw.search(/[0-9]/g);
    let eng = memberPw.search(/[a-z]/ig);
    let spe = memberPw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
    let $checkPw_msg = $("#checkPw_msg");
   
    if(memberPw.length < 8){
        $checkPw_msg.text("최소 8자 이상 입력");
        return false;
    }else if( (num < 0 && eng < 0) || (eng < 0 && spe < 0) || (spe < 0 && num < 0) ){
        $checkPw_msg.text("영문/숫자/특수문자(공백 제외)만 허용하며, 2개 이상 조합");
        return false;
    }else {
        $checkPw_msg.text("");	 
    }
    return true;
   }

// 비밀번호 재확인
$("#memberPwCheck").on("blur", function(){
    if($("#memberPw").val() != ""){
        if(!checkPwOk()){
            $("#checkPwOk_msg").closest(".msg").css("padding", "10px 0px");
        } else {
            $("#checkPwOk_msg").closest(".msg").css("padding", "");
        }
    }
});

function checkPwOk(){
    let memberPw = $("#memberPw").val();
    let memberPwCheck = $("#memberPwCheck").val();
    let $checkPwOk_msg = $("#checkPwOk_msg");

    if(memberPw != memberPwCheck){
        $checkPwOk_msg.text("동일한 비밀번호를 입력");
        return false;
    } else {
        $checkPwOk_msg.text("");
    }
    return true;
}

// 이메일 정규식
$('#email').change(function() {
    let email = $(this).val();
    let pattern_email = /^[\w-]+(\.[\w-]+)*@([\w-]+\.)+[a-zA-Z]+$/;
    pattern_email = new RegExp(pattern_email);

    if(email != ""){
        if (pattern_email.test(email) == false) {
            $("#checkEmail_msg").closest(".msg").css("padding", "10px 0px");
            $("#checkEmail_msg").text('이메일 형식으로 입력해주세요.');
            $(this).focus();
        } 
    } else{
        $("#checkEmail_msg").text('');
        $("#checkEmail_msg").closest(".msg").css("padding", "");
    }
  });

// 성별선택
const $radio_circle = $(".radio_circle");
const $memberGender = $("input[name='memberGender']");
$(document).ready(
    function(){
        $("input[value='선택안함']").prop("checked", true);
        // console.log($memberGender);
        // $.each($memberGender, function(){
        //     console.log("checked: " + $(this).prop("checked"));
        // })
    }
)


$radio_circle.on("click",function(){
    $(this).prev().prop("checked", true);
    checkRadio();
});

function checkRadio(){
    let $input_radio = $("input[name=memberGender]");
    $.each($input_radio, function(){
        if($(this).is(":checked")){
            $(this).next().addClass("input_choice");
        } else {
            $(this).next().removeClass("input_choice");
        }
    });
}

// 생일 년, 월, 일 정규식
// /^(19[0-9][0-9]|20\d{2})(0[0-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$/
$(".birth_box input").on("blur", function(){
    if(!checkBirth()){
        $("#checkBirth_msg").closest(".msg").css("padding", "10px 0px");
    } else {
        $("#checkBirth_msg").closest(".msg").css("padding", "");
    }

});

function checkBirth(){
    let pattern_birth = new RegExp(/^(19[0-9][0-9]|20\d{2})(0[0-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$/);
    const $birth_inputs = $(".birth_box input");
    const $checkBirth_msg = $("#checkBirth_msg");
    let birth = "";
    
    $.each($birth_inputs, function(){
        birth += $(this).val();
    });

    if(!pattern_birth.test(birth)){
        $checkBirth_msg.text("생년월일을 다시 확인해주세요.");
        return false;
    } else {
        $checkBirth_msg.text("");
        return true;
    }
}

// 정보 동의
const $agrees = $(".agree");
const $agreeAll = $("#agreeAll");
const $checkboxs = $(".agree_content input[type=checkbox]");

$agreeAll.on("click", function(){
    if($(this).is(":checked")){
        $checkboxs.next("span").addClass("fill");
        $checkboxs.prop("checked", true);
    } else {
        $checkboxs.next("span").removeClass("fill");
        $checkboxs.prop("checked", false);
    }
})

$agrees.on("click", function(){
    let check = 0
    if($(this).is(":checked")){
        $(this).next("span").addClass("fill");
    } else {
        $(this).next("span").removeClass("fill");
    }

    $.each($agrees, function(){
        if($(this).is(":checked")){
            check += 1
        }
    });

    if(check == $agrees.length){
        $agreeAll.next("span").addClass("fill");
        $agreeAll.prop("checked", true);
    } else {
        $agreeAll.next("span").removeClass("fill");
        $agreeAll.prop("checked", false);
    }
});

var $phone_check_button = $("button.phone_check_button");
var $memberPhoneNumber = $("input#memberPhoneNumber");
var $num_check_button = $("button.num_check_button");
var $phoneNumCheck = $("input#phoneNumCheck");
var x;

$memberPhoneNumber.on("keyup", function(){
    keyupCheck($memberPhoneNumber, $phone_check_button);
});

$phoneNumCheck.on("keyup", function(){
    keyupCheck($phoneNumCheck, $num_check_button);
});

$num_check_button.on("click", function(){
    clearInterval(x);
    let check = true;

    if(check){
        // 만약에 인증번호가 일치한다면 수정 불가능
        document.getElementById("timer").innerHTML = "";

        // 인증번호 버튼, 입력버튼 비활성화
        buttonDisable($(this));
        inputDisable($phoneNumCheck);
    } else {
        // 다시 인증번호 받기
    }
});

// 번호 인증 버튼을 누를 경우
$phone_check_button.on("click", function(){
    <!-- 카운트다운 타이머 -->
    let time = 180; //기준시간설정
    let min = ""; //분
    let sec = ""; //초

    //setInterval(함수, 시간) : 주기적인 실행
    x = setInterval(function(){
        //parseInt : 정수 반환
        min = parseInt(time/60) /* 몫계산 */
        sec = time%60; //나머지 계산

        document.getElementById("timer").innerHTML = min + "분" + sec + "초";
        time--;

        //시간 끝나면
        if(time < 0) {
            clearInterval(x); //setInterval() 실행을 끝냄

            // 번호 입력을 다시 받기.
            $memberPhoneNumber.prop("placeholder", "다시 입력해주세요.");
            $memberPhoneNumber.val("");

            // 번호 입력창 활성화
            inputAble($memberPhoneNumber);

            // 인증번호 입력칸 감추기
            $('div.num_check_input').css("display", "none");

            $phoneNumCheck.val("");
        }
    }, 1000);

    // 인증번호 입력칸 보이게 하기
    $('div.num_check_input').css("display", "inline-flex");
    // 인증번호 입력창, 버튼 활성화
    inputDisable($memberPhoneNumber);
    buttonDisable($(this));
});

// 번호 및 인증번호 길이에 맞게 입력시 버튼 활성화
// ※ input button에 maxlength 가 명시되어있어야함.
function keyupCheck(input, btn){
    let length = input.val().length;
    let checkLength = input.attr("maxlength");

    if(length == checkLength){
        buttonAble(btn);
    }
}

// 버튼 활성화
function buttonAble(btn){
    btn.removeClass("disabled_button");
    btn.prop("disabled", false);
}

// 버튼 비활성화
function buttonDisable(btn){
    btn.addClass("disabled_button");
    btn.prop("disabled", true);
}

// 입력창 비활성화
function inputDisable(input){
    input.prop("readonly", true);
    input.css("color", "rgb(221, 221, 221)");
}

// 입력창 활성화
function inputAble(input){
    input.prop("readonly", false);
    input.css("color", "black");
}

// 인증완료시 모달창
$('div.modalContainer').hide();

$('button.num_check_button').on('click', function(){
    $("div.modalContainer").fadeIn();
});

$('button.modalCancelButton').on('click',function(){
    $('div.modalContainer').fadeOut();
});

// 주소 입력
function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                $(".addressDetail").val(extraAddr);

            } else {
                $(".addressDetail").val('');
            }

            // 주소 정보를 해당 필드에 넣는다.
            $(".addressMain").val(addr);
            // 커서를 상세주소 필드로 이동한다.
            $(".addressDetail").focus();
        }
    }).open();
}


$(".signup_submit button").on("click", function(){
    // if(signupForm.[name명].value == ""){
    //     alert("이름을 입력해주세요.");
    // } 
    // else if (){ .. } ==> 필수 입력 모두 체크
    // else if(!$agreeAll.is(":checked")){ alert("약관을 동의해주세요.")}
    // else { signupForm.submit(); }
    joinForm.submit();
});
