const $radio_circle = $(".radio_circle");
const $radio_label = $(".radio_label")

$radio_label.on("click", function () {
    $(this).children().prop("checked", true);
    checkRadio();
});

$radio_circle.on("click", function () {
    $(this).prev().prop("checked", true);
    checkRadio();
});

function checkRadio() {
    let $input_radio = $("input[name=gender]");
    $.each($input_radio, function () {
        if ($(this).is(":checked")) {
            $(this).next().addClass("input_choice");
        } else {
            $(this).next().removeClass("input_choice");
        }
    });
}

const $agrees = $(".agree");
const $agreeAll = $("#agreeAll");
const $agreecheckboxs = $(".agree_content input[type=checkbox]");
// console.log($checkboxs);

$agreeAll.on("click", function () {
    console.log();
    if ($(this).is(":checked")) {
        $agreecheckboxs.next("span").addClass("fill");
        $agreecheckboxs.prop("checked", true);
    } else {
        $agreecheckboxs.next("span").removeClass("fill");
        $agreecheckboxs.prop("checked", false);
    }
})

$agrees.on("click", function () {
    let check = 0
    if ($(this).is(":checked")) {
        $(this).next("span").addClass("fill");
    } else {
        $(this).next("span").removeClass("fill");
    }

    $.each($agrees, function () {
        if ($(this).is(":checked")) {
            check += 1
        }
    });

    if (check == $agrees.length) {
        $agreeAll.next("span").addClass("fill");
        $agreeAll.prop("checked", true);
    } else {
        $agreeAll.next("span").removeClass("fill");
        $agreeAll.prop("checked", false);
    }
});

const $checks = $(".check");
const $reset = $(".reset");
const $resetbutton = $(".resetbutton");
const $resetlogo = $(".resetlogo")
const $divresetbutton = $(".divresetbutton");
const $checkboxs = $(".filter input[type=checkbox]");
const $check_circle = $(".material-symbols-outlined")
console.log($checks);
console.log($check_circle);

/* 필터 */
$checks.on("click", function () {
    let check = 0
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

    if (check >= 1) {
        $resetbutton.disabled = false;
        $reset.addClass("activate");
        $resetlogo.addClass("activate");
        $resetbutton.addClass("mouseover");
        $divresetbutton.addClass("mouseover");
    } else {
        $resetbutton.disabled = true;
        $reset.removeClass("activate");
        $resetlogo.removeClass("activate");
        $resetbutton.removeClass("mouseover");
        $divresetbutton.removeClass("mouseover");
    }
});


/* 필터 초기화 */
/*$divresetbutton.on("click", function () {
    console.log("clickeddiv");
    $checks.next("span").removeClass("fill");
    $checks.prop("checked", false);
    $reset.removeClass("activate");
    $resetlogo.removeClass("activate");
    $resetbutton.removeClass("mouseover");
    $divresetbutton.removeClass("mouseover");
    $resetbutton.disabled = true;
})


$resetbutton.on("click", function () {
    console.log("clickedbtn");
    $checks.next("span").removeClass("fill");
    $checks.prop("checked", false);
    $reset.removeClass("activate");
    $resetlogo.removeClass("activate");
})*/

/* 가격 필터 */

const $pricelow = $(".pricelow");
const $pricehigh = $(".pricehigh");
var pricefilter = 0;

$pricelow.on("click", function () {
    console.log("pricelow");
    if (pricefilter == 0) {
        $pricelow.addClass("activate");
        pricefilter = 1;
    } else if (pricefilter == 1) {
        $pricelow.removeClass("activate");
        pricefilter = 0;
    } else {
        $pricelow.addClass("activate");
        $pricehigh.removeClass("activate");
        pricefilter = 1;
    }
    console.log(pricefilter);
})
/* 가격 필터2 */

const $pricelow = $("#pricelow1");
const $pricehigh = $("#pricehigh1");
var pricefilter = 0;

$pricelow.on("click", function () {
    if (pricefilter == 0) {
        $pricelow.addClass("activate");
        pricefilter = 1;
    } else if (pricefilter == 1) {
        $pricelow.removeClass("activate");
        pricefilter = 0;
    } else {
        $pricelow.addClass("activate");
        $pricehigh.removeClass("activate");
        pricefilter = 1;
    }
});

$pricehigh.on("click", function () {
    console.log("pricehigh");
    if (pricefilter == 0) {
        $pricehigh.addClass("activate");
        pricefilter = 2;
    } else if (pricefilter == 2) {
        $pricehigh.removeClass("activate");
        pricefilter = 0;
    } else {
        $pricehigh.addClass("activate");
        $pricelow.removeClass("activate");
        pricefilter = 2;
    }
    console.log(pricefilter);
})


/* 장바구니 추가 modal */
/*$(function () {

    $("button.infoRight").click(function () {
        $(".modal").fadeIn();
        $('body').css("overflow", "hidden");
    });

    $(".modal_content").click(function () {
        $(".modal").fadeOut();
        $('body').css("overflow", "visible");
    });

});

$(function () {

    $("button.pickup").click(function () {
        $(".modal").fadeIn();
        $('body').css("overflow", "hidden");
    });

    $(".footerLeft").click(function () {
        $(".modal").fadeOut();
        $('body').css("overflow", "visible");

    });


});*/

