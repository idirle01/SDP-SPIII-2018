fun main(args: Array<String>){
    val myPet = Parrot()
    playWith(myPet) // myPet "is-a" bird and can fly()

    val myOtherPet = Penguin()
    playWith(myOtherPet) // myOtherPet "is-a" bird and cannot fly()!?!
}

fun playWith(bird: Bird) = bird.fly()