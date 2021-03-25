ThisBuild / organization := "com.example"
ThisBuild / scalaVersion := "2.13.5"

lazy val root = (project in file(".")).settings(
  name := "ce3.g8",
  libraryDependencies ++= Seq(
    "org.typelevel" %% "cats-effect" % "3.0.0-RC3",
    "org.http4s" %% "http4s-core" % "1.0.0-M19"
  )
)
