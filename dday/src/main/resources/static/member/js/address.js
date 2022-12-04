// 주소 추가
async function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function (data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var roadAddr = data.roadAddress; // 도로명 주소 변수
            var jibunAddr = data.jibunAddress; // 지번 주소 변수
            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('member_post').value = data.zonecode;
            if (roadAddr !== '') {
                document.getElementById("member_addr").value = roadAddr;
                newDelivery();
            } else if (jibunAddr !== '') {
                document.getElementById("member_addr").value = jibunAddr;
                newDelivery();
            }
        }
    }).open();
    // await alert("안녕하세요");
}

// 모달창 숨겨놓기
$('div.addressModalContainer').hide();

function newDelivery() {
    $("div.addressModalContainer").fadeIn();

    // 저장버튼 누르면 모달창 사라짐
    $('button.addressModalOkButton').on('click', function () {
        $('div.addressModalContainer').hide();
    // 배달주소 리스트 추가

    });

    // 취소버튼 누르면 모달창 사라짐
    $('button.addressModalCancelButton').on('click', function () {
        $('div.addressModalContainer').hide();
    });
}

let addressService = (function () {
    function add(address, callback, error) {
        $.ajax({
            url: "/address/new",
            type: "post",
            data: JSON.stringify(address),
            contentType: "application/json; charset=utf-8", //data에 JSON 작성 시 반드시 contentType 작성
            success: function (result) {
                if (callback) {
                    callback(result);
                }
            },
            error: function (a, b, c) {
                if (error) {
                    error(a, b, c);
                }
            }
        });
    }

    function getList(callback) {
        $.ajax({
            url: "/address/list",
            success: function (addresses) {
                if (callback) {
                    callback(addresses);
                }
            }
        })
    }

    function remove(addressNumber, callback) {
        $.ajax({
            url: "/address/" + addressNumber,
            type: "delete",
            success: function () {
                if (callback) {
                    callback();
                }
            }
        })
    }

    function modify(addressNumber, callback, error) {
        $.ajax({
            url: "/address/modify",
            type: "post",
            data: JSON.stringify(addressNumber),
            contentType: "application/json; charset=utf-8",
            success: function () {
                if (callback) {
                    callback();
                }
            }
        });
    }

    return {add: add, getList: getList, remove: remove, modify: modify}
})();