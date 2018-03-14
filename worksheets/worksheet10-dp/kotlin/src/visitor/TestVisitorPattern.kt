package visitor

fun main(args: Array<String>) {
    println("Befor visitor......... \n")

    var parentTag: HtmlTag = HtmlParentElement("<html>","</html>")
    var p1: HtmlTag = HtmlParentElement("<body>", "</body>")
    parentTag.addChildTag(p1)

    var child1: HtmlTag = HtmlElement("<p>", "Testing html tag library", "</p>")

    p1.addChildTag(child1)
    child1 = HtmlElement("<p>", "Paragraph 2", "</p>")
    p1.addChildTag(child1)
    parentTag.generateHtml()

    println("\nAfter visitor....... \n")

    val cssClass: Visitor = CssClassVisitor()
    val style: Visitor = StyleVisitor()

    parentTag = HtmlParentElement("<html>", "</html>")
    parentTag.accept(style)
    parentTag.accept(cssClass)

    p1 = HtmlParentElement("<body>", "</body>")
    p1.accept(style)
    p1.accept(cssClass)
    parentTag.addChildTag(p1)

    child1 = HtmlElement("<p>", "Testing html tag library", "</p>")
    child1.accept(style)
    child1.accept(cssClass)
    p1.addChildTag(child1)

    child1 = HtmlElement("<p>", "Paragraph 2", "</p>")
    child1.accept(style)
    child1.accept(cssClass)
    p1.addChildTag(child1)
    parentTag.generateHtml()
}
