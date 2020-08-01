package money

trait Expression {
  def times(multiplier: Int): Expression
  def plus(added: Expression): Expression
  def reduce(bank: Bank, to: String): Money
}
