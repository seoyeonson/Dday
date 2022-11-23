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

$checks.on("click", function () {
    let check = 0
    if ($(this).is(":checked")) {
        $(this).next("span").addClass("fill");
        $reset.addClass("activate");
        $resetlogo.addClass("activate");
        $resetbutton.addClass("mouseover");
        $divresetbutton.addClass("mouseover");
    } else {
        $(this).next("span").removeClass("fill")
        $reset.removeClass("activate");
        $resetlogo.removeClass("activate");
        $resetbutton.removeClass("mouseover");
        $divresetbutton.removeClass("mouseover")
    }

    $.each($checks, function () {
        if ($(this).is(":checked")) {
            check += 1
        }
    });


    /* if(check == $agrees.length){
        $agreeAll.next("span").addClass("fill");
        $agreeAll.prop("checked", true);
    } else {
        $agreeAll.next("span").removeClass("fill");
        $agreeAll.prop("checked", false);
    } */
});



$resetbutton.on("click", function () {
    console.log("clicked");
    $checks.next("span").removeClass("fill");
    $checks.prop("checked", false);
    $reset.removeClass("activate");
    $resetlogo.removeClass("activate");
})