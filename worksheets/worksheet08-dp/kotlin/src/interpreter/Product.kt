package interpreter

class Product(
        private val leftExpression: Expression,
        private val rightExpression: Expression
) : Expression {

    override fun interpret(): Int =
            leftExpression.interpret() * rightExpression.interpret()
}
