import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

   val baseSettings = Defaults.defaultSettings

    val appName         = "fullfilment-app"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      "org.jbehave" % "jbehave-core" % "3.6.6" % "test",
      "org.jbehave.web" % "jbehave-web-selenium" % "3.5.4" % "test",
      "org.seleniumhq.selenium.fluent" % "fluent-selenium" % "1.6.3" % "test"
    )

  lazy val setupJBehave = TaskKey[Unit]("setup-jbehave", "Copies the jbehave story and resources files to the Target folder")

  lazy val setupJBehaveSetting =
    setupJBehave <<=
      (baseDirectory, classDirectory in Test, compile in Test) map {
        (bd, testTargetDir, _) =>
          IO.copyDirectory(bd / "test" / "ui" / "stories/", testTargetDir)
      }


    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA, settings = baseSettings ++ Seq(setupJBehaveSetting)).settings(
    )

}
