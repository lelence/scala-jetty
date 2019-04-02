package com.maogogo.jetty

import akka.actor.ActorSystem

object AkkaJettyServer extends App {

  val system = ActorSystem("MySystem")

   JettyServerExtension(system).start

}
