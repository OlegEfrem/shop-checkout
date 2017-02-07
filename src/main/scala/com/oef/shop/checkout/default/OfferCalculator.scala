package com.oef.shop.checkout.default

import com.oef.shop.checkout.model.base.Price
import com.oef.shop.checkout.model.{ Item, Offer }

object OfferCalculator {

  def calculate(itemsOnOffer: Traversable[Item], offer: Offer): Price = {
    val onOffer = itemsOnOffer.size / offer.buy
    val noOffer = itemsOnOffer.size % offer.buy
    val itemPrice = offer.onItem.price.amount
    Price(onOffer * offer.pay * itemPrice + noOffer * itemPrice)
  }
}
