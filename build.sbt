name := "teste-mutant"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies ++= Seq(
  "com.github.finagle" %% "finch-core" % "0.22.0",
  "com.github.finagle" %% "finch-circe" % "0.22.0",
  "io.circe" %% "circe-generic" % "0.9.0",
  "com.twitter" %% "twitter-server" % "19.4.0",
  "com.twitter" %% "finagle-http" % "19.4.0",
  "com.google.code.gson" % "gson" % "2.8.5",
  "com.squareup.okhttp3" % "okhttp" % "3.14.1",
  "com.sksamuel.elastic4s" %% "elastic4s-core" % "6.5.1",
  "com.sksamuel.elastic4s" %% "elastic4s-http" % "6.5.1",
  "com.sksamuel.elastic4s" %% "elastic4s-tcp" % "6.5.1",
  "com.sksamuel.elastic4s" %% "elastic4s-http-streams" % "6.5.1"
)

resolvers += "twitter-repo" at "https://maven.twttr.com"