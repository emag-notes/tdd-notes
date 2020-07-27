package money

case class Dollar(override protected val amount: Int) extends Money(amount) {
  def times(multiplier: Int): Dollar =
    Dollar(amount * multiplier)
}
