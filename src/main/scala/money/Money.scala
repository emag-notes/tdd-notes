package money

abstract class Money(protected val amount: Int, protected val _currency: String) {
  def times(multiplier: Int): Money
  def currency: String = _currency
}

object Money {
  def dollar(amount: Int): Money = Dollar(amount, "USD")
  def franc(amount: Int): Money  = Franc(amount, "CHF")
}
