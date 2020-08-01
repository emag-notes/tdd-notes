package money

case class Dollar(override protected val amount: Int, override protected val _currency: String)
    extends Money(amount, _currency)
