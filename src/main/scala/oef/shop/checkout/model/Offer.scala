package oef.shop.checkout.model

/**
  * Encapsulated Offer objects creation to only allow numbers greater than zero, to avoid division by zero and negative results on price calculations.
  * */
trait Offer {
  def onItem: Item
  def buy: Int
  def pay: Int
}
object Offer {
  def apply(onItem: Item, buy: Int, pay: Int): Offer = {
    require(buy > 0 && pay > 0, s"buy is: $buy, pay is: $pay, but both must be greater than zero.")
    OfferImpl(onItem, buy, pay)
  }

  private case class OfferImpl(onItem: Item, buy: Int, pay: Int) extends Offer

}