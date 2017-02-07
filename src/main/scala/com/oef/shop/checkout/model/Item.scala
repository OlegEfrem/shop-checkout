package com.oef.shop.checkout.model

import com.oef.shop.checkout.model.base.Price

sealed abstract class Item(val price: Price)

abstract class Fruit(price: Price) extends Item(price)

case class Apple(override val price: Price = Price(0.6)) extends Fruit(price)

case class Orange(override val price: Price = Price(0.25)) extends Fruit(price)
