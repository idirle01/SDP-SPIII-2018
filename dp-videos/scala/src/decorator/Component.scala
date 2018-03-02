package decorator

trait Component {
  def draw
}

class EncapsulateTextView(c: TextView) extends Component {
  def draw = c.draw
}

class TextView(var s: String) extends Component {
  def draw = println("Drawing.." + s)
}

trait BorderDecorator extends Component {
  abstract override def draw = {
    super.draw;
    drawBorder
  }

  def drawBorder = println("Drawing border")
}

trait ScrollDecorator extends Component {
  abstract override def draw = {
    scrollTo;
    super.draw
  }

  def scrollTo = println("Scrolling..")
}

object Main extends App {
  val tw = new TextView("foo")
  val etw1 = new EncapsulateTextView(tw) with BorderDecorator with ScrollDecorator
  etw1.draw
  tw.s = "bar"
  val etw2 = new EncapsulateTextView(tw) with ScrollDecorator with BorderDecorator
  etw2.draw
}

