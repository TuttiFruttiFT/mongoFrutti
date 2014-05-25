name := "mongoFrutti"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache
)     

libraryDependencies += "org.mongodb" % "mongo-java-driver" % "2.11.4"

libraryDependencies += "org.mongodb.morphia" % "morphia" % "0.107"

libraryDependencies += "org.jongo" % "jongo" % "1.0"

libraryDependencies += "org.projectlombok" % "lombok" % "1.12.6"

play.Project.playJavaSettings
