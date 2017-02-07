package oef.shop.checkout.model

import oef.shop.checkout.model.base.Price

case class Apple(override val price: Price) extends Fruit(price)
