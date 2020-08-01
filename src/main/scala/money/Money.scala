package money

class Money(private[money] val amount: Int, private[money] val currency: String) extends Expression {
  private[money] def times(multiplier: Int): Expression = new Money(amount * multiplier, currency)
  def plus(added: Expression): Expression               = new Sum(this, added)

  def reduce(bank: Bank, to: String): Money = {
    val rate = bank.rate(currency, to)
    new Money(amount / rate, to)
  }

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
