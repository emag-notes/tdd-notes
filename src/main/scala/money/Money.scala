package money

class Money(protected val amount: Int, protected val _currency: String) {
  def times(multiplier: Int): Money = new Money(amount * multiplier, _currency)
  def currency: String              = _currency

  override def equals(other: Any): Boolean =
    other match {
      case that: Money => this.amount == that.amount && this.currency == that.currency
      case _           => false
    }

  override def toString: String = s"$amount $currency"
}

object Money {
  def dollar(amount: Int): Money = Dollar(amount, "USD")
  def franc(amount: Int): Money  = Franc(amount, "CHF")
}
