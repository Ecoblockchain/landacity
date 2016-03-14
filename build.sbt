
name := "landacity"

organization := "ru.pilin"

version := "0.1"

scalaVersion := "2.11.8"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8", "-feature")

lazy val root = (project in file(".")).enablePlugins(PlayScala)
  .settings(

    libraryDependencies ++= Seq(

      // Scala compiler requred for compiling scalate templates
      "org.scala-lang" % "scala-compiler" % scalaVersion.value,

      "org.clapper" %% "grizzled-slf4j" % "1.0.2",
      "org.codehaus.groovy" % "groovy" % "2.4.6",

      // Scalate integration for Play framework
      "com.github.tototoshi" %% "play-scalate" % "0.2.0",
      "org.scalatra.scalate" %% "scalate-core" % "1.7.1",

      "org.webjars" %% "webjars-play" % "2.5.0",
      "org.webjars.bower" % "semantic-ui" % "2.1.8"
    )
  )

// Views for scalate templates
unmanagedResourceDirectories in Compile += baseDirectory.value / "app" / "views"
