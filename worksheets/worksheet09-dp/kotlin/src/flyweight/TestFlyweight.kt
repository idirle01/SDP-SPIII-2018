package flyweight

fun main(args: Array<String>) {
    var code: Code = Code("C Code...")
    var platform: Platform = PlatformFactory.getPlatformInstance("C")
    val LINE = "-".repeat(20)

    platform.execute(code)
    println(LINE)

    code = Code("C Code2...")
    platform = PlatformFactory.getPlatformInstance("C")
    platform.execute(code)
    println(LINE)

    code = Code("JAVA Code...")
    platform = PlatformFactory.getPlatformInstance("JAVA")
    platform.execute(code)
    println(LINE)

    code = Code("JAVA Code2...")
    platform = PlatformFactory.getPlatformInstance("JAVA")
    platform.execute(code)
    println(LINE)

    code = Code("RUBY Code...")
    platform = PlatformFactory.getPlatformInstance("RUBY")
    platform.execute(code)
    println(LINE)

    code = Code("RUBY Code2...")
    platform = PlatformFactory.getPlatformInstance("RUBY")
    println(LINE)
}
