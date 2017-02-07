package oef.shop.checkout.default

import oef.shop.checkout.CheckoutService
import oef.shop.checkout.model.Item
import oef.shop.checkout.model.base.Price

class DefaultCheckoutService extends CheckoutService {
  override def checkout(items: Traversable[Item]): Price = items.foldLeft(Price(0.0))((a, b) => b.price + a)
}
