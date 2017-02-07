package oef.shop.checkout.default

import oef.shop.checkout.model.{Orange, Item, Apple}
import oef.shop.checkout.model.base.Price
import org.scalatest.{Matchers, FlatSpec}

class DefaultCheckoutServiceTest extends FlatSpec with Matchers {
  val checkoutService = new DefaultCheckoutService
  val applePrice = Price(0.6)
  val orangePrice = Price(0.25)
  val applesQty = 2
  val orangesQty = 2

  def checkSum: Price = Price(applePrice.amount * applesQty + orangePrice.amount * orangesQty)

  def makeItems:  Traversable[Item] = {
    def mk(item: Item, qty: Int) = (1 to qty).map(_ => item)
    mk(Apple(applePrice), applesQty) ++ mk(Orange(orangePrice), orangesQty)
  }

  "checkout" should "return zero for no items" in {
    checkoutService.checkout(Traversable()) should be(Price(0.0))
  }

  it should "return own price for 1 item" in {
    checkoutService.checkout(Traversable(Apple(applePrice))) should be (applePrice)
  }

  it should s"return $checkSum for $applesQty apples and $orangesQty oranges" in {
    checkoutService.checkout(makeItems) should be (checkSum)
  }

  it should s"not return price for 2 oranges on one orange checkout" in {
    checkoutService.checkout(Traversable(Orange(orangePrice))) shouldNot be (orangePrice.+(orangePrice))
  }
}