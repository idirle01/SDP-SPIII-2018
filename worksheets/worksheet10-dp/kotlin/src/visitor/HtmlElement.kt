package visitor

data class HtmlElement(val startTag: String,
                       val tagBody: String,
                       val endTag: String) : HtmlTag(startTag, endTag) {

    override fun generateHtml() {
        TODO()
    }

    override fun accept(visitor: Visitor) {
        TODO()
    }

    override fun addChildTag(htmlTag: HtmlTag) {
        TODO("not implemented")
    }

    override fun removeChildTag(htmlTag: HtmlTag) {
        TODO("not implemented")
    }

    override fun getChildren(): List<HtmlTag> {
        TODO("not implemented")
    }

}
