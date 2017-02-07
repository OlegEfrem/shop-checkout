package oef.shop.checkout.default

import oef.shop.checkout.model.Item
import oef.shop.checkout.model.base.Price
import oef.shop.checkout.{CheckoutService, OfferCache}

/**
  * @param offerCache constructor injected to allow mocking
  * */
class DefaultCheckoutService(offerCache: OfferCache) extends CheckoutService {

  override def checkoutWithOffer(items: Traversable[Item]): Price = {
    import OfferCalculator._
    val sum = items.groupBy(_.getClass).map { case (offerClass, possiblyOnOffer) =>
      offerCache.getOfferFor(offerClass) match {
        case Some(x) => calculate(possiblyOnOffer, x)
        case None => checkout(possiblyOnOffer)
      }
    }
    sum.foldLeft(Price(0))((a, b) => b.+(a))
  }

  override def checkout(items: Traversable[Item]): Price = items.foldLeft(Price(0.0))((a, b) => b.price + a)
}