package visitor

abstract class HtmlTag(
        startTag: String,
        endTag: String) : Element {

    abstract fun addChildTag(htmlTag: HtmlTag)
    abstract fun removeChildTag(htmlTag: HtmlTag)
    abstract fun getChildren(): List<HtmlTag>
    abstract fun generateHtml()
}
