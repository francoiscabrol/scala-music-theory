name := "scala-music-theory"

organization := "francoiscabrol"

version := "0.0.1"

scalaVersion := "2.11.5"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.1" % "test" withSources() withJavadoc(),
  "org.scalacheck" %% "scalacheck" % "1.12.1" % "test" withSources() withJavadoc()
)

scalacOptions := Seq("-feature", "-deprecation")

initialCommands := "import francoiscabrol._; import francoiscabrol.music.theory._; import francoiscabrol.music.generator._"

