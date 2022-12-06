// radio input
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
    let $input_radio = $("input[name=receivePlace]");
    $.each($input_radio, function () {
        if ($(this).is(":checked")) {
            $(this).next().addClass("input_choice");
            $("input[name='orderShippingPlace']").val($(this).val());
        } else {
            $(this).next().removeClass("input_choice");
        }
    });
}


/* 약관 동의 선택 */
const $checks = $(".check");
const $checkAll = $("#checkAll");
const $checkboxs = $(".check_content input[type=checkbox]");
const $deletebutton = $(".choose_delete");

$checkAll.on("click", function () {
    console.log("checkAll");
    console.log($checks.length);
    if ($(this).is(":checked")) {
        console.log("checked");
        $checkboxs.next("span").addClass("fill");
        $checkboxs.prop("checked", true);
    } else {
        $checkboxs.next("span").removeClass("fill");
        $checkboxs.prop("checked", false);
    }
});

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
});