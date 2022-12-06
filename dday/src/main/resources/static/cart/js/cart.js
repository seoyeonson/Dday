let cartService = (function () {
    // function plus(productNumber, callback) {
    //     $.ajax({
    //         url: "/cart/plus",
    //         data: JSON.stringify(productNumber),
    //         contentType: "application/json; charset=utf-8", //data에 JSON 작성 시 반드시 contentType 작성
    //         success: function (result) {
    //             if (callback) {
    //                 callback(result);
    //             }
    //         }
    //     });
    // }

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
            url: "/cart/all",
            success: function (products) {
                if (callback) {
                    callback(products);
                }
            }
        })
    }

    function remove(productNumber, callback) {
        $.ajax({
            url: "/cart/" + productNumber,
            type: "delete",
            success: function () {
                if (callback) {
                    callback();
                }
            }
        })
    }

    function modify(cart, callback, error) {
        $.ajax({
            url: "/cart/modify",
            type: "post",
            data: JSON.stringify(cart),
            contentType: "application/json; charset=utf-8",
            success: function () {
                if (callback) {
                    callback();
                }
            },
            error: function(a, b, c){
                console.log(a, b, c);
            }
        });
    }

    return {add: add, getList: getList, remove: remove, modify: modify}
})();

var $checkboxs;
var $checks;
var item_count = 0;
var productNums = new Array();

getList();

function getList(){
    cartService.getList(showList);
}

function showList(result){
    item_count = 0;
    let text = "";
    let productSum = 0;
    // result.cartTotal
    if(result.products.length > 0){

        result.products.forEach(product => {
            let productSalePriceInt = product.productSalePrice;
            let cartCountInt = product.cartCount;
            let productFinalPrice = productSalePriceInt * cartCountInt;
            productSum += productFinalPrice;
            text += '<li class="productlist">';
            text += '<div class="check_content">';
            text += '<label>';
            text += '<input type="checkbox" class="check">';
            text += '<span class="material-symbols-outlined check_img">check_circle</span>';
            text += '</label>';
            text += '</div>';
            text += '<a class="product_defaultimg"><span class="product_img1"></span></a>';
            text += '<div class="product_name_section">';
            text += '<a class="product_link">';
            text += '<p class="product_name">' + product.productName + '</p>';
            text += '</a>';
            text += '</div>';
            text += '<div class="quantity_controller">';
            if(product.cartCount == 1){
                text += '<button type="button" aria-label="수량내리기" disabled class="quantity_minus"></button>';
            } else {
                text += '<button type="button" aria-label="수량내리기" class="quantity_minus" style="background: url(data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMzAiIGhlaWdodD0iMzAiIHZpZXdCb3g9IjAgMCAzMCAzMCIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KICAgIDxwYXRoIGQ9Ik0yMCAxNHYySDEwdi0yeiIgZmlsbD0iIzMzMyIgZmlsbC1ydWxlPSJub256ZXJvIi8+Cjwvc3ZnPgo=)"></button>';
            }
            text += '<div class="quantity"><span>' + product.cartCount +'</span></div>';
            text += '<button type="button" aria-label="수량올리기" class="quantity_plus"></button>';
            text += '<input type="hidden" value="' + product.productNumber +'">';
            text += '</div>';
            text += '<div class="product_price_section">';
            text += '<span aria-label="권장 소비자 가격" data-testid="product-price" class="product_price" id="price_delete">' + productFinalPrice.toLocaleString('ko-KR') + '원</span>';
            text += '<span class="real_price" display="none">';
            text += '</span>';
            text += '</div>';
            text += '<button class="delete_individual" type="button" data-testid="delete"><span class="delete_icon"></span></button>';
            text += '</li>';
            item_count += 1;
        });
    } else {
        text += '<p class="css-l1lu2l eqymnpn0">장바구니에 담긴 상품이 없습니다</p>';
    }
    if(productSum == 0){
        $("#deliveryFee").text(0);
        $("span.point").text(0)
        $("#totalPrice").text(0);
    } else {
        $("#deliveryFee").text(Number(3000).toLocaleString('ko-KR'));
        $("span.point").text(parseInt((productSum * 0.05).toLocaleString('ko-KR')));
        $("#totalPrice").text(productSum.toLocaleString('ko-KR'));
    }
    $("span#productSum").text(productSum.toLocaleString('ko-KR'));
    // $(".totalCnt").text(item_count);
    $("ul#productAll").html(text);

    $(".item_count").text("(" + itemcheck + "/" + item_count + ")");
    $checkboxs = $(".check_content input[type=checkbox]");
    $checks = $(".check");
}

