package com.oef.shop.checkout.default

import com.oef.shop.checkout.model.{ Apple, Item, Offer }
import com.oef.shop.checkout.model.base.Price
import org.scalatest.{ FlatSpec, Matchers }
import OfferCalculator._
import com.oef.shop.checkout.dummy.DummyParam

class OfferCalculatorTest extends FlatSpec with Matchers with DummyParam {

  "calculate itemsOnOffer" should s"return ${Price(0.0)} on no items" in {
    val items = makeItems()
    val offer = makeOfferFor()
    calculate(items, offer) shouldBe Price(0.0)
  }

  it should "apply offer only on 4 out of 5 apples" in {
    val items = makeItems(5)
    val offer = Offer(Apple(), 2, 1)
    (calculate(items, offer) ~= Price(1.8)) shouldEqual true
  }
}
