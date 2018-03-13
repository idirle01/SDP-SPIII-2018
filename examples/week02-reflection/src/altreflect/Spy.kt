package altreflect

import java.lang.reflect.Field
import java.lang.reflect.Method
import java.lang.reflect.Modifier

class Spy private constructor(var thisClass: Class<*>) {
    var className: String
    var atBeginningOfLine: Boolean = true
    var level = 0
    var aaaaa: String

    internal var packageInt: Int = 0

    init {
        aaaaa = "Not used, really."
        className = thisClass.name
    }

    @Throws(ClassNotFoundException::class)
    private constructor(className: String) : this(Class.forName(className)) {
    }

    fun printAll(args: Array<String>) {
        println("----------------------------")
        if (args.size == 0) {
            printClass()
        } else {
            assert(args.size > 0)
            for (str in args) {
                try {
                    val s = Spy.getSpy(str)
                    s.printClass()
                } catch (e: ClassNotFoundException) {
                    level = 0
                    write("\nClass not found: " + str)
                }

            }
        }
    }

    fun write(s: String) {
        if (atBeginningOfLine) {
            for (i in 0 until level % 10) {
                print("   ")
            }
            atBeginningOfLine = false
        }
        print(s)
    }

    fun writeln(s: String) {
        write(s)
        println()
        atBeginningOfLine = true
    }

    fun indent() {
        level++
    }

    fun exdent() {
        level--
    }

    fun printClass() {
        printClassHeader()
        printFields()
        printMethods()
        printClassCloser()
    }

    @Throws(SecurityException::class)
    private fun printMethods() {
        val methods = thisClass.methods
        writeln("// Methods:")
        indent()
        for (m in methods) {
            if (thisClass == m.declaringClass) {
                printMethod(m)
            }
        }
        exdent()
    }

    fun printClassHeader() {
        val sc = thisClass.superclass
        val classModifiers = thisClass.modifiers

        write(Modifier.toString(classModifiers))
        write(" class ")
        write(className)
        if (sc.name !== "java.lang.Object") {
            write(" extends " + sc.name)
        }
        val interfaces = thisClass.interfaces
        if (interfaces.size > 0) {
            write(" implements")
            for (i in interfaces.indices) {
                write(if (i == 0) " " else ", ")
                write(interfaces[i].name)
            }
        }
        writeln(" {")
        indent()
    }

    private fun printClassCloser() {
        exdent()
        writeln("}")
    }

    fun printFields() {
        val fields = thisClass.fields
        writeln("// Fields:")
        indent()
        for (f in fields) {
            printField(f)
        }
        exdent()
    }

    fun printField(field: Field) {
        val modifiers = field.modifiers
        write(Modifier.toString(modifiers) + " ")
        write(decodeType(field.type.name))
        write(" " + field.name + ";")
        val declaredIn = field.declaringClass.name
        if (className != declaredIn) {
            write("  // inherited from " + declaredIn)
        }
        writeln("")
    }

    fun decodeType(typeCode: String): String {
        // horrible code!!
        var arrayLevel = 0
        var brackets = ""
        while (typeCode[arrayLevel] == '[') {
            arrayLevel++
            brackets += "[]"
        }
        // probably should use a hashmap or something similar...
        when (typeCode[arrayLevel]) {
            'B' -> return "byte" + brackets
            'C' -> return "char" + brackets
            'D' -> return "double" + brackets
            'F' -> return "float" + brackets
            'I' -> return "int" + brackets
            'J' -> return "long" + brackets
            'S' -> return "short" + brackets
            'Z' -> return "boolean" + brackets
            'V' -> return "void" + brackets
            'L' -> return simplifyName(typeCode) + brackets
            else -> return typeCode + brackets
        }
    }

    fun printMethod(method: Method) {
        write(Modifier.toString(method.modifiers) + " ")
        write(decodeType(method.returnType.name))
        write(" " + method.name + "(")
        printParameters(method.parameterTypes)
        writeln(") { }")
    }

    fun printParameters(parameters: Array<Class<*>>) {
        if (parameters.size == 0)
            return

        write(decodeType(parameters[0].name))
        for (cl in parameters) {
            write(", " + simplifyName(decodeType(cl.name)))
            write("[" + decodeType(cl.name) + "]")
        }
    }

    fun simplifyName(name: String): String {
        val last = name.lastIndexOf(".") + 1
        return if (last < 0) name else name.substring(last, name.length - 1)
    }

    companion object {
        private val serialVersionUID: Long

        init {
            serialVersionUID = 1L
        }

        fun getSpy(c: Class<*>): Spy {
            return Spy(c)
        }

        @Throws(ClassNotFoundException::class)
        fun getSpy(className: String): Spy {
            return Spy(className)
        }

        fun printInfo(field: Field) {
            println("    " + field.name)
            val modifiers = field.modifiers
            println("        Modifiers: " + modifiers)
            println("        Type:      " + field.type.name)
        }

        fun myGetType(obj: Any): String {
            return "Not implemented."
        }
    }
}