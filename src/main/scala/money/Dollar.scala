package money

case class Dollar(private val amount: Int) {
  def times(multiplier: Int): Dollar =
    Dollar(amount * multiplier)
}
