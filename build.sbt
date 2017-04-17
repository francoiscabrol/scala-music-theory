name := "scala-music-theory"

organization := "io.github.francoiscabrol"

version := "0.1.0"

scalaVersion := "2.11.5"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.1" % "test" withSources() withJavadoc(),
  "org.scalacheck" %% "scalacheck" % "1.12.1" % "test" withSources() withJavadoc()
)

scalacOptions := Seq("-feature", "-deprecation")

initialCommands := "import francoiscabrol._; import francoiscabrol.music.theory._"

