name := "BigMC"

version := "2.0"

// disable using the Scala version in output paths and artifacts
crossPaths := false

resolvers += DefaultMavenRepository

resolvers += "My bitbucket maven releases repo" at "https://bitbucket.org/eloipereira/maven-repo-releases/raw/master"

libraryDependencies += "de.sciss" % "jsyntaxpane" % "1.0.0"

publishTo <<= version { (v: String) =>
  if (v.trim.endsWith("SNAPSHOT"))
    Some(Resolver.file("file",  new File( Path.userHome.absolutePath+"/.m2/repository/snapshots" )) )
  else
    Some(Resolver.file("file",  new File( Path.userHome.absolutePath+"/.m2/repository/releases" )) )
}
