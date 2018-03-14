package composite

abstract class HtmlTag(val tagName: String) {
    lateinit var startTag: String
    lateinit var endTag: String
    lateinit var tagBody: String
    lateinit var children: List<HtmlTag>

    fun addChildTag(htmlTag: HtmlTag) {
        TODO()
    }

    fun removeChildTag(htmlTag: HtmlTag) {
        TODO()
    }

    fun generateHtml() {
        TODO()
    }
}