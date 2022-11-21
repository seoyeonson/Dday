// 인증 요청 (memberReport)의 체크박스
function checkSelectAll() {
  // 전체 체크박스
  const checkboxes = document.querySelectorAll('input[name="check_btn"]');
  // 선택된 체크박스
  const checked = document.querySelectorAll('input[name="check_btn"]:checked');
  // select all 체크박스
  const selectAll = document.querySelector('input[name="selectall"]');

  if (checkboxes.length === checked.length) {
    selectAll.checked = true;
  } else {
    selectAll.checked = false;
  }

}

function selectAll(selectAll) {
  const checkboxes
    = document.getElementsByName('check_btn');

  checkboxes.forEach((checkbox) => {
    checkbox.checked = selectAll.checked
  })
}


// 배너 수정
function confirmBanner() {
  var checkedList = document.querySelectorAll('input[name="check_btn"]:checked');
  if (checkedList.length == 0) {
    alert('배너을 선택해주세요');
  } else {
    for (var i = 0; i < checkedList.length; i++) {
      if (checkedList[i].checked) {
        checkedList[i].parentElement.parentElement.remove();
      }
    }
    var returnValue = confirm('해당 배너를 삭제시키겠습니까?');
    if (returnValue == true) {
      alert('삭제 성공');

    } else {
      alert('삭제 실패');
    }
  }
}
// 공지 수정
function confirmNotice() {
  var checkedList = document.querySelectorAll('input[name="check_btn"]:checked');
  if (checkedList.length == 0) {
    alert('공지를 선택해주세요');
  } else {
    for (var i = 0; i < checkedList.length; i++) {
      if (checkedList[i].checked) {
        checkedList[i].parentElement.parentElement.remove();
      }
    }
    var returnValue = confirm('해당 공지를 삭제시키겠습니까?');
    if (returnValue == true) {
      alert('삭제 성공');

    } else {
      alert('삭제 실패');
    }
  }
}


//전체 회원 테이블에서 삭제 버튼 클릭시 회원 삭제
function remove_tr(This) {
  var returnValue = confirm("이 회원을 목록에서 삭제 하시겠습니까?");
  if (returnValue == true) {
    alert("회원 목록에서 삭제 됩니다");
    This.closest('tr').remove();
    // 회원 번호로 실제 블랙리스트 db에서 회원 삭제

  }
}

function test() {
  var p1 = document.getElementById('password').value;
  var p2 = document.getElementById('confirm_password').value;
  let move = confirm("해당 정보를 저장하시겠습니까?");

  if (p1.length < 9 || p1.length > 17) {
    alert('비밀번호는 10 ~ 16자리 이하여야합니다.');
    return false;
  }

  if (p1 != p2) {
    alert("비밀번호가 일치하지않습니다.");
    return false;
  } else{
    if(move){

      alert("수정 성공!");
      location.href="/Project/manager/html/member/memberAll.html";
      return true;
    }
  }
}

