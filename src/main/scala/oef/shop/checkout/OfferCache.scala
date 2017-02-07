package oef.shop.checkout

import oef.shop.checkout.model.{Item, Offer}

/**
  * Trait for cache implementations to be injected into the CheckoutService implementations.
  * @see example [[oef.shop.checkout.default.DefaultCheckoutService]]
  * */
trait OfferCache {

  def add(offers: Offer*): Unit

  def getOfferFor(itemClass: Class[_ <: Item]): Option[Offer]

  def remove(offers: Offer*): Unit

}
