##Prepare
Requires [XSBT](http://github.com/harrah/xsbt/tree/0.9).

    > git clone git@github.com:maeda-/xsbt-switch-environment-plugin.git
    > cd xsbt-switch-environment-plugin
    > xsbt
    sbt> publish-local

##Example

    > cd example
    > cat project/plugins/build.sbt
    libraryDependencies <<= (libraryDependencies, appConfiguration) { (deps, app) => deps :+ "maeda_" %% "switch-environment" % "0.1" }
    > cat src/main/scala/Main.scala
    object Main extends Application{
      println("-- start : %s --".format(scala.tools.nsc.Properties.versionString) )
    }
    > xsbt
    [info] Updating...
    [info] Done updating.
    [info] Set current project to default (in build file:/Users/maeda/scala/example/)    
    ** sbt> set crossScalaVersions := Seq("2.7.7", "2.8.1", "2.9.0") **
    [info] Reapplying settings...
    [info] Set current project to default (in build file:/Users/maeda/scala/example/)
    ** sbt> run-all-version **
    [info] Reapplying settings...
    [info] Set current project to default (in build file:/Users/maeda/scala/example/)
    Compiling:
    	/Users/maeda/scala/example/src/main/scala/Main.scala
    Traversing /Users/maeda/scala/example/src/main/scala/Main.scala
    API phase took : 0.059 s
    [info] Running Main 
    ** -- start : version 2.7.7.final -- **
    [success] Total time: 5 s, completed 2011/05/25 22:17:20
    [info] Reapplying settings...
    [info] Set current project to default (in build file:/Users/maeda/scala/example/)
    [info] Updating...
    [info] Done updating.
    Compiling:
    	/Users/maeda/scala/example/src/main/scala/Main.scala
    Traversing /Users/maeda/scala/example/src/main/scala/Main.scala
    API phase took : 0.105 s
    [info] Running Main 
    ** -- start : version 2.8.1.final -- **
    [success] Total time: 3 s, completed 2011/05/25 22:17:24
    [info] Reapplying settings...
    Getting Scala 2.9.0 ...
    :: retrieving :: org.scala-tools.sbt#boot-scala
    	confs: [default]
    	4 artifacts copied, 0 already retrieved (20442kB/250ms)
    [info] Set current project to default (in build file:/Users/maeda/scala/example/)
    [info] Updating...
    [info] Done updating.
    Compiling:
    	/Users/maeda/scala/example/src/main/scala/Main.scala
    Traversing /Users/maeda/scala/example/src/main/scala/Main.scala
    API phase took : 0.272 s
    [warn] there were 1 deprecation warnings; re-run with -deprecation for details
    [warn] one warning found
    [info] Running Main 
    ** -- start : version 2.9.0.final -- **
    [success] Total time: 15 s, completed 2011/05/25 22:17:40
