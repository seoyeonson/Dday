var blankUrl = 'data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMzIiIGhlaWdodD0iMzIiIHZpZXdCb3g9IjAgMCAzMiAzMiIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KICAgIDxwYXRoIGQ9Ik0yNS44MDcgNy44NjNhNS43NzcgNS43NzcgMCAwIDAtOC4xNzIgMEwxNiA5LjQ5N2wtMS42MzUtMS42MzRhNS43NzkgNS43NzkgMCAxIDAtOC4xNzMgOC4xNzJsMS42MzQgMS42MzQgNy40NjYgNy40NjdhMSAxIDAgMCAwIDEuNDE1IDBzMCAwIDAgMGw3LjQ2Ni03LjQ2N2gwbDEuNjM0LTEuNjM0YTUuNzc3IDUuNzc3IDAgMCAwIDAtOC4xNzJ6IiBzdHJva2U9IiM1RjAwODAiIHN0cm9rZS13aWR0aD0iMS42IiBmaWxsPSJub25lIiBmaWxsLXJ1bGU9ImV2ZW5vZGQiIHN0cm9rZS1saW5lY2FwPSJyb3VuZCIvPgo8L3N2Zz4K';
var fullUrl = 'data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMzIiIGhlaWdodD0iMzIiIHZpZXdCb3g9IjAgMCAzMiAzMiIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KICAgIDxwYXRoIGQ9Ik0yNS44MDcgNy44NjNhNS43NzcgNS43NzcgMCAwIDAtOC4xNzIgMEwxNiA5LjQ5N2wtMS42MzUtMS42MzRhNS43NzkgNS43NzkgMCAxIDAtOC4xNzMgOC4xNzJsMS42MzQgMS42MzQgNy40NjYgNy40NjdhMSAxIDAgMCAwIDEuNDE1IDBzMCAwIDAgMGw3LjQ2Ni03LjQ2N2gwbDEuNjM0LTEuNjM0YTUuNzc3IDUuNzc3IDAgMCAwIDAtOC4xNzJ6IiBmaWxsPSIjRkY1QTVBIiBzdHJva2U9IiNGRjVBNUEiIHN0cm9rZS13aWR0aD0iMS42IiBmaWxsLXJ1bGU9ImV2ZW5vZGQiIHN0cm9rZS1saW5lY2FwPSJyb3VuZCIvPgo8L3N2Zz4K';

function inWishList(){
    $('img.blankHeart').attr('src', fullUrl);
}

function outWishList(){
    $('img.blankHeart').attr('src', blankUrl);
}

function checkHeart(){
    var src = $('img.blankHeart').attr('src');
    console.log(src);
    if(src==blankUrl){
        inWishList();
    }else{
        outWishList();
    }
}

$('button.heart_button').on('click', function(){
    console.log('클릭');
    checkHeart();
});


// 상품 수량 변경 박스

function countUp(){
    var nowCount = $('div.cnt').text();
    var plusCount = (Number(nowCount)) + 1;

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


// 천단위 콤마 없애고 숫자로 변경
var productPrice = Number($('span.changePrice').text().replace(",", ""));

function priceChange(){
    var productCount = Number($('div.cnt').text());

    // 총 상품가격 구하기
    var realPrice = productCount * productPrice;
    // toLocaleString()으로 천단위 콤마 찍어서 text에 출력
    $('span.changePrice').text(realPrice.toLocaleString());

}


// 장바구니 이미지 클릭시 모달창
$('div.modalContainer').hide();
$('button.infoRight2').on('click', function(event){
    event.stopPropagation();
    $("div.modalContainer").fadeIn();
});

$('button.modalOkButton').on('click', function(){
    $('div.modalContainer').hide();
    countReset();
    alert('장바구니에 상품이 추가되었습니다.');
});

$('button.modalCancelButton').on('click',function(){
    $('div.modalContainer').hide();
    countReset();
});