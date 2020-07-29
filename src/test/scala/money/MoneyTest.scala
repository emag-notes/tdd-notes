package money

import org.scalatest.flatspec.AnyFlatSpec

class MoneyTest extends AnyFlatSpec {

  "Dollar" should "be able to multiply" in {
    val five: Money = Money.dollar(5)
    assert(five.times(2) === Money.dollar(10))
    assert(five.times(3) === Money.dollar(15))
  }

  "Franc" should "be able to multiply" in {
    val five = Money.franc(5)
    assert(five.times(2) === Money.franc(10))
    assert(five.times(3) === Money.franc(15))
  }

  "Money" should "have equality" in {
    assert(Money.dollar(5) === Money.dollar(5))
    assert(Money.dollar(5) !== Money.dollar(6))
    assert(Money.franc(5) === Money.franc(5))
    assert(Money.franc(5) !== Money.franc(6))
    assert(Money.franc(5) !== Money.dollar(5))
  }

  it should "have currency" in {
    assert(Money.dollar(1).currency === "USD")
    assert(Money.franc(1).currency === "CHF")
  }
}
