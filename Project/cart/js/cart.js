



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
    product = "";
    console.log("check1", product);
    $("#modal2").fadeIn();
    $('body').css("overflow", "hidden");
    product = $(this).parent("li");
    console.log("check2", product);
});

$("#confirm2").on("click", function () {
    product.remove();
    console.log("check3", product);
    item_count = $(".productlist").length;
    itemcheck = ($('.check:checked').length);
    $(".item_count").text("(" + itemcheck + "/" + item_count + ")");
    $("#modal2").fadeOut();
});

$("#cancel2").click(function () {
    $("#modal2").fadeOut();
    $('body').css("overflow", "visible");
});

$("button.choose_delete").click(function () {
    let selected_product = $($(".check:checked").closest("li"));
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
    })
    $("#cancel1").click(function () {
        $("#modal1").fadeOut();
        $('body').css("overflow", "visible");
        selected_product = 0;
    });

    $(".item_count").text("(" + itemcheck + "/" + item_count + ")");
});

/* $(".cancel").click(function () {
    $(".modal").fadeOut();
    $('body').css("overflow", "visible");
});
$(".item_count").text("(" + itemcheck + "/" + item_count + ")"); */

/* 주소 api */
const $addressbutton = $(".addressbutton");
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
});



var blankUrl = 'data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMzIiIGhlaWdodD0iMzIiIHZpZXdCb3g9IjAgMCAzMiAzMiIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KICAgIDxwYXRoIGQ9Ik0yNS44MDcgNy44NjNhNS43NzcgNS43NzcgMCAwIDAtOC4xNzIgMEwxNiA5LjQ5N2wtMS42MzUtMS42MzRhNS43NzkgNS43NzkgMCAxIDAtOC4xNzMgOC4xNzJsMS42MzQgMS42MzQgNy40NjYgNy40NjdhMSAxIDAgMCAwIDEuNDE1IDBzMCAwIDAgMGw3LjQ2Ni03LjQ2N2gwbDEuNjM0LTEuNjM0YTUuNzc3IDUuNzc3IDAgMCAwIDAtOC4xNzJ6IiBzdHJva2U9IiM1RjAwODAiIHN0cm9rZS13aWR0aD0iMS42IiBmaWxsPSJub25lIiBmaWxsLXJ1bGU9ImV2ZW5vZGQiIHN0cm9rZS1saW5lY2FwPSJyb3VuZCIvPgo8L3N2Zz4K';
var fullUrl = 'data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMzIiIGhlaWdodD0iMzIiIHZpZXdCb3g9IjAgMCAzMiAzMiIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KICAgIDxwYXRoIGQ9Ik0yNS44MDcgNy44NjNhNS43NzcgNS43NzcgMCAwIDAtOC4xNzIgMEwxNiA5LjQ5N2wtMS42MzUtMS42MzRhNS43NzkgNS43NzkgMCAxIDAtOC4xNzMgOC4xNzJsMS42MzQgMS42MzQgNy40NjYgNy40NjdhMSAxIDAgMCAwIDEuNDE1IDBzMCAwIDAgMGw3LjQ2Ni03LjQ2N2gwbDEuNjM0LTEuNjM0YTUuNzc3IDUuNzc3IDAgMCAwIDAtOC4xNzJ6IiBmaWxsPSIjRkY1QTVBIiBzdHJva2U9IiNGRjVBNUEiIHN0cm9rZS13aWR0aD0iMS42IiBmaWxsLXJ1bGU9ImV2ZW5vZGQiIHN0cm9rZS1saW5lY2FwPSJyb3VuZCIvPgo8L3N2Zz4K';

function inWishList() {
    $('img.blankHeart').attr('src', fullUrl);
}

function outWishList() {
    $('img.blankHeart').attr('src', blankUrl);
}

function checkHeart() {
    var src = $('img.blankHeart').attr('src');
    console.log(src);
    if (src == blankUrl) {
        inWishList();
    } else {
        outWishList();
    }
}

$('button.heart_button').on('click', function () {
    console.log('클릭');
    checkHeart();
});


// 상품 수량 변경 박스

function countUp() {
    var nowCount = $('div.cnt').text();
    var plusCount = (Number(nowCount)) + 1;

    $('div.cnt').text(plusCount);

    // 가격 변경 함수 호출
    priceChange();
}
function countUp() {
    var nowCount = $(this).closest('.quantity').text();
    var plusCount = (Number(nowCount)) + 1;

    $('.quantity').text(plusCount);

    // 가격 변경 함수 호출
    priceChange();
}

function countDown() {
    var nowCount = $('div.cnt').text();
    var minusCount = (Number(nowCount)) - 1;

    $('div.cnt').text(minusCount);

    // 가격 변경 함수 호출
    priceChange();
}

function countReset() {
    var nowCount = $('div.cnt').text();
    var minusReset = (((Number(nowCount))) - ((Number(nowCount)) - 1));

    $('div.cnt').text(minusReset);

    // 가격 변경 함수 호출
    priceChange();
}

// +버튼 클릭시, 수량이 2이상이면 -버튼 활성화
$('button.plus').on('click', function () {
    $('button.minus').css({ "background": "url(data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMzAiIGhlaWdodD0iMzAiIHZpZXdCb3g9IjAgMCAzMCAzMCIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KICAgIDxwYXRoIGQ9Ik0yMCAxNHYySDEwdi0yeiIgZmlsbD0iIzMzMyIgZmlsbC1ydWxlPSJub256ZXJvIi8+Cjwvc3ZnPgo=)" });
    var nowCount = $(this).closest('.quantity').text();
    var plusCount = (Number(nowCount)) + 1;

    $(this).closest('.quantity').text(plusCount);

    // 가격 변경 함수 호출
    priceChange();
});

$('.quantity_plus').on('click', function () {
    console.log($(this).prev().text());
    $(this).prev().prev(".quantity_minus").css({ "background": "url(data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMzAiIGhlaWdodD0iMzAiIHZpZXdCb3g9IjAgMCAzMCAzMCIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KICAgIDxwYXRoIGQ9Ik0yMCAxNHYySDEwdi0yeiIgZmlsbD0iIzMzMyIgZmlsbC1ydWxlPSJub256ZXJvIi8+Cjwvc3ZnPgo=)" });
    $(this).prev().prev(".quantity_minus").prop('disabled', false);
    var nowCount = $(this).prev().text();
    var plusCount = (Number(nowCount)) + 1;

    $(this).prev().text(plusCount);

    // 가격 변경 함수 호출
    var productCount = plusCount;
    console.log($(this).parent().next().child('span').text());
    
    var productPrice = Number($('span.changePrice').text().replace(",", ""));
    // 총 상품가격 구하기
    var realPrice = productCount * productPrice;
    // toLocaleString()으로 천단위 콤마 찍어서 text에 출력
    $('span.changePrice').text(realPrice.toLocaleString());
});

// -버튼 클릭시, 수량이 1이면 -버튼 다시 비활성화
$('button.minus').on('click', function () {
    if (Number($('div.cnt').text()) > 1) {
        countDown();
        if (Number($('div.cnt').text()) == 1) {
            $('button.minus').css({ "background": "url(data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMzAiIGhlaWdodD0iMzAiIHZpZXdCb3g9IjAgMCAzMCAzMCIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KICAgIDxwYXRoIGQ9Ik0yMCAxNHYySDEwdi0yeiIgZmlsbD0iI0RERCIgZmlsbC1ydWxlPSJub256ZXJvIi8+Cjwvc3ZnPgo=)" });
        }
    }

});

$('.quantity_minus').on('click', function () {
    console.log($(this).next().text());
    if (Number($(this).next().text()) > 1) {
        console.log($(this).next().text());
        var nowCount = $(this).next().text();

        var minusCount = (Number(nowCount)) - 1;

        $(this).next().text(minusCount);

        // 가격 변경 함수 호출
        var productCount = Number($('div.cnt').text());

        // 총 상품가격 구하기
        var realPrice = productCount * productPrice;
        // toLocaleString()으로 천단위 콤마 찍어서 text에 출력
        $('span.changePrice').text(realPrice.toLocaleString());
        if (Number($(this).next().text()) == 1) {
            $(this).css({ "background": "url(data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMzAiIGhlaWdodD0iMzAiIHZpZXdCb3g9IjAgMCAzMCAzMCIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KICAgIDxwYXRoIGQ9Ik0yMCAxNHYySDEwdi0yeiIgZmlsbD0iI0RERCIgZmlsbC1ydWxlPSJub256ZXJvIi8+Cjwvc3ZnPgo=)" });
            $(this).prop('disabled', true);
        }
    }

});


// 천단위 콤마 없애고 숫자로 변경
var productPrice = Number($('span.changePrice').text().replace(",", ""));

function priceChange() {
    var productCount = Number($('div.cnt').text());

    // 총 상품가격 구하기
    var realPrice = productCount * productPrice;
    // toLocaleString()으로 천단위 콤마 찍어서 text에 출력
    $('span.changePrice').text(realPrice.toLocaleString());

}


// 장바구니 이미지 클릭시 모달창
$('div.modalContainer').hide();
$('button.inputCartButton').on('click', function (event) {
    event.stopPropagation();
    $("div.modalContainer").fadeIn();
});

$('button.modalOkButton').on('click', function () {
    $('div.modalContainer').hide();
    countReset();
    alert('장바구니에 상품이 추가되었습니다.');
});

$('button.modalCancelButton').on('click', function () {
    $('div.modalContainer').hide();
    countReset();
});
