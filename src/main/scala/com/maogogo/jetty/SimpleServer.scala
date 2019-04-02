package com.maogogo.jetty

import org.eclipse.jetty.server.Server
import org.eclipse.jetty.server.handler.ResourceHandler


object SimpleServer extends App {

  val server = new Server(7777)

  val resourceHandler = new ResourceHandler()
  resourceHandler.setResourceBase("./webapp")

  server.setHandler(resourceHandler)
  server.start()
  server.join()

}
