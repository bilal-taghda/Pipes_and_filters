package com.p.p

import akka.actor.{Actor, ActorRef}

class Delivery extends Actor {
  def receive = {
    case message: ProcessIncomingOrder =>
      val text = new String(message.orderInfo)
      val orderText = text.replace("DELIVERY ", "")
      println(orderText)
      context.system.shutdown()

  }
}
