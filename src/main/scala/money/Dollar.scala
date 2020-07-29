package money

case class Dollar(override protected val amount: Int) extends Money(amount) {
  override def times(multiplier: Int): Money =
    Dollar(amount * multiplier)
}
