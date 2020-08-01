package money

trait Expression {
  def reduce(to: String): Money
}
