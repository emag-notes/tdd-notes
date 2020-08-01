package money

class Money(protected val amount: Int, protected val _currency: String) extends Expression {
  def currency: String = _currency

  def times(multiplier: Int): Money  = new Money(amount * multiplier, _currency)
  def plus(added: Money): Expression = new Money(amount + added.amount, _currency)

  override def equals(other: Any): Boolean =
    other match {
      case that: Money => this.amount == that.amount && this.currency == that.currency
      case _           => false
    }

  override def toString: String = s"$amount $currency"
}

object Money {
  def dollar(amount: Int): Money = new Money(amount, "USD")
  def franc(amount: Int): Money  = new Money(amount, "CHF")
}
