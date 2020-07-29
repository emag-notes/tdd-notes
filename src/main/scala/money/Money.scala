package money

abstract class Money(protected val amount: Int) {
  def times(multiplier: Int): Money
}

object Money {
  def dollar(amount: Int): Money = Dollar(amount)
  def franc(amount: Int): Money  = Franc(amount)
}
