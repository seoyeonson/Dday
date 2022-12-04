
// var blankUrl = 'data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMzIiIGhlaWdodD0iMzIiIHZpZXdCb3g9IjAgMCAzMiAzMiIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KICAgIDxwYXRoIGQ9Ik0yNS44MDcgNy44NjNhNS43NzcgNS43NzcgMCAwIDAtOC4xNzIgMEwxNiA5LjQ5N2wtMS42MzUtMS42MzRhNS43NzkgNS43NzkgMCAxIDAtOC4xNzMgOC4xNzJsMS42MzQgMS42MzQgNy40NjYgNy40NjdhMSAxIDAgMCAwIDEuNDE1IDBzMCAwIDAgMGw3LjQ2Ni03LjQ2N2gwbDEuNjM0LTEuNjM0YTUuNzc3IDUuNzc3IDAgMCAwIDAtOC4xNzJ6IiBzdHJva2U9IiM1RjAwODAiIHN0cm9rZS13aWR0aD0iMS42IiBmaWxsPSJub25lIiBmaWxsLXJ1bGU9ImV2ZW5vZGQiIHN0cm9rZS1saW5lY2FwPSJyb3VuZCIvPgo8L3N2Zz4K';
// var blankUrl = './dday/src/main/resources/static/product/images/heart.png';
var blankUrl = "/product/images/heart.png";
var fullUrl = 'data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMzIiIGhlaWdodD0iMzIiIHZpZXdCb3g9IjAgMCAzMiAzMiIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KICAgIDxwYXRoIGQ9Ik0yNS44MDcgNy44NjNhNS43NzcgNS43NzcgMCAwIDAtOC4xNzIgMEwxNiA5LjQ5N2wtMS42MzUtMS42MzRhNS43NzkgNS43NzkgMCAxIDAtOC4xNzMgOC4xNzJsMS42MzQgMS42MzQgNy40NjYgNy40NjdhMSAxIDAgMCAwIDEuNDE1IDBzMCAwIDAgMGw3LjQ2Ni03LjQ2N2gwbDEuNjM0LTEuNjM0YTUuNzc3IDUuNzc3IDAgMCAwIDAtOC4xNzJ6IiBmaWxsPSIjRkY1QTVBIiBzdHJva2U9IiNGRjVBNUEiIHN0cm9rZS13aWR0aD0iMS42IiBmaWxsLXJ1bGU9ImV2ZW5vZGQiIHN0cm9rZS1saW5lY2FwPSJyb3VuZCIvPgo8L3N2Zz4K';

function inWishList(){
    var maxWidth= 100;
    $('img.blankHeart').attr('src', fullUrl);
    $('img.blankHeart').css('width', maxWidth);
}

function outWishList(){
    $('img.blankHeart').attr('src', blankUrl);
    $('img.blankHeart').css('width', 24);
}

function checkHeart(){
    var src = $('img.blankHeart').attr('src');
    if(src==blankUrl){
        inWishList();
    }else{
        outWishList();
    }
}

$('button.heart_button').on('click', function(){
    checkHeart();
});


// 상품 수량 변경 박스

function countUp(){
    var nowCount = $('div.cnt').text();
    var plusCount = (Number(nowCount)) + 1;
    console.log(nowCount);
    console.log(plusCount);

    $('div.cnt').text(plusCount);

    // 가격 변경 함수 호출
    priceChange();
}

function countDown(){
    var nowCount = $('div.cnt').text();
    var minusCount = (Number(nowCount)) - 1;

    $('div.cnt').text(minusCount);

    // 가격 변경 함수 호출
    priceChange();
}

function countReset(){
    var nowCount = $('div.cnt').text();
    var minusReset = (((Number(nowCount))) -((Number(nowCount))- 1));

    $('div.cnt').text(minusReset);

    // 가격 변경 함수 호출
    priceChange();
}

