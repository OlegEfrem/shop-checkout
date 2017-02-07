package com.oef.shop.checkout.default

import com.oef.shop.checkout.OfferCache
import com.oef.shop.checkout.dummy.DummyParam
import com.oef.shop.checkout.model.{ Apple, Orange }
import org.scalatest.{ FlatSpec, Matchers }

class OfferCacheTest extends FlatSpec with Matchers with DummyParam {

  def cache: OfferCache = new DefaultOfferCache()

  "addOffer" should "add/get/remove 1 item to/from the cache" in {
    val currentCache = cache
    val applesOffer = makeOfferFor(Apple(), 2)
    currentCache.add(applesOffer)
    currentCache.getOfferFor(Apple().getClass) shouldBe Some(applesOffer)
    currentCache.remove(applesOffer)
    currentCache.getOfferFor(Apple().getClass) shouldBe None
  }

  it should "add/get/remove 2 items to/from the cache" in {
    val currentCache = cache
    val applesOffer = makeOfferFor(Apple(), 2)
    val orangesOffer = makeOfferFor(Orange(), 2)
    currentCache.add(applesOffer, orangesOffer)
    currentCache.getOfferFor(Apple().getClass) shouldBe Some(applesOffer)
    currentCache.getOfferFor(Orange().getClass) shouldBe Some(orangesOffer)
    currentCache.remove(applesOffer, orangesOffer)
    currentCache.getOfferFor(Apple().getClass) shouldBe None
    currentCache.getOfferFor(Orange().getClass) shouldBe None
  }
}