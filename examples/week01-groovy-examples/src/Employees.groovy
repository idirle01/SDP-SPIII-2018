class Employee {
    def stareIntoSpace() {
        println "Employee: I'm staring into space"
    }

    def addValue() {
        println "Employee: I'm adding value"
    }
}

Employee.metaClass.invokeMethod = {
    String methodName, arguments ->
        def method = Employee.metaClass.getMetaMethod(methodName, args)
        println "Before"
        method.invoke delegate, args
        println "After"
        if (methodName == 'addValue')
            println "Boss: That there is some nice ${methodName}'ing"
        else
            println "Boss: Hey! ${methodName} on your own time!"
        println()
}

Employee e = new Employee()
e.stareIntoSpace()
e.addValue()

