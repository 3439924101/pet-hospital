$("#menu ul li").on("click", function () {
    var index = $(this).index();
    $(this).addClass("active").siblings().removeClass("active");
    $("#contain ul li").removeClass("active").eq(index).addClass("active");
})
