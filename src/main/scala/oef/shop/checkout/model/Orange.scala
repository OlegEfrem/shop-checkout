package oef.shop.checkout.model

import oef.shop.checkout.model.base.Price

case class Orange(override val price: Price = Price(0.25)) extends Fruit(price)
