package money

class Money(private[money] val amount: Int, private[money] val currency: String) extends Expression {
  private[money] def times(multiplier: Int): Money  = new Money(amount * multiplier, currency)
  private[money] def plus(added: Money): Expression = new Sum(this, added)
  def reduce(to: String): Money                     = this

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
