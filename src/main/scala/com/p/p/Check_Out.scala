package com.p.p

import akka.actor.{Actor, ActorRef}

class Check_Out(nextFilter: ActorRef) extends Actor {
  def receive = {
    case message: ProcessIncomingOrder =>
      val text = new String(message.orderInfo)
      val orderText = text.replace("CHECK_OUT", "")
      println(orderText)
      nextFilter ! ProcessIncomingOrder(orderText.toCharArray.map(_.toByte))
  }
}
