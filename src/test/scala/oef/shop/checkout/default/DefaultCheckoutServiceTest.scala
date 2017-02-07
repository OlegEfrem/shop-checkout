package oef.shop.checkout.default

import oef.shop.checkout.OfferCache
import oef.shop.checkout.dummy.DummyParam
import oef.shop.checkout.model.base.Price
import oef.shop.checkout.model.{Apple, Offer, Orange}
import org.scalatest.{Matchers, WordSpec}

class DefaultCheckoutServiceTest extends WordSpec with Matchers with DummyParam {

  def checkoutService(offerCache: OfferCache = new DefaultOfferCache) = new DefaultCheckoutService(offerCache)

  "checkout" should {
    "return zero for no items" in {
      checkoutService().checkout(makeItems()) shouldBe Price(0.0)
    }

    "return own price for 1 item" in {
      val applePrice = Price(0.6)
      checkoutService().checkout(Traversable(Apple(applePrice))) shouldBe applePrice
    }

    s"return ${checkSum(2, 2)} for 2 apples and 2 oranges" in {
      (checkoutService().checkout(makeItems(2, 2)) ~= checkSum(2, 2)) shouldEqual true
    }

    s"not return price for 2 oranges on one orange checkout" in {
      checkoutService().checkout(Traversable(Orange())) shouldNot be(Orange().price + Orange().price)
    }
  }


  "checkoutWithOffer" should {
    "return zero for no items" in {
      checkoutService().checkoutWithOffer(Traversable()) shouldBe Price(0.0)
    }

    "apply no offer for no offer items" in {
      (checkoutService().checkoutWithOffer(makeItems(2, 2)) ~= checkSum(2, 2)) shouldEqual true
    }

    "apply offer only on items with the offer" in {
      val offerCache = createCacheWith(Offer(Apple(), 2, 1))
      val currentCheckoutService = checkoutService(offerCache)
      (currentCheckoutService.checkoutWithOffer(makeItems(2, 2)) ~= Price(1.1)) shouldEqual true
    }

    "calculate correctly the buy/pay ratio" in {
      val offerCache = createCacheWith(Offer(Apple(), 2, 1), Offer(Orange(), 3, 2))
      val currentCheckoutService = checkoutService(offerCache)
      (currentCheckoutService.checkoutWithOffer(makeItems(3, 4)) ~= (defaultApplePrice * 2 + defaultOrangePrice * 3)) shouldEqual true
    }
  }

  private def createCacheWith(offers: Offer*): OfferCache = {
    val offerCache = new DefaultOfferCache
    offerCache.add(offers: _*)
    offerCache
  }

}