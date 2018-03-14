package state

class Robot() : RoboticState {
    var roboticOn: RoboticState = RoboticOn(this)
    var roboticCook: RoboticState = RoboticCook(this)
    var roboticOff: RoboticState = RoboticOff(this)
    var roboticStandby: RoboticState = RoboticStandby(this)

    var state: RoboticState = roboticOn

    override fun walk() {
        state.walk()
        state = roboticStandby
    }

    override fun cook() {
        state.cook()
        state = roboticStandby
    }

    override fun off() {
        state.off()
    }
}
