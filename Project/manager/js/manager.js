  // 인증 요청 (memberReport)의 체크박스
  function checkSelectAll()  {
    // 전체 체크박스
    const checkboxes = document.querySelectorAll('input[name="check_btn"]');
    // 선택된 체크박스
    const checked = document.querySelectorAll('input[name="check_btn"]:checked');
    // select all 체크박스
    const selectAll = document.querySelector('input[name="selectall"]');
    
    if(checkboxes.length === checked.length)  {
      selectAll.checked = true;
    }else {
      selectAll.checked = false;
    }
  
  }
  
  function selectAll(selectAll)  {
    const checkboxes 
       = document.getElementsByName('check_btn');
    
    checkboxes.forEach((checkbox) => {
      checkbox.checked = selectAll.checked
    })
  }
  

// 회원 인증 파일 확인 후 승인
  function confirmMember() {
    var checkedList = document.querySelectorAll('input[name="check_btn"]:checked');
    if(checkedList.length == 0 ){
      alert('회원을 선택해주세요');
    }else {
      for(var i = 0; i < checkedList.length; i++){
        if(checkedList[i].checked){
          checkedList[i].parentElement.parentElement.remove();
        }
      }
    var returnValue = confirm('회원을 탈퇴시키겠습니까?');
    if(returnValue == true){
      alert('탙퇴 성공');
      
    }else {
      alert('탈퇴 실패');
    }
  }
}


//전체 회원 테이블에서 삭제 버튼 클릭시 회원 삭제
function remove_tr(This) {
    var returnValue = confirm("이 회원을 목록에서 삭제 하시겠습니까?");
    if(returnValue==true){
       alert("회원 목록에서 삭제 됩니다");
      This.closest('tr').remove();
      // 회원 번호로 실제 블랙리스트 db에서 회원 삭제
      
    }
}


