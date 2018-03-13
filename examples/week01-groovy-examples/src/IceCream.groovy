class IceCream {
    def scoops = [:], notes = [], cone = ''

    def order(Closure closure) {
        closure.delegate = this
        closure()
    }

    String toString() {
        def string = "I am a delicious ice cream served in a $cone with \n"
        scoops.each {
            string += " - ${it.value} scoop${it.value > 1 ? 's' : ''}"
            string += " of ${it.key}\n"
        }
        string += "Additional Notes:\n"
        notes.each { string += " - ${it}\n" }
        return string
    }

    def propertyMissing(String name) {
        def match = name =~ /(serve_in)_(.*)/
        if (match)
            cone = match.group(2).descore
        else
            notes << name.descore
    }

    def add(newScoops) {
        scoops << newScoops
    }
}