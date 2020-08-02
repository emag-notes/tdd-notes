import Dependencies._

ThisBuild / scalaVersion := "2.13.3"
ThisBuild / version := "0.1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .settings(
    name := "tdd-notes",
    scalacOptions ++= Seq(
        "-deprecation",
        "-Yrangepos",
        "-Ywarn-unused",
        "-P:semanticdb:failures:warning"
      ),
    addCompilerPlugin(scalafixSemanticdb),
    libraryDependencies ++= Seq(
        scalaReflect,
        scalaTest % Test
      )
  )
