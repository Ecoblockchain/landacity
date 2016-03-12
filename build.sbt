
name := "landacity"

organization := "ru.pilin"

version := "0.1"

scalaVersion := "2.11.8"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8", "-feature")

lazy val root = (project in file(".")).enablePlugins(PlayScala)
  .settings(

    libraryDependencies ++= Seq(

      "org.scala-lang" % "scala-library"  % scalaVersion.value,
      "org.scala-lang" % "scala-reflect"  % scalaVersion.value,
      "org.scala-lang" % "scala-compiler" % scalaVersion.value,

      "org.clapper" %% "grizzled-slf4j" % "1.0.2",
      "org.codehaus.groovy" % "groovy" % "2.4.6",
      "org.scalatra.scalate" %% "scalate-core" % "1.7.1",
      "org.webjars" %% "webjars-play" % "2.5.0",
      "org.webjars.bower" % "semantic-ui" % "2.1.8"
    )
  )
