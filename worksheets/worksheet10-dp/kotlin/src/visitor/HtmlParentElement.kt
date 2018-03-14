package visitor

data class HtmlParentElement(val startTag: String,
                             val endTag: String) : HtmlTag(startTag, endTag) {
    private var childrenTag: List<HtmlTag> = TODO()

    override fun addChildTag(htmlTag: HtmlTag) {
        TODO()
    }

    override fun removeChildTag(htmlTag: HtmlTag) {
        TODO()
    }

    override fun getChildren() = childrenTag

    override fun generateHtml() {
        TODO()
    }

    override fun accept(visitor: Visitor) {
        TODO()
    }
}
