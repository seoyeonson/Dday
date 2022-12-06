// 장바구니 이미지 클릭시 모달창
$('div.modalContainer').hide();

// getList로 새롭게 html에 추가되었기 때문에
// $(처음부터 존재했던 새롭게 추가된 요소의 부모).on('click', 누를 요소, 함수) 로 사용!
// $('div.product_grid').on('click', "button.inputCart", function(event){

$('button.inputCart').on('click', function(event){
    event.preventDefault();


    // 장바구니 버튼이 포함된 li에서 정보 가져오기
    // 상품 번호, 상품 가격, 상품 이름, 상품 세일가
    let productNumber = $(this).find("input.productNumber").val();
    console.log(productNumber);
    let productPrice = $(this).find("input#productPrice").val();
    let productName = $(this).find("input#productName").val();
    let productSalePrice = $(this).find("input#productSalePrice").val();
    console.log(productSalePrice);

    // 상품 추가, 삭제 시 변경되는 상품 전체 가격을 위해 계산할 상품 가격을 수정
    calcproductPrice = productSalePrice.replace(",", "").replace("원", "");

    // 모달안의 정보 변경
    // 상품 번호, 상품 가격 ,상품 이름, 상품 세일가, 계산될 상품 첫 가격
    $("input[name='productNumber']").val(productNumber);
    $(".modalProductName span").text(productName);
    $("span.discountBox").text(productSalePrice);
    $("span.priceBox").text(productPrice);
    $("span.changePrice").text(productSalePrice);

    $('div.modalContainer').fadeIn();

});

$('button.addCart_btn').on('click', function(){
    $('div.modalContainer').hide();
    addCart();
    countReset();
});

$('button.modalCancelButton').on('click',function() {
    $('div.modalContainer').hide();
    countReset();
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



function priceChange(){
    var productCount = Number($('div.cnt').text());
    // 총 상품가격 구하기
    var realPrice = productCount * calcproductPrice;
    // toLocaleString()으로 천단위 콤마 찍어서 text에 출력
    $('span.changePrice').text(realPrice.toLocaleString());

}

function addCart(){
        var productNumber = $("input[name='productNumber']").val();
        var cartCount = $("#cartCount").text();

       // var memberNumber = [[${memberNumber}]];
       //  if(memberNumber==null){
       //      alert("로그인이 필요합니다");
       //      location.href = "/member/login";
       //  }

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
                alert("상품 담기 실패");
            }
        });
    }