import sbt._
import Keys._

object SwitchEnvPlugin extends Plugin
{
  override lazy val settings = Seq(commands += runAll)

  implicit def AofT[T](x: T) = new { def |>[S] (f: T => S): S = f(x) }
  
  def runAll = Command.command("run-all-version") {state =>
    val extracted = Project extract state
    import extracted._
    
    (state /: get(crossScalaVersions)) { (state:State, version:String) =>
      val newSession = session appendSettings Seq(
	(scalaVersion in Global in currentRef := version, "scala-version"),
	(scalacOptions in Global in currentRef += "-optimise", "scalac-options")
      )
      (
        state
        |> {state => BuiltinCommands.reapply(newSession, structure, state)}
        |> {state => Command.process("run", state)}
      )
      state
    }
  }
}
