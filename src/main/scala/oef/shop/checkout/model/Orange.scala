package oef.shop.checkout.model

import oef.shop.checkout.model.base.Price

case class Orange(override val price: Price) extends Fruit(price)
