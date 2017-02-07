package com.oef.shop.checkout.model

import org.scalatest.{ FlatSpec, Matchers }

class OfferTest extends FlatSpec with Matchers {

  "offer creation with zero buy/pay items" should "throw exception" in {
    a[IllegalArgumentException] should be thrownBy {
      Offer(Apple(), 0, 0)
    }
  }
}
