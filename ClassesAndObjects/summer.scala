import ChecksumAccumulator.calculate

object Summer {
  def main(args: Array[String]): Unit = {
    for (arg <- args) {
      println(s"$arg: ${calculate(arg)}")
    }
  }
}


// to run 
// scala-cli run checkSum.scala summer.scala -- arg1 arg2
