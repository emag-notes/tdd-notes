package money

import org.scalatest.flatspec.AnyFlatSpec

class MoneyTest extends AnyFlatSpec {

  "Dollar" should "be able to multiply" in {
    val five = new Dollar(5)
    five.times(2)
    assert(five.amount === 10)
  }
}
