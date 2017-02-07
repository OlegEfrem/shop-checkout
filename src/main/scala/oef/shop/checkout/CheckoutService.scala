package oef.shop.checkout

import oef.shop.checkout.model.Item
import oef.shop.checkout.model.base.Price

trait CheckoutService {
  def checkout(items: Traversable[Item]): Price
}
