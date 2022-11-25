



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
})
/* $checkAll2.on("click", function () {
    console.log("checkAll");
    if ($(this).is(":checked")) {
        $checkboxs.next("span").addClass("fill");
        $checkboxs.prop("checked", true);
    } else {
        $checkboxs.next("span").removeClass("fill");
        $checkboxs.prop("checked", false);
    }
}) */


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

/* modal */
$(function () {



    $("button.choose_delete").click(function () {
        $(".modal").fadeIn();
        $('body').css("overflow", "hidden");
    });

    $(".modal_content").click(function () {
        $(".modal").fadeOut();
        $('body').css("overflow", "visible");
    });

});