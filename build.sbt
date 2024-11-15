Global / onChangedBuildSource := ReloadOnSourceChanges

lazy val scala3Version         = "3.3.4"
lazy val sbtPluginScalaVersion = "2.12.20"

lazy val root = (project in file("."))
  .aggregate(library, plugin)

lazy val plugin = project
  .in(file("modules/plugin"))
  .enablePlugins(SbtPlugin)
  .settings(
    name                             := "sbt-playground",
    scalaVersion                     := sbtPluginScalaVersion,
    sbtPluginPublishLegacyMavenStyle := false,
    scriptedLaunchOpts := {
      scriptedLaunchOpts.value ++
        Seq("-Xmx1024M", "-Dplugin.version=" + version.value)
    },
    scriptedBufferLog := false
  )

lazy val library = (project in file("modules/library"))
  .settings(
    name := "playground-library"
  )
