
// 선택 함수
const $checks = $(".check");
const $checkAll = $("#checkAll");
const $checkboxs = $(".check_content input[type=checkbox]");
var itemcheck = 0;
const $deletebutton = $(".choose_delete");
var item_count = $(".productlist").length;


$(function () {
    $(".item_count").text("(" + itemcheck + "/" + item_count + ")");

    $checkAll.on("click", function () {
        console.log("checkAll");
        if ($(this).is(":checked")) {
            console.log("checked");
            $checkboxs.next("span").addClass("fill");
            $checkboxs.prop("checked", true);
            $deletebutton.prop('disabled', false);
        } else {
            $checkboxs.next("span").removeClass("fill");
            $checkboxs.prop("checked", false);
            $deletebutton.prop('disabled', true);
        }
        itemcheck = ($('.check:checked').length);
        $(".item_count").text("(" + itemcheck + "/" + item_count + ")");
    });


    $checks.on("click", function () {
        let check = 0;

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
});




/* modal */
var product;
$("button.delete_individual").on("click", function () {
    let realPriceNode = $(this).prev().children('#price_delete');
    let realPriceText = realPriceNode.text();
    let minusWon = "";
    minusWon = realPriceText.replace("원", "")
    let priceDelete = Number(minusWon.replace(",", ""));
    console.log(realPriceText);
    product = "";
    console.log("check1", product);
    $("#modal2").fadeIn();
    // $('body').css("overflow", "hidden");
    product = $(this).parent("li");
    console.log("check2", product);
    $("#confirm2").on("click", function () {
        product.remove();
        console.log("check3", product);
        item_count = $(".productlist").length;
        itemcheck = ($('.check:checked').length);
        $(".item_count").text("(" + itemcheck + "/" + item_count + ")");
        $("#modal2").fadeOut();
        productSum -= priceDelete;
        console.log(productSum);
        productSumString = productSum.toLocaleString();
        $('#productSum').text(productSumString);
        totalPriceFunction();
        priceDelete = 0;
    });

    $("#cancel2").click(function () {
        $("#modal2").fadeOut();
        $('body').css("overflow", "visible");
        realPriceNode ="";
        realPriceText = 0;
        minusWon = 0;
        priceDelete = "";
        product = 0;
    });
});



$("button.choose_delete").click(function () {
    let selected_product = $($(".check:checked").closest("li"));
    let selectedPriceNode = selected_product.children('.product_price_section').children('#price_delete');
    let selectedPriceText = selectedPriceNode.text();
    let removeComma = selectedPriceText.replaceAll(",", "");
    let selectedPriceArr = removeComma.split('원');
    let sumArr = 0;
    selectedPriceArr.forEach((item) => {
        sumArr += Number(item);
    })

    console.log(sumArr);
    $("#modal1").fadeIn();
    $('body').css("overflow", "hidden");
    $("#confirm1").click(function () {
        selected_product = $($(".check:checked").closest("li"));
        selected_product.remove();
        $("#modal1").fadeOut();
        $('body').css("overflow", "visible");
        item_count = $(".productlist").length;
        itemcheck = ($('.check:checked').length);
        $(".item_count").text("(" + itemcheck + "/" + item_count + ")");
        console.log(sumArr);
        productSum -= sumArr;
        console.log(productSum);
        productSumString = productSum.toLocaleString();
        $('#productSum').text(productSumString);
        totalPriceFunction();
        $deletebutton.prop('disabled', true);
        sumArr = 0;

    })
    $("#cancel1").click(function () {
        $("#modal1").fadeOut();
        $('body').css("overflow", "visible");
        selected_product = "";
        selectedPriceNode = "";
        selectedPriceText = "";
        removeComma = 0;
        selectedPriceArr = '';
        sumArr = 0;
    });

    $(".item_count").text("(" + itemcheck + "/" + item_count + ")");
    totalPriceFunction();
});

/* 주소 api */
/* const $addressbutton = $(".addressbutton");
const $addressdefault = $(".address_default");
const $address_p = $(".address_p");
const $address = $(".address_span");
const $changeaddress = $(".changeaddress");
const $searchaddress = $(".searchaddress");
const $order_button = $(".order_button");
const $address_false = $(".address_false");
const $address_true = $(".address_true");

$addressbutton.on("click", function () {
    console.log("addressbutton");
    new daum.Postcode({
        oncomplete: function (data) { //선택시 입력값 세팅
            $address.text(data.address); // 주소 넣기
            $addressdefault.css('display', 'none');
            $address_p.css('display', 'block');
            $changeaddress.css('display', 'inline-block');
            $searchaddress.css('display', 'none');
            $order_button.prop('disabled', false);
            $address_false.css('display', 'none');
            $address_true.css('display', 'inline-block');
        }
    }).open();
}); */

// +버튼 클릭시, 수량이 2이상이면 -버튼 활성화
$('.quantity_plus').on('click', function quantityPlusFunction() {
    $(this).prev().prev(".quantity_minus").css({ "background": "url(data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMzAiIGhlaWdodD0iMzAiIHZpZXdCb3g9IjAgMCAzMCAzMCIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KICAgIDxwYXRoIGQ9Ik0yMCAxNHYySDEwdi0yeiIgZmlsbD0iIzMzMyIgZmlsbC1ydWxlPSJub256ZXJvIi8+Cjwvc3ZnPgo=)" });
    $(this).prev().prev(".quantity_minus").prop('disabled', false);
    var nowCount = $(this).prev().text();
    var plusCount = (Number(nowCount)) + 1;

    $(this).prev().text(plusCount);

    // 가격 변경 함수 호출
    const productPriceNode = $(this).parent().next().find('.product_price');
    const productPriceText = productPriceNode.text();
    var productCount = plusCount;
    var minusWon = "";
    minusWon = productPriceText.replace("원", "")
    const originalPrice = Number(minusWon.replace(",", ""));

    // 총 상품가격 구하기
    var realPrice = productCount * originalPrice;
    console.log(realPrice);
    // toLocaleString()으로 천단위 콤마 찍어서 text에 출력
    const realPriceNode = $(this).parent().next().find(".real_price");
    if (productCount > 1) {
        productPriceNode.css('display', 'none');
        realPriceNode.css('display', 'inline-block');
        realPriceNode.attr('id', 'price_delete');
        productPriceNode.removeAttr('id', 'price_delete');
        realPriceNode.text(realPrice.toLocaleString() + "원");
    } else {
        productPriceNode.css('display', 'inline-block');
        productPriceNode.attr('id', 'price_delete');
        realPriceNode.removeAttr('id', 'price_delete');
        realPriceNode.css('display', 'none');
    }
    productSum += originalPrice;
    productSumString = productSum.toLocaleString();
    $('#productSum').text(productSumString);
    totalPriceFunction();
});

// -버튼 클릭시, 수량이 1이면 -버튼 다시 비활성화
$('.quantity_minus').on('click', function quantityMinusFunction() {
    var nowCountNode = $(this).next()
    var nowCount = nowCountNode.text();

    if (Number(nowCount) > 1) {
        var minusCount = (Number(nowCount)) - 1;

        nowCountNode.text(minusCount);

        // 가격 변경 함수 호출
        const productPriceNode = $(this).parent().next().find('.product_price');
        const productPriceText = productPriceNode.text();
        var productCount = minusCount;
        var minusWon = "";
        minusWon = productPriceText.replace("원", "")
        const originalPrice = Number(minusWon.replace(",", ""));

        // 총 상품가격 구하기
        var realPrice = productCount * originalPrice;
        // toLocaleString()으로 천단위 콤마 찍어서 text에 출력
        const realPriceNode = $(this).parent().next().find(".real_price");
        if (productCount > 1) {
            productPriceNode.css('display', 'none');
            realPriceNode.css('display', 'inline-block');
            realPriceNode.attr('id', 'price_delete');
            productPriceNode.removeAttr('id', 'price_delete');
            realPriceNode.text(realPrice.toLocaleString() + "원");
        } else {
            productPriceNode.css('display', 'inline-block');
            realPriceNode.css('display', 'none');
            productPriceNode.attr('id', 'price_delete');
            realPriceNode.removeAttr('id', 'price_delete');
        }
        $('span.changePrice').text(realPrice.toLocaleString());
        if (Number($(this).next().text()) == 1) {
            $(this).css({ "background": "url(data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMzAiIGhlaWdodD0iMzAiIHZpZXdCb3g9IjAgMCAzMCAzMCIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KICAgIDxwYXRoIGQ9Ik0yMCAxNHYySDEwdi0yeiIgZmlsbD0iI0RERCIgZmlsbC1ydWxlPSJub256ZXJvIi8+Cjwvc3ZnPgo=)" });
            $(this).prop('disabled', true);
        }
        console.log(nowCount);
        productSum -= originalPrice;
        productSumString = productSum.toLocaleString();
        $('#productSum').text(productSumString);
        totalPriceFunction();
    }
});

// 금액 합계 객체 선언
var productSum = 0;
var productSumString = "";
var totalPrice = 0;
var totalPriceString = "";
var point = 0;;
var pointString = "";

// 전체 상품 합계 상품 금액 옆에 담기
function productSumFunction(originalPrice) {
    var temp1 = "";
    var temp2 = 0;
    temp1 = $(this).text().replace("원", "");
    temp2 = Number(temp1.replace(",", ""));
    productSum += temp2;
    productSumString = productSum.toLocaleString();
    $('#productSum').text(productSumString);
    console.log(productSumString);
}
// 상품금액 총합 담기
$('.product_price').each(function (i, e) {
    var temp1 = "";
    var temp2 = 0;
    temp1 = $(this).text().replace("원", "");
    temp2 = Number(temp1.replace(",", ""));
    productSum += temp2;
    productSumString = productSum.toLocaleString();
    $('#productSum').text(productSumString);

});
// 상품금액 + 배송비 = 결제예정금액 담기 (적립금 계산)
function totalPriceFunction() {
    var temp1 = "";
    var temp2 = 0;
    temp1 = $('#deliveryFee').text().replace("+", "");
    temp2 = Number(temp1.replace(",", ""));
    totalPrice = temp2 + productSum;
    totalPriceString = totalPrice.toLocaleString();
    $('#totalPrice').text(totalPriceString);
    // 포인트 적립
    point = Math.floor(totalPrice * 0.05);
    pointString = point.toLocaleString();
    $('.point').text(pointString);
}

// 페이지 실행 때 함수들 실행
$(document).ready(function () {
    totalPriceFunction()
});
