$(function () {
    var previousButton = $("#previousButton");
    var prevFont = "上一页[Previous]";
    var first = $("#first");
    var center = $("#center");
    var last = $("#last");
    var nextButton = $("#nextButton");
    var nextFont = "下一页[Next]";
    var uri = "user_system?pageIndex=";
    // 总页数 = 1
    if (pageCount == 1) {
        console.log('总页数 = 1')
        disabledPreButton(previousButton, prevFont);
        disabledPreButton(nextButton, nextFont);
        first.remove();
        last.remove();
        center.children().remove();
        center.append(appendSpanPageLink(1));
        return;
    }

    // 当前页数 等于 总页数时  下一页. 失效
    if (pageIndex == pageCount) {
        console.log('当前页数 等于 总页数时  下一页. 失效')
        if (pageCount == 2 && pageIndex == 2) {
            console.log('2')
            disabledPreButton(nextButton, nextFont);
            center.children().remove();
            center.append(appendSpanPageLink(pageIndex));
            center.addClass('active');
            last.remove();
            return;
        } else {
            console.log('1')
            first.children().remove();
            first.append(appendLinkTag(uri, pageIndex - 2))
            center.children().remove();
            center.append(appendLinkTag(uri, pageIndex - 1))
            center.removeClass('active')
            last.children().remove();
            last.append(appendSpanPageLink(pageIndex));
            last.addClass('active')
            disabledPreButton(nextButton, nextFont)
            return;
        }

    }

    // 当处于第一页时且对总页数大于或小于三做出判断
    if (pageIndex == 1) {
        console.log('当处于第一页时且对总页数大于或小于三做出判断')
        //总页数≥3
        if (pageCount >= 3) {
            console.log('总页数≥3')
            disabledPreButton(previousButton, prevFont);
            first.children().remove()
            first.append(appendSpanPageLink(pageIndex));
            first.addClass('active');
            center.children().remove()
            center.removeClass('active');
            center.append(appendLinkTag(uri, (pageIndex + 1)));
            last.children().remove()
            last.append(appendLinkTag(uri, (pageIndex + 2)))
            return;
        }
        //总页数 ＜ 3
        if (pageCount < 3) {
            console.log('总页数 ＜ 3')
            disabledPreButton(previousButton, prevFont);
            first.children().remove();
            first.addClass('active');
            first.append(appendLinkTag(uri, 1))
            center.removeClass();
            center.children().remove();
            center.append(appendLinkTag(uri, 1 + 1))
            last.remove();
        }
    }

    /**
     * 禁用 上一页 | 下一页 按钮
     * @param name 标签名 ;
     * @param msg 值 ;
     */
    function disabledPreButton(name, msg) {
        name.addClass('disabled');
        name.children().remove();
        name.append(appendSpanPageLink(msg))
    }

    /**
     * 返回一个 含有 "page-link" 的 <span> 标签
     * @param msg 包含的文字 ;
     * @returns {string}
     */
    function appendSpanPageLink(msg) {
        return "<span class='page-link'>" + msg + "</span>"
    }

    /**
     * 返回 <a> 标签
     * @param uri
     * @param value
     * @returns {string}
     */
    function appendLinkTag(uri, value) {
        return "<a class=\"page-link\" href='${pageContext.request.contextPath}" + value + "'>" + value + "</a>"
    }
});
