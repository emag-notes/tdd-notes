package money

class Sum(val augend: Money, val addend: Money) extends Expression {
  def reduce(to: String): Money = {
    val amount = augend.amount + addend.amount
    new Money(amount, to)
  }
}