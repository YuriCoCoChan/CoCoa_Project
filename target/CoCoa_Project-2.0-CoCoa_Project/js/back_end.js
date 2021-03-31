$(function () {
    $("#sideBar").css({
        "height": $(window).height()
    })

    $("body").css({
        "overflow": "auto",
        "height": $(window).height(),
        backgroundColor: "#353b48"
    })

    // 关键的 样式.. 改了就崩了
    $("#work").css({
        "min-height": $(window).height(),
    })
})