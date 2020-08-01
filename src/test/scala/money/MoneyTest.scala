package money

import org.scalatest.flatspec.AnyFlatSpec

class MoneyTest extends AnyFlatSpec {

  "Money" should "be able to multiply" in {
    val five: Money = Money.dollar(5)
    assert(five.times(2) === Money.dollar(10))
    assert(five.times(3) === Money.dollar(15))
  }

  it should "have equality" in {
    assert(Money.dollar(5) === Money.dollar(5))
    assert(Money.dollar(5) !== Money.dollar(6))
    assert(Money.franc(5) !== Money.dollar(5))
  }

  it should "have currency" in {
    assert(Money.dollar(1).currency === "USD")
    assert(Money.franc(1).currency === "CHF")
  }

  it should "be able to add simply" in {
    val five    = Money.dollar(5)
    val sum     = five.plus(five)
    val bank    = new Bank()
    val reduced = bank.reduce(sum, "USD")
    assert(reduced === Money.dollar(10))
  }
}
