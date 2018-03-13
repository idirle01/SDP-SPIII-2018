String.metaClass.getDescore = { ->
    delegate.replace('_', ' ')
}

Integer.metaClass.propertyMissing = { name ->
    def match = name =~ /(scoop(s)?)_of_(.*)/
    if (match)
        return [(match.group(3).descore): delegate]
}

def icecream = new IceCream()

icecream.order {
    serve_in_waffle_cone

    add(3.scoops_of_chocolate_chip)
    add(2.scoops_of_pistachio)
    add(1.scoop_of_marmite)

    make_it_snappy

    use_a_left_handed_icecream_scoop
}

println icecream