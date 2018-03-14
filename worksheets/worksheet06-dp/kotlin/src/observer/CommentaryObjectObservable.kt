package observer

import java.util.*

class CommentaryObjectObservable(override var description: String) : Observable(), Commentary
