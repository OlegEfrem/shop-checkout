package com.oef.shop.checkout.model

import com.oef.shop.checkout.model.base.Price
import org.scalatest.{ Matchers, WordSpec }

class PriceTest extends WordSpec with Matchers {

  s"adding ${Price(2.5)} with ${Price(1.3)}" should {
    s"return ${Price(3.8)}" in {
      Price(2.5) + Price(1.3) shouldBe Price(3.8)
    }

    s"not return ${Price(5)}" in {
      Price(2.5) + Price(1.3) should not be Price(5)
    }
  }

  s"multiplying ${Price(2.5)} with 2" should {
    s"return ${Price(5)}" in {
      Price(2.5) * 2 shouldBe Price(5)
    }

    s"not return ${Price(3.8)}" in {
      Price(2.5) * 2 should not be Price(3.8)
    }
  }

  s"Aproximate comparision of ${Price(2.5)}" should {
    val aproxEqual = Price(2.5 + Price.precision * 0.1)
    val aproxNotEqual = Price(2.5 + Price.precision)
    s"consider it equal with $aproxEqual" in {
      (Price(2.5) ~= aproxEqual) shouldBe true
    }

    s"not consider it equal with $aproxNotEqual" in {
      (Price(2.5) ~= aproxNotEqual) shouldBe false
    }
  }

}