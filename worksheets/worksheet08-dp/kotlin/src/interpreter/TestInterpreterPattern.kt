package interpreter

import java.util.*

fun main(args: Array<String>) {
    val tokenString = "7 3 - 2 1 + *"
    val stack = Stack<Expression>()
    val tokens = tokenString.split(" ")
    for (s in tokens) {
        if (ExpressionUtils.isOperator(s)) {
            val rightExpression: Expression = stack.pop()
            val leftExpression: Expression = stack.pop()
            val operator: Expression =
                    ExpressionUtils.getOperator(s, leftExpression, rightExpression)
            stack.push(Number(operator.interpret()))
        } else {
            stack.push(Number(java.lang.Integer.parseInt(s)))
        }
    }
    println("( " + tokenString + " ): " + stack.pop().interpret())
}
