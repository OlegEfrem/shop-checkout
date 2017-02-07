package oef.shop.checkout.model.base

case class Price(amount: Double) {
  def `>=`(that: Price) = this.amount > that.amount || this.~=(that)

  def `<=`(that: Price) = this.amount < that.amount || this.~=(that)

  def ~=(that: Price) = if ((that.amount - this.amount).abs < Price.precision) true else false

  def +(that: Price) = Price(this.amount + that.amount)
}

object Price {
  val precision = 0.00001
}
