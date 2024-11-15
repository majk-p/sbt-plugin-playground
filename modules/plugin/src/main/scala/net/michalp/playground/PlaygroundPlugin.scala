package playground

import sbt.*
import sbt.Keys.*
import sbt.complete.DefaultParsers.*
import sbt.util.Logger

import org.scalafmt.sbt.ScalafmtPlugin
import org.scalafmt.sbt.ScalafmtPlugin.autoImport.scalafmtConfig

object PlaygroundPlugin extends AutoPlugin {

  object autoImport {
    val playgroundName =
      taskKey[String]("Name to be greeted")
    val playgroundGreet =
      taskKey[Unit]("Greet the user")
  }

  import autoImport.*
  override def requires = ScalafmtPlugin // TODO make use of it

  override def projectSettings: Seq[Setting[?]] = Seq(
    playgroundGreet := {
      streams.value.log.info(s"Hello ${playgroundName.value}")
    }
  )

}
