package money

class Sum(val augend: Expression, val addend: Expression) extends Expression {
  override def plus(added: Expression): Expression = ???

  def reduce(bank: Bank, to: String): Money = {
    val amount = augend.reduce(bank, to).amount + addend.reduce(bank, to).amount
    new Money(amount, to)
  }
}
