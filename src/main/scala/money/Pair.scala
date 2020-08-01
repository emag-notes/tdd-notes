package money

class Pair(private val from: String, private val to: String) {
  override def equals(other: Any): Boolean =
    other match {
      case that: Pair => from == that.from && to == that.to
      case _          => false
    }

  override def hashCode(): Int = 0
}
