package com.p.p

import akka.actor.{Actor, ActorRef}

class Order(nextFilter: ActorRef) extends Actor {
  def receive = {
    case message: Array[Byte] =>
      val text = new String(message)
      println(text)
      val orderText = text.replace("ORDER ", "")
      println(orderText)
      nextFilter ! ProcessIncomingOrder(orderText.toCharArray.map(_.toByte))

  }
}
