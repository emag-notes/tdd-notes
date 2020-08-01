package money

import scala.collection.mutable

class Bank {
  private val rates = mutable.Map[Pair, Int]()

  private[money] def reduce(source: Expression, to: String): Money =
    source.reduce(this, to)

  private[money] def addRate(from: String, to: String, rate: Int): Unit =
    rates.put(new Pair(from, to), rate)

  private[money] def rate(from: String, to: String): Int =
    rates.getOrElse(new Pair(from, to), 1)
}
