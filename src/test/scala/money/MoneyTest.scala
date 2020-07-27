package money

import org.scalatest.flatspec.AnyFlatSpec

class MoneyTest extends AnyFlatSpec {

  "Dollar" should "be able to multiply" in {
    val five = Dollar(5)
    assert(five.times(2) === Dollar(10))
    assert(five.times(3) === Dollar(15))
  }

  it should "have equality" in {
    assert(Dollar(5) === Dollar(5))
    assert(Dollar(5) !== Dollar(6))
  }

  "Franc" should "be able to multiply" in {
    val five = Franc(5)
    assert(five.times(2) === Franc(10))
    assert(five.times(3) === Franc(15))
  }
}
