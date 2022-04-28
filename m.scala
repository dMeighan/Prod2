package example

  
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.FileSystem
import org.apache.hadoop.fs.Path
import java.io.PrintWriter
import scala.collection.mutable.ListBuffer
import java.io.File
import scala.io.Source
import java.util.Properties
import scala.util.Random

object genData {
    def main(args: Array[String]):Unit = {
        println(data())
        checkFile()
    }

    val random = new Random()

    def name(): String = {
        val filePath = "src/main/scala/example/names.txt"
        val file = new File(filePath)
        val nameList = Source.fromFile(file).getLines().toList
        val name = nameList(random.nextInt(nameList.length))
        return m
    }
    def age(): String = {
        val ageList = (20 to 90).toList
        var age = ageList(random.nextInt(ageList.length)).toString
        return age
    }
    def data(): Any = {
        val cvsFeilds = Array("id", "name", "age")
    }
    def reasons(): String={}
    
    def agentid(): Unit = {
       val agentsid = (1 to 10).toList
       var iD = agentsid(random.nextInt(agentsid.length)).toString()
       return iD
  }

    def agentage(): String = {
        val ageList = (30 to 90).toList
        var age = ageList(random.nextInt(ageList.length)).toString()
        return age
    }

    def agent_name(): String = {
        val names = List("Michael","Christopher","Jessica","Matthew","Ashley","Jennifer","Joshua","Amanda","Daniel","David")
        var name = names(randomInt(names.length)).toString()
        return name
    }


     def checkFile(): Unit = {
        val path = "hdfs://sandbox-hdp.hortonworks.com:8020/user/maria_dev/"
        val src = "file:///home/maria_dev/insurance.csv"
        val files = path + "insurance.csv"


        val conf = new Configuration()
        val fs = FileSystem.get(conf)
    
        println("Check if file exists")
        val nfp = new Path(files)
        val isExisting = fs.exists(nfp)
    
        if(isExisting) {
            println("File already exists")
            fs.delete(nfp, false)
        }
        
        val newOut = fs.create(new Path("insurance.csv"))
        val writer = new PrintWriter(newOut)
        writer.write("insurance.csv")
        writer.close()
    
    
}
}