name := "scala-music-theory"

organization := "io.github.francoiscabrol"

version := "0.1-SNAPSHOT"

scalaVersion := "2.12.2"

crossScalaVersions := Seq("2.11.8", "2.12.2")

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.1" % "test" withSources() withJavadoc()
)

scalacOptions := Seq("-feature", "-deprecation")

initialCommands := "import francoiscabrol._; import francoiscabrol.music.theory._"

/**
*  PUBLISH TO SONATYPE
**/
pomIncludeRepository := { _ => false }

licenses := Seq("MIT" -> url("http://www.opensource.org/licenses/mit-license.php"))

homepage := Some(url("https://github.com/francoiscabrol/scala-music-theory"))

scmInfo := Some(
  ScmInfo(
    url("https://github.com/francoiscabrol/scala-music-theory"),
    "scm:git@github.com:francoiscabrol/scala-music-theory.git"
  )
)

developers := List(
  Developer(
    id    = "francoiscabrol",
    name  = "Francois Cabrol",
    email = "francois.cabrol",
    url   = url("https://github.com/francoiscabrol")
  )
)

publishMavenStyle := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}
