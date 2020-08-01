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

  it should "return sum" in {
    val five   = Money.dollar(5)
    val result = five.plus(five)
    val sum    = result.asInstanceOf[Sum]
    assert(five === sum.augend)
    assert(five === sum.addend)
  }

  it should "return reduced sum" in {
    val sum    = new Sum(Money.dollar(3), Money.dollar(4))
    val bank   = new Bank
    val result = bank.reduce(sum, "USD")
    assert(result === Money.dollar(7))
  }

  it should "return reduced money" in {
    val bank   = new Bank
    val result = bank.reduce(Money.dollar(1), "USD")
    assert(result === Money.dollar(1))
  }

  it should "return reduced money between different currency" in {
    val bank = new Bank
    bank.addRate("CHF", "USD", 2)
    val result = bank.reduce(Money.franc(2), "USD")
    assert(result === Money.dollar(1))
  }

  it should "identify rate" in {
    assert((new Bank).rate("USD", "USD") === 1)
  }

  it should "add mixed currencies" in {
    val fiveBucks: Expression = Money.dollar(5)
    val tenFrancs: Expression = Money.franc(10)
    val bank                  = new Bank
    bank.addRate("CHF", "USD", 2)
    val result = bank.reduce(fiveBucks.plus(tenFrancs), "USD")
    assert(result === Money.dollar(10))
  }

  it should "sum plus money" in {
    val fiveBucks: Expression = Money.dollar(5)
    val tenFrancs: Expression = Money.franc(10)
    val bank                  = new Bank
    bank.addRate("CHF", "USD", 2)
    val sum: Expression = new Sum(fiveBucks, tenFrancs).plus(fiveBucks)
    val result          = bank.reduce(sum, "USD")
    assert(result === Money.dollar(15))
  }

  it should "sum times" in {
    val fiveBucks: Expression = Money.dollar(5)
    val tenFrancs: Expression = Money.franc(10)
    val bank                  = new Bank
    bank.addRate("CHF", "USD", 2)
    val sum: Expression = new Sum(fiveBucks, tenFrancs).times(2)
    val result          = bank.reduce(sum, "USD")
    assert(result === Money.dollar(20))
  }
}
