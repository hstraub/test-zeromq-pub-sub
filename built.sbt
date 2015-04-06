import NativePackagerKeys._

lazy val commonSettings = Seq(
  organization := "at.linuxhacker",
  version := "0.1",
  scalaVersion := "2.11.5",
  name := "TestZeroMqPubSub"
)

packageArchetype.akka_application


mainClass in Compile := Some( "at.linuxhacker.zeromq.SyncPub" )

mergeStrategy in assembly := { 
  case PathList( "META-INF", "MANIFEST.MF" ) => MergeStrategy.discard
  case _ => MergeStrategy.first
}

resolvers ++= Seq("snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
  "releases" at "http://oss.sonatype.org/content/repositories/releases",
  "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases" )

libraryDependencies ++= Seq( 
  "org.zeromq" % "jeromq" % "0.3.4"
)

