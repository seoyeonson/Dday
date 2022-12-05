/*
* /productLike */

let productLikeService = (function () {
    // 장바구니 추가
    function add(address, callback, error) {
        // $.ajax({
        //     url: "/productlike/new",
        //     type: "post",
        //     data: JSON.stringify(address),
        //     contentType: "application/json; charset=utf-8", //data에 JSON 작성 시 반드시 contentType 작성
        //     success: function (result) {
        //         if (callback) {
        //             callback(result);
        //         }
        //     },
        //     error: function (a, b, c) {
        //         if (error) {
        //             error(a, b, c);
        //         }
        //     }
        // });
    }

    // 찜하기 리스트
    function getList(callback) {
        $.ajax({
            url: "/productlike/list",
            success: function (productDTO) {
                if (callback) {
                    callback(productDTO);
                }
            }
        })
    }

    // 찜 상품 삭제
    function remove(productNumber, callback) {
        $.ajax({
            url: "/productlike/" + productNumber,
            type: "delete",
            success: function () {
                if (callback) {
                    callback();
                }
            }
        })
    }

    return {add: add, getList: getList, remove: remove}
})();

/*
* 상품 수량 변경 관련 */

// 상품 수량 +1씩 증가
function countUp(){
    var nowCount = $('div.cnt').text();
    var plusCount = (Number(nowCount)) + 1;

    $('div.cnt').text(plusCount);

    // 가격 변경 함수 호출
    priceChange();
}

// 상품 수량 -1씩 감소
function countDown(){
    var nowCount = $('div.cnt').text();
    var minusCount = (Number(nowCount)) - 1;

    $('div.cnt').text(minusCount);

    // 가격 변경 함수 호출
    priceChange();
}

// 상품 수량 초기화
function countReset(){
    var nowCount = $('div.cnt').text();
    var minusReset = (((Number(nowCount))) -((Number(nowCount))- 1));

    $('div.cnt').text(minusReset);

    // 가격 변경 함수 호출
    priceChange();
}

// 상품 가격 변경
function priceChange(){
    var productCount = Number($('div.cnt').text());

    // 총 상품가격 구하기
    var realPrice = productCount * calcproductPrice;
    // toLocaleString()으로 천단위 콤마 찍어서 text에 출력
    $('span.changePrice').text(realPrice.toLocaleString());

}

// +버튼 클릭시, 수량이 2이상이면 -버튼 활성화
$('button.plus').on('click',function(){
    $('button.minus').css({"background":"url(data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMzAiIGhlaWdodD0iMzAiIHZpZXdCb3g9IjAgMCAzMCAzMCIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KICAgIDxwYXRoIGQ9Ik0yMCAxNHYySDEwdi0yeiIgZmlsbD0iIzMzMyIgZmlsbC1ydWxlPSJub256ZXJvIi8+Cjwvc3ZnPgo=)"});
    countUp();
});

// -버튼 클릭시, 수량이 1이면 -버튼 다시 비활성화
$('button.minus').on('click',function(){
    if(Number($('div.cnt').text()) > 1){
        countDown();
        if(Number($('div.cnt').text()) == 1){
            $('button.minus').css({"background":"url(data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMzAiIGhlaWdodD0iMzAiIHZpZXdCb3g9IjAgMCAzMCAzMCIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KICAgIDxwYXRoIGQ9Ik0yMCAxNHYySDEwdi0yeiIgZmlsbD0iI0RERCIgZmlsbC1ydWxlPSJub256ZXJvIi8+Cjwvc3ZnPgo=)"});
        }
    }

});
/* ---------------------------------------- */

/*
* 장바구니 담기를 했거나 취소한 경우 수량 초기화 */

$('button.addCart_btn').on('click', function(){
    $('div.modalContainer').hide();
    addCart();
    countReset();
});

$('button.modalCancelButton').on('click',function(){
    $('div.modalContainer').hide();
    countReset();
});
/* ---------------------------------------- */



function addCart(){
    var productNumber = $("input[name='productNumber']").val();
    var cartCount = $("#cartCount").text();
    console.log(productNumber);
    console.log(cartCount);

    var data = {
        productNumber : productNumber,
        cartCount : cartCount
    };

    $.ajax({
        url : "/cart/addCart",
        type : "post",
        data : data,
        success : function(result){
            alert("장바구니에 상품이 담겼습니다");
            $("#cartCount").text("1");
        },
        error : function(){
            alert("로그인이 필요합니다");
            location.href="/member/login";
        }
    });
}

// $("div.likeGoods").on('click', "button.heart_button", function(){
//     console.log('클릭');
//     checkHeart();
// });

// var blankUrl = 'data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMzIiIGhlaWdodD0iMzIiIHZpZXdCb3g9IjAgMCAzMiAzMiIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KICAgIDxwYXRoIGQ9Ik0yNS44MDcgNy44NjNhNS43NzcgNS43NzcgMCAwIDAtOC4xNzIgMEwxNiA5LjQ5N2wtMS42MzUtMS42MzRhNS43NzkgNS43NzkgMCAxIDAtOC4xNzMgOC4xNzJsMS42MzQgMS42MzQgNy40NjYgNy40NjdhMSAxIDAgMCAwIDEuNDE1IDBzMCAwIDAgMGw3LjQ2Ni03LjQ2N2gwbDEuNjM0LTEuNjM0YTUuNzc3IDUuNzc3IDAgMCAwIDAtOC4xNzJ6IiBzdHJva2U9IiM1RjAwODAiIHN0cm9rZS13aWR0aD0iMS42IiBmaWxsPSJub25lIiBmaWxsLXJ1bGU9ImV2ZW5vZGQiIHN0cm9rZS1saW5lY2FwPSJyb3VuZCIvPgo8L3N2Zz4K';
// var fullUrl = 'data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMzIiIGhlaWdodD0iMzIiIHZpZXdCb3g9IjAgMCAzMiAzMiIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KICAgIDxwYXRoIGQ9Ik0yNS44MDcgNy44NjNhNS43NzcgNS43NzcgMCAwIDAtOC4xNzIgMEwxNiA5LjQ5N2wtMS42MzUtMS42MzRhNS43NzkgNS43NzkgMCAxIDAtOC4xNzMgOC4xNzJsMS42MzQgMS42MzQgNy40NjYgNy40NjdhMSAxIDAgMCAwIDEuNDE1IDBzMCAwIDAgMGw3LjQ2Ni03LjQ2N2gwbDEuNjM0LTEuNjM0YTUuNzc3IDUuNzc3IDAgMCAwIDAtOC4xNzJ6IiBmaWxsPSIjRkY1QTVBIiBzdHJva2U9IiNGRjVBNUEiIHN0cm9rZS13aWR0aD0iMS42IiBmaWxsLXJ1bGU9ImV2ZW5vZGQiIHN0cm9rZS1saW5lY2FwPSJyb3VuZCIvPgo8L3N2Zz4K';
//
// function inWishList(){
//     $('img.blankHeart').attr('src', fullUrl);
// }
//
// function outWishList(){
//     $('img.blankHeart').attr('src', blankUrl);
// }
//
// function checkHeart(){
//     var src = $('img.blankHeart').attr('src');
//     console.log(src);
//     if(src==blankUrl){
//         inWishList();
//     }else{
//         outWishList();
//     }
// }