// +버튼 클릭시, 수량이 2이상이면 -버튼 활성화
$('button.plus').on('click',function(e){
    e.preventDefault();
    $('button.minus').css({"background":"url(data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMzAiIGhlaWdodD0iMzAiIHZpZXdCb3g9IjAgMCAzMCAzMCIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KICAgIDxwYXRoIGQ9Ik0yMCAxNHYySDEwdi0yeiIgZmlsbD0iIzMzMyIgZmlsbC1ydWxlPSJub256ZXJvIi8+Cjwvc3ZnPgo=)"});
    countUp();
});

// -버튼 클릭시, 수량이 1이면 -버튼 다시 비활성화
$('button.minus').on('click',function(e){
    e.preventDefault();
    if(Number($('div.cnt').text()) > 1){
        countDown();
        if(Number($('div.cnt').text()) == 1){
            $('button.minus').css({"background":"url(data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMzAiIGhlaWdodD0iMzAiIHZpZXdCb3g9IjAgMCAzMCAzMCIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KICAgIDxwYXRoIGQ9Ik0yMCAxNHYySDEwdi0yeiIgZmlsbD0iI0RERCIgZmlsbC1ydWxlPSJub256ZXJvIi8+Cjwvc3ZnPgo=)"});
        }
    }

});


// 천단위 콤마 없애고 숫자로 변경
var productPrice = Number($('span.changePrice').text().replace(",", ""));

function priceChange(){
    var productCount = Number($('div.cnt').text());

    // 총 상품가격 구하기
    var realPrice = productCount * productPrice;
    // toLocaleString()으로 천단위 콤마 찍어서 text에 출력
    $('span.changePrice').text(realPrice.toLocaleString());

}

// Modal을 가져온다
var modals = document.getElementsByClassName("modalContainer");
// Modal을 띄우는 클래스 이름을 가져온다.
var btns = document.getElementsByClassName("inputCart");
// Modal을 닫는 close 클래스를 가져온다.
var spanes = document.getElementsByClassName("modalCancelButton");

var cnts = document.getElementsByClassName("cnt");

var funcs = [];

// Modal을 띄우고 닫는 클릭 이벤트를 정의한 함수
function Modal(productNumber) {
    return function(){
        // 해당 클래스의 내용을 클릭하면 Modal을 띄운다.
        btns[productNumber].onclick = function(e){
            e.preventDefault();
            modals[productNumber].style.display = "block";
            console.log(productNumber);
        };

        // 닫기 버튼 클릭하면 Modal이 닫힌다.
        spanes[productNumber].onclick = function(e) {
            e.preventDefault();
            modals[productNumber].style.display = "none";
        };

        cnts[productNumber].onclick = function(e){
            e.preventDefault();
            // modals[productNumber]
        }
    };

}
// 원하는 Modal 수만큼 Modal 함수를 호출해서 funcs 함수에 정의한다.
for(var i = 0; i< btns.length; i++){
    funcs[i] = Modal(i);
}
// 원하는 Modal 수만큼 funcs 함수를 호출한다.
for(var j = 0; j< btns.length; j++){
    funcs[j]();
}




// // 장바구니 이미지 클릭시 모달창
// // $('div.modalContainer').hide();
//     $('button.inputCart').on('click', function(e){
//         e.preventDefault();
//         // $("div.modalContainer").fadeIn();
//         console.log(productNumber);
//         $("div.modalContainer").css('display', 'flex');
//     });
//
//     $('button.modalOkButton').on('click', function(){
//         $('div.modalContainer').hide();
//         countReset();
//         alert('장바구니에 상품이 추가되었습니다.');
//     });
//
//     $('button.modalCancelButton').on('click',function(){
//         $('div.modalContainer').hide();
//         countReset();
//     });



// $('div.today_product_content').on('click', function(){
//     $(location).attr('href','/product/todayCategoryDetail');
// });
// $('div.delivery_product_content').on('click', function(){
//     $(location).attr('href','/product/categoryDetail');
// });

$('button.in_cart').on('click', function(){
    alert('장바구니에 상품이 추가되었습니다.');
    // $(location).attr('href','/product/categoryDetail');
});
