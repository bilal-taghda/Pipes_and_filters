package com.p.p

import akka.actor.{ActorSystem, Props}

object Main extends App {

   override def main(args: Array[String]): Unit = {
    val orderText = "ORDER CHECK_OUT DELIVERY DONE"
    val rawOrderBytes = orderText.toCharArray.map(_.toByte)
    val system = ActorSystem("eaipatterns")

    val filter3 = system.actorOf(Props[Delivery], "Delivery")
    val filter2 = system.actorOf(Props(classOf[Check_Out], filter3), "Check_Out")
    val filter1 = system.actorOf(Props(classOf[Order], filter2), "Order")

    filter1 ! rawOrderBytes


  }
}
