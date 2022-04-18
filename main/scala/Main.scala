import java.io.{BufferedWriter, FileWriter}

import scala.collection.JavaConversions._
import scala.collection.mutable.ListBuffer
import scala.util.Random
import scala.collection.immutable.NumericRange
import au.com.bytecode.opencsv.CSVWriter

object MakeCSV extends App {
  val out = new BufferedWriter(new FileWriter("D:/Users/dwaynemcmorris/Desktop/Agent/agents.csv"))
  val csvWriter = new CSVWriter(outputFile)
  val csvFields = Array("agent_Id","agent_name","agent_rating")
  val nameList = List("John", "Jacob", "Jack", "Johnny", "Tim", "Drake", "Larry")
  val agentratingList = Range.BigDecimal(5.8,9.6,0.1).toList
  val agentIdList = Range.BigDecimal(4.0,10.5,0.1).toList
  val random = new Random()
  var listOfRecords = new ListBuffer[Array[String]]()
  listOfRecords += csvFields

  for(i <- 1 until 60){
    listOfRecords += Array(i.toString,nameList(random.nextInt(nameList.length)),agentratingList(random.nextInt(agentratingList.length)).toString(),agentIdList(random.nextInt(agentIdList.length()).tostring()))
  }

csvWriter.writeAll(listOfRecords.toList)
outputFile.close()
}
