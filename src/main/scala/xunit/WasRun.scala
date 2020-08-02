package xunit

class WasRun(var wasRun: Boolean = false, name: String) extends TestCase(name) {
  def testMethod(): Unit = wasRun = true
}
