package composite

fun main(args: Array<String>) {

    val parentTag: HtmlTag = HtmlParentElement("<html>")
    parentTag.startTag = "<html>"
    parentTag.endTag = "</html>"

    val p1: HtmlTag = HtmlParentElement("<body>")
    p1.startTag = "<body>"
    p1.endTag = "</body>"
    parentTag.addChildTag(p1)

    var child1: HtmlTag = HtmlElement("<P>")
    child1.startTag = "<P>"
    child1.endTag = "</P>"
    child1.tagBody = "Testing html tag library"
    p1.addChildTag(child1)

    child1 = HtmlElement("<P>")
    child1.startTag = "<P>"
    child1.endTag = "</P>"
    child1.tagBody = "Paragraph 2"

    p1.addChildTag(child1)
    parentTag.generateHtml()
}
