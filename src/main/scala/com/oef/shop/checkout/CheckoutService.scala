package com.oef.shop.checkout

import com.oef.shop.checkout.model.Item
import com.oef.shop.checkout.model.base.Price

/**
 * Trait for CheckoutService implementations. Used trait/implementation model to allow clients to unit test own functionality in isolation (eg. mocking)
 */
trait CheckoutService {

  def checkout(items: Traversable[Item]): Price

  def checkoutWithOffer(items: Traversable[Item]): Price

}
