package oef.shop.checkout.default

import oef.shop.checkout.OfferCache
import oef.shop.checkout.model.{Item, Offer}
import scala.collection.mutable

class DefaultOfferCache(private val offersMap: mutable.Map[Class[_ <: Item], Offer] = new mutable.HashMap[Class[_ <: Item], Offer]()) extends OfferCache {

  def add(offers: Offer*): Unit = offers.foreach(ofr => offersMap.+=(ofr.onItem.getClass -> ofr))

  def getOfferFor(itemClass: Class[_ <: Item]): Option[Offer] = offersMap.get(itemClass)

  def remove(offers: Offer*): Unit = offers.foreach(ofr => offersMap.-=(ofr.onItem.getClass))

}
