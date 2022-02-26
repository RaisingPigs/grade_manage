"use strict";

$(
    function () {
        myShow();
    }
);

function myShow() {
    $(".listimg").hover(function () {
        $(".summary", this).animate({top: "135px"}, 350);
    }, function () {
        $(".summary", this).animate({top: "165px"});
    });
}
