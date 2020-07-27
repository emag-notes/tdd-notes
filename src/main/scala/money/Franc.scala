package money

case class Franc(private val amount: Int) {
  def times(multiplier: Int): Franc =
    Franc(amount * multiplier)
}
