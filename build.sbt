name := "play-spark"

version := "1.0"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

//scalaVersion := "2.11.1"
scalaVersion := "2.10.4"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
 //ws
  "org.apache.spark" %% "spark-core" % "1.0.2"
  //"com.typesafe.akka" %% "akka-actor" % "2.2.3",
  //"com.typesafe.akka" %% "akka-slf4j" % "2.2.3"
)

// dependencyOverrides += "com.typesafe.akka" %% "akka-actor" % "2.2.3"
//resolvers += "Akka Repository" at "http://repo.akka.io/releases/"


