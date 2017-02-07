package oef.shop.checkout.default

import oef.shop.checkout.dummy.DummyParam
import oef.shop.checkout.model.{Apple, Offer, Item}
import oef.shop.checkout.model.base.Price
import org.scalatest.{Matchers, FlatSpec}
import OfferCalculator._

class OfferCalculatorTest extends FlatSpec with Matchers with DummyParam {

  "calculate itemsOnOffer" should s"return ${Price(0.0)} on no items" in {
    val items = makeItems()
    val offer = makeOfferFor()
    calculate(items, offer) shouldBe Price(0.0)
  }

  it should "apply offer only on 4 out of 5 apples" in {
    val items = makeItems(5, 0)
    val offer = Offer(Apple(), 2, 1)
    (calculate(items, offer) ~= Price(1.8)) shouldEqual true
  }
}
