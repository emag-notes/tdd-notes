package money

class Sum(val augend: Expression, val addend: Expression) extends Expression {
  override def times(multiplier: Int): Expression = {
    new Sum(augend.times(multiplier), addend.times(multiplier))
  }

  override def plus(added: Expression): Expression = new Sum(this, added)

  override def reduce(bank: Bank, to: String): Money = {
    val amount = augend.reduce(bank, to).amount + addend.reduce(bank, to).amount
    new Money(amount, to)
  }
}
