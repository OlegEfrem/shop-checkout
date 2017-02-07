package oef.shop.checkout.model

import oef.shop.checkout.model.base.Price

case class Apple(override val price: Price = Price(0.6)) extends Fruit(price)
