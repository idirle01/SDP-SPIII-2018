package abstractfactory

interface AbstractParserFactory {
  fun getParserInstance(parserType: String): XMLParser
}