// 선택 함수
const $checkAll = $("#checkAll");
var itemcheck = 0;
const $deletebutton = $(".choose_delete");

$checkAll.on("click", function () {
    console.log("checkAll");
    if ($(this).is(":checked")) {
        $checkboxs.next("span").addClass("fill");
        $checkboxs.prop("checked", true);
        $deletebutton.prop('disabled', false);
        $.each($("ul#productAll").children().children().next().next().next().children("input"), function(){
            if(!productNums.includes($(this).val())){
                productNums.push($(this).val());
            }
        });
    } else {
        $checkboxs.next("span").removeClass("fill");
        $checkboxs.prop("checked", false);
        $deletebutton.prop('disabled', true);
        productNums = new Array();
        // console.log("들어옴");
    }
    console.log(productNums);

    itemcheck = ($('.check:checked').length);
    $(".item_count").text("(" + itemcheck + "/" + item_count + ")");
});

$("ul#productAll").on("click", ".check", function () {
    let check = 0;
    let productTotalPrice = 0;

    let productNumber = $(this).parent().parent().next().next().next().children("input").val();
    // let productPrice = $(this).parent().parent().next().next().next().next().children("#price_delete").text().replace(",", "").re;
    // console.log("productPrice: ", productPrice);

    if(!productNums.includes(productNumber)){
        productNums.push(productNumber);
    } else {
        productNums.splice(productNums.indexOf(productNumber), 1);
    }

    // console.log(productNums);

    if ($(this).is(":checked")) {
        $(this).next("span").addClass("fill");
    } else {
        $(this).next("span").removeClass("fill")
    }

    $.each($checks, function () {
        if ($(this).is(":checked")) {
            check += 1
        }
    });


    if (check == $checks.length) {
        $checkAll.next("span").addClass("fill");
        $checkAll.prop("checked", true);
    } else {
        $checkAll.next("span").removeClass("fill");
        $checkAll.prop("checked", false);
    }

    if (check == 0) {
        $deletebutton.prop('disabled', true);
    } else {
        $deletebutton.prop('disabled', false);
    }

    itemcheck = ($('.check:checked').length);
    $(".item_count").text("(" + itemcheck + "/" + item_count + ")");
});

/* modal */
var product;
// 상품 개별 삭제
$("ul#productAll").on("click", 'button.delete_individual', function () {
    let productNumber = $(this).prev().prev().children("input").val();
    // alert(productNumber);
    $("#confirm2").prop("name", productNumber);
    // let realPriceNode = $(this).prev().children('#price_delete');
    // console.log(realPriceNode);
    // let realPriceText = realPriceNode.text();
    // let minusWon = "";
    // minusWon = realPriceText.replace("원", "")
    // let priceDelete = Number(minusWon.replace(",", ""));
    // console.log(priceDelete);
    // console.log(realPriceText);
    // product = "";
    // console.log("check1", product);
    $("#modal2").fadeIn();
    // // $('body').css("overflow", "hidden");
    // product = $(this).parent("li");
    // console.log("check2", product);
});

// 개별 삭제 취소
$("#cancel2").on("click",function () {
    $("#modal2").fadeOut();
    $('body').css("overflow", "visible");
    // realPriceNode ="";
    // realPriceText = 0;
    // minusWon = 0;
    // priceDelete = "";
    // product = 0;
});

// 개별 삭제 확인
$("#confirm2").on("click", function () {
    let productNumber = $(this).prop("name");
    // alert(productNumber);
    cartService.remove(productNumber, getList);
    // itemcheck = ($('.check:checked').length);
    itemcheck = 0;
    $(".item_count").text("(" + itemcheck + "/" + item_count + ")");
    $("#modal2").fadeOut();
    // productSum -= priceDelete;
    // console.log(priceDelete);
    // productSumString = productSum.toLocaleString();
    // $('#productSum').text(productSumString);
    // totalPriceFunction();
    // priceDelete = 0;
});


