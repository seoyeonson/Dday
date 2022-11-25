



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
$("button.delete_individual").on("click", function(){
    product = "";
    console.log("check1", product);
    $(".modal").fadeIn();
    $('body').css("overflow", "hidden");
    product = $(this).parent("li");
    console.log("check2", product);
});

$(".confirm").on("click", function () {
    product.remove();
    console.log("check3", product);
    item_count = $(".productlist").length;
    itemcheck = ($('.check:checked').length);
    $(".item_count").text("(" + itemcheck + "/" + item_count + ")");
    $(".modal").fadeOut();
});

$(".cancel").click(function () {
    $(".modal").fadeOut();
    $('body').css("overflow", "visible");
});

$("button.choose_delete").click(function () {
    let selected_product = $($(".check:checked").closest("li"));
    $(".modal").fadeIn();
    $('body').css("overflow", "hidden");
    $(".confirm").click(function () {
        selected_product = $($(".check:checked").closest("li"));
        selected_product.remove();
        $(".modal").fadeOut();
        $('body').css("overflow", "visible");
        item_count = $(".productlist").length;
        itemcheck = ($('.check:checked').length);
        $(".item_count").text("(" + itemcheck + "/" + item_count + ")");
    })
    $(".cancel").click(function () {
        $(".modal").fadeOut();
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