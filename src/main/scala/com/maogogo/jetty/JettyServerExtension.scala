package com.maogogo.jetty

import akka.actor.{ActorSystem, ExtendedActorSystem, Extension, ExtensionId, ExtensionIdProvider}
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.server.handler.ResourceHandler

object JettyServerExtension extends ExtensionId[JettyServerExtensionImpl]
  with ExtensionIdProvider {

  override def lookup = JettyServerExtension

  override def createExtension(system: ExtendedActorSystem) = {
    val port = system.settings.config.getInt("jetty.port")
    new JettyServerExtensionImpl(port)
  }

  override def get(system: ActorSystem): JettyServerExtensionImpl = super.get(system)
}

class JettyServerExtensionImpl(port: Int = 7778) extends Extension {

  def start: Unit = {
    val server = new Server(port)

    val resourceHandler = new ResourceHandler()
    resourceHandler.setResourceBase("src/main/webapp")

    server.setHandler(resourceHandler)
    server.start()
    server.join()
  }

}
