package adamstarter

import edu.berkeley.cs.amplab.adam.cli._
import org.kohsuke.args4j.Argument
import org.apache.spark.{SparkContext, Logging}
import org.apache.hadoop.mapreduce.Job
import org.apache.spark.rdd.RDD
import edu.berkeley.cs.amplab.adam.avro.ADAMRecord
import edu.berkeley.cs.amplab.adam.rdd.AdamContext._


object AdamJob extends AdamCommandCompanion {
  val commandName = "ADAM Job"
  val commandDescription = "Compute things using ADAM"

  def apply (args: Array[String]): AdamJob = {
    new AdamJob (Args4j[AdamJobArgs](args))
  }
}


class AdamJobArgs extends Args4jBase with ParquetArgs with SparkArgs {
  @Argument (metaVar = "INPUT", required = true, usage = "BAM File or ADAM File", index = 0)
  var input: String = _
}

class AdamJob (protected val args: AdamJobArgs) extends AdamSparkCommand [AdamJobArgs] with Logging {

  val companion = AdamJob

  def run (sc: SparkContext, job: Job) {
    log.info("Reading input file from %s".format(args.input))

    //load
    val records: RDD[ADAMRecord] = sc.adamLoad(args.input)

    log.info("Processed %d records".format(records.count))

}


}