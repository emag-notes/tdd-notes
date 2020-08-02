package xunit

import org.scalatest.flatspec.AnyFlatSpec

class TestCaseTest extends AnyFlatSpec {
  "TestCase" should "record weather test was run or not" in {
    val test = new WasRun(name = "testMethod")
    assert(test.wasRun === false)
    test.run()
    assert(test.wasRun)
  }
}
