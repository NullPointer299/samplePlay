name := "samplePlay"
 
version := "1.0" 
      
lazy val `sampleplay` = (project in file(".")).enablePlugins(PlayScala)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
      
resolvers += "Akka Snapshot Repository" at "https://repo.akka.io/snapshots/"
      
scalaVersion := "2.13.3"

libraryDependencies ++= Seq(
  jdbc ,
  ehcache,
  ws ,
  specs2 % Test,
  guice,
  "mysql" % "mysql-connector-java" % "8.0.21",
  "org.playframework.anorm" %% "anorm" % "2.6.7"
)

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  

