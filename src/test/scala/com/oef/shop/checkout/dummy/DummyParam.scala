package com.oef.shop.checkout.dummy

import com.oef.shop.checkout.model.base.Price
import com.oef.shop.checkout.model.{ Apple, Item, Offer, Orange }

trait DummyParam {
  val defaultApplePrice: Price = Apple().price
  val defaultOrangePrice: Price = Orange().price

  def makeOfferFor(item: Item = Apple(), buy: Int = 1, pay: Int = 1): Offer = Offer(item, buy, pay)

  def checkSum(applesQty: Int = 0, orangesQty: Int = 0, applePrice: Price = defaultApplePrice, orangePrice: Price = defaultOrangePrice): Price =
    Price(applePrice.amount * applesQty + orangePrice.amount * orangesQty)

  def makeItems(applesQty: Int = 0, orangesQty: Int = 0, applePrice: Price = defaultApplePrice, orangePrice: Price = defaultOrangePrice): Traversable[Item] = {
    def mk(item: Item, qty: Int) = (1 to qty).map(_ => item)
    mk(Apple(applePrice), applesQty) ++ mk(Orange(orangePrice), orangesQty)
  }
}
