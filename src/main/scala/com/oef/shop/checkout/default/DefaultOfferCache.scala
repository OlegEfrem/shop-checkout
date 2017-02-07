package com.oef.shop.checkout.default

import com.oef.shop.checkout.OfferCache
import com.oef.shop.checkout.model.{ Item, Offer }
import scala.collection.mutable

/**
 * Default offer cache implementation.
 * The caching map is mutable in order to not create a whole new cache on each modification.
 * It is not expected to be modified by many users at the same time, thus multithreading should not be an issue.
 * If multithreading becomes a problem a new thread-safe implementation would be needed,
 * using Java synchronized Maps (as scala depreceted SyncronizedMap api doc suggests).
 */
class DefaultOfferCache(private val offersMap: mutable.Map[Class[_ <: Item], Offer] = new mutable.HashMap[Class[_ <: Item], Offer]) extends OfferCache {

  def add(offers: Offer*): Unit = offers.foreach(ofr => offersMap.+=(ofr.onItem.getClass -> ofr))

  def getOfferFor(itemClass: Class[_ <: Item]): Option[Offer] = offersMap.get(itemClass)

  def remove(offers: Offer*): Unit = offers.foreach(ofr => offersMap.-=(ofr.onItem.getClass))

}
