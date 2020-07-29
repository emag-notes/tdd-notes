package money

case class Franc(override protected val amount: Int) extends Money(amount) {
  override def times(multiplier: Int): Money =
    Franc(amount * multiplier)
}
