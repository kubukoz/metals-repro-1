ThisBuild / organization := "com.example"
ThisBuild / scalaVersion := "2.13.5"

lazy val root = (project in file(".")).settings(
  name := "demo",
  libraryDependencies ++= Seq(
    "co.fs2" %% "fs2-core" % "3.0.0-M9"
  )
)
