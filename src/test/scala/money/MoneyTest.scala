package money

import org.scalatest.flatspec.AnyFlatSpec

class MoneyTest extends AnyFlatSpec {

  "Dollar" should "be able to multiply" in {
    val five    = Dollar(5)
    var product = five.times(2)
    assert(product.amount === 10)
    product = five.times(3)
    assert(product.amount === 15)
  }

  it should "have equality" in {
    assert(Dollar(5) === Dollar(5))
    assert(Dollar(5) !== Dollar(6))
  }

}
