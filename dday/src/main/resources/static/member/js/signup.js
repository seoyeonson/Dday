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

$radio_circle.on("click",function(){
    $(this).prev().prop("checked", true);
    checkRadio();
});

function checkRadio(){
    let $input_radio = $("input[name=gender]");
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

// $agrees.on("click", function(){
//     let check = 0
//     if($(this).is(":checked")){
//         $(this).next().prop("src", "../image/check.svg");
//     } else {
//         $(this).next().prop("src", "../image/no-check.svg");
//     }

//     $.each($agrees, function(){
//         if($(this).is(":checked")){
//             check += 1
//         }
//     });

//     if(check == $agrees.length){
//         $agreeAll.next().attr("src", "../image/check.svg");
//         $agreeAll.prop("checked", true);
//     } else {
//         $agreeAll.next().attr("src", "../image/no-check.svg");
//         $agreeAll.prop("checked", false);
//     }
// });

$(".signup_submit button").on("click", function(){
    // if(signupForm.[name명].value == ""){
    //     alert("이름을 입력해주세요.");
    // } 
    // else if (){ .. } ==> 필수 입력 모두 체크
    // else if(!$agreeAll.is(":checked")){ alert("약관을 동의해주세요.")}
    // else { signupForm.submit(); }
});
