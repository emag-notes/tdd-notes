package money

case class Franc(override protected val amount: Int) extends Money(amount) {
  def times(multiplier: Int): Franc =
    Franc(amount * multiplier)
}
