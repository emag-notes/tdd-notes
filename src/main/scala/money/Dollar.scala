package money

case class Dollar(amount: Int) {
  def times(multiplier: Int): Dollar =
    Dollar(amount * multiplier)
}
