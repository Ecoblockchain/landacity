
name := "landacity"

organization := "ru.pilin"

version := "0.1"

scalaVersion := "2.11.7"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8", "-feature")

lazy val root = (project in file(".")).enablePlugins(PlayScala)
