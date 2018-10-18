name := """play-java-starter-example"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.6"

crossScalaVersions := Seq("2.11.12", "2.12.4")

libraryDependencies += filters

// DI
libraryDependencies += guice

// Google Guava
libraryDependencies += "com.google.guava" % "guava" % "12.0"

libraryDependencies += "javax.transaction" % "javax.transaction-api" % "1.2"

// Map struct
/*libraryDependencies ++= Seq(
  javaJdbc,
  javaWs,
  "org.mapstruct" % "mapstruct-jdk8" % "1.3.0.Beta1",
  "org.mapstruct" % "mapstruct-processor" % "1.3.0.Beta1"
)*/

// Database
libraryDependencies += javaJdbc
libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.12"
libraryDependencies += "org.jdbi" % "jdbi" % "2.78"
libraryDependencies += "org.mongodb.morphia" % "morphia" % "1.3.2"
libraryDependencies += "com.h2database" % "h2" % "1.4.197"

// Testing libraries for dealing with CompletionStage...
libraryDependencies += "org.assertj" % "assertj-core" % "3.6.2" % Test
libraryDependencies += "org.awaitility" % "awaitility" % "2.0.0" % Test

// Make verbose tests
testOptions in Test := Seq(Tests.Argument(TestFrameworks.JUnit, "-a", "-v"))
