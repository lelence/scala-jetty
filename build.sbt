name := "scala-jetty"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies ++= Seq(
  "org.eclipse.jetty" % "jetty-server" % "9.4.15.v20190215",
  "com.typesafe.akka" %% "akka-actor" % "2.5.21",
  "org.slf4j" % "slf4j-api" % "1.7.26",
  "ch.qos.logback" % "logback-core" % "1.2.3",
  "ch.qos.logback" % "logback-classic" % "1.2.3"
)