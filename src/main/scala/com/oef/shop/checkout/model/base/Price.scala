package com.oef.shop.checkout.model.base

case class Price(amount: Double) {
  def +(that: Price): Price = Price(this.amount + that.amount)

  def *(double: Double): Price = Price(this.amount * double)

  /**
   * Use this approximate comparison of this Price with that price to avoid Double number equality problems.
   */
  def ~=(that: Price): Boolean = if ((that.amount - this.amount).abs < Price.precision) true else false
}

object Price {
  val precision = 0.00001
}