// 선택 삭제
$("button.choose_delete").on("click", function () {
    // let selected_product = $($(".check:checked").closest("li"));
    // let selectedPriceNode = selected_product.children('.product_price_section').children('#price_delete');
    // let selectedPriceText = selectedPriceNode.text();
    // let removeComma = selectedPriceText.replaceAll(",", "");
    // let selectedPriceArr = removeComma.split('원');
    // let sumArr = 0;
    // selectedPriceArr.forEach((item) => {
    //     sumArr += Number(item);
    // })

    // console.log(sumArr);
    $("#modal1").fadeIn();
    // $('body').css("overflow", "hidden");

    $(".item_count").text("(" + itemcheck + "/" + item_count + ")");
    // totalPriceFunction();
});

// 선택 삭제 취소
$("#cancel1").on("click", function () {
    $("#modal1").fadeOut();
    $('body').css("overflow", "visible");
    // selected_product = "";
    // selectedPriceNode = "";
    // selectedPriceText = "";
    // removeComma = 0;
    // selectedPriceArr = '';
    // sumArr = 0;
});

// 선택 삭제 확인
$("#confirm1").on("click", function () {
    productNums.forEach(productNum => {
        cartService.remove(productNum, getList);
    });

    // selected_product = $($(".check:checked").closest("li"));
    // selected_product.remove();
    $("#modal1").fadeOut();
    // $('body').css("overflow", "visible");
    item_count = $(".productlist").length;
    itemcheck = 0;
    $(".item_count").text("(" + itemcheck + "/" + item_count + ")");
    // console.log(sumArr);
    // productSum -= sumArr;
    // console.log(productSum);
    // productSumString = productSum.toLocaleString();
    // $('#productSum').text(productSumString);
    // totalPriceFunction();
    // $deletebutton.prop('disabled', true);
    // sumArr = 0;
})

// +버튼 클릭시, 수량이 2이상이면 -버튼 활성화
$('ul#productAll').on('click', '.quantity_plus' , function quantityPlusFunction() {
    let productNumber = $(this).next().val();
    let cartCount = $(this).prev().text();
    cartService.modify({
        productNumber:productNumber,
        cartCount: cartCount,
        calcType: 'plus'
    }, getList)
});

// -버튼 클릭시, 수량이 1이면 -버튼 다시 비활성화
$('ul#productAll').on('click', '.quantity_minus', function quantityMinusFunction() {
    let productNumber = $(this).next().next().next().val();
    let cartCount = $(this).next().text();

    cartService.modify({
        productNumber:productNumber,
        cartCount: cartCount,
        calcType: 'minus'
    }, getList)
});

// 금액 합계 객체 선언
// var productSum = 0;
// var productSumString = "";
// var totalPrice = 0;
// var totalPriceString = "";
// var point = 0;;
// var pointString = "";
//
// // 전체 상품 합계 상품 금액 옆에 담기
// function productSumFunction(originalPrice) {
//     var temp1 = "";
//     var temp2 = 0;
//     temp1 = $(this).text().replace("원", "");
//     temp2 = Number(temp1.replace(",", ""));
//     productSum += temp2;
//     productSumString = productSum.toLocaleString();
//     $('#productSum').text(productSumString);
//     console.log(productSumString);
// }
// // 상품금액 + 배송비 = 결제예정금액 담기 (적립금 계산)
// function totalPriceFunction() {
//     var temp1 = "";
//     var temp2 = 0;
//     temp1 = $('#deliveryFee').text().replace("+", "");
//     temp2 = Number(temp1.replace(",", ""));
//     totalPrice = temp2 + productSum;
//     totalPriceString = totalPrice.toLocaleString();
//     $('#totalPrice').text(totalPriceString);
//     // 포인트 적립
//     point = Math.floor(totalPrice * 0.05);
//     pointString = point.toLocaleString();
//     $('.point').text(pointString);
// }

// 페이지 실행 때 함수들 실행
// $(document).ready(function () {
//     totalPriceFunction()
// });

$(".order_button").on("click", function(){
    if($("span#productSum").text() != 0){
        location.href="/order/order";
    } else {
        alert("상품을 추가해주세요.");
    }
});