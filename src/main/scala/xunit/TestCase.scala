package xunit

import scala.reflect.runtime.{universe => ru}

class TestCase(name: String) {
  def run(): Unit = {
    val self         = ru.runtimeMirror(getClass.getClassLoader).reflect(this)
    val methodSymbol = self.symbol.typeSignature.member(ru.TermName(name)).asMethod
    self.reflectMethod(methodSymbol)()
  }
}
