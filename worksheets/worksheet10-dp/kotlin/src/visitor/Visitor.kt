package visitor

interface Visitor {
    fun visit(element: HtmlElement)
    fun visit(parentElement: HtmlParentElement)
}
