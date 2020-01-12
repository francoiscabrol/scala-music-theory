# Music theory models in Scala

The idea is to create a basic Scala music theory library inspired by the [go-music-theory](https://github.com/go-music-theory/music-theory) 
and the [libjamu](https://github.com/francoiscabrol/libjamu).

You can look into the [tests](https://github.com/francoiscabrol/scala-music-theory/tree/master/src/test/scala/music/theory) to see examples.

You can try it by adding the following in your build.sbt:
```
libraryDependencies += "io.github.francoiscabrol" %% "scala-music-theory" % "0.2-SNAPSHOT"

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
```

To test:
    `sbt test`
To publish:
    `sbt publish` or just merge into master, a github action will take care about that