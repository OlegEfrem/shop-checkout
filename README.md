# Shop checkout coding challenge
Complete assignment cand be found [here](https://github.com/OlegEfrem/shop-checkout/blob/master/Assignment.pdf)

# Requirements
This is a scala sbt project, and was developed and tested to run with: Java 1.8, Scala 2.11.8 and Sbt 0.13.8

# Highlights
1. High level of abstraction with single Trait based point entries into the service/package. 
2. [CheckoutService](https://github.com/OlegEfrem/shop-checkout/blob/master/src/main/scala/com/oef/shop/checkout/CheckoutService.scala) is decoupled from the [OfferCache](https://github.com/OlegEfrem/shop-checkout/blob/master/src/main/scala/com/oef/shop/checkout/OfferCache.scala), the latter being injectable into the former.
3. The two points above facilitate provision of alternative implementations at any level, simple but robust unit testing in isolation and iterative development.
4. [CheckoutService](https://github.com/OlegEfrem/shop-checkout/blob/master/src/main/scala/com/oef/shop/checkout/CheckoutService.scala) functions exhibit code reuse: function checkout (from fist development iteration) is used by function checkoutWithOffer (from the second development iteration).
5. [DefaultCacheOffer](https://github.com/OlegEfrem/shop-checkout/blob/master/src/main/scala/com/oef/shop/checkout/default/DefaultOfferCache.scala) encapsulates the offers, accessible to the client code only via the extended trait, hiding the implementation internals. 