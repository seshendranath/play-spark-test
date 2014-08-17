package controllers

import play.api._
import play.api.mvc._
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object Application extends Controller {

  def index = Action {
    val conf = new SparkConf().setAppName("Spark And Play").
                      setMaster("spark://localhost:7077")
    conf.setSparkHome("/Users/sujee/hadoop/spark-1.0.2-hadoop2")
    conf.setJars(List("/Users/sujee/dev/play-spark/target/scala-2.10/play-spark_2.10-1.0.jar"))
      //println("hello world")
      //Logger.info (conf.toDebugString)
      println(conf.toDebugString)

    val sc = new SparkContext(conf)
    val file = "/etc/hosts"
    val f = sc.textFile(file)
    val t1 = System.nanoTime()
    val count = f.count()
    val t2 = System.nanoTime()
    println ("### %s : count (%,d) took %,d ms".format(file, count, (t2-t1)/1000000 ))


    // Ok(views.html.index("Your new application is ready."))
    Ok("###Application::index  done")
  }

}