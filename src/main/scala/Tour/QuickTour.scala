package Tour

import org.mongodb.scala._
import Tour.Helpers._

/**
 * The QuickTour code example
 */
object QuickTour {
  //scalastyle:off method.length

  /**
   * Run this main method to see the output of this quick example.
   *
   * @param args takes an optional single argument for the connection string
   * @throws Throwable if an operation fails
   */
  def main(args: Array[String]): Unit = {

    val mongoClient: MongoClient = if (args.isEmpty) MongoClient() else MongoClient(args.head)

    // get handle to "snam" database
    val database: MongoDatabase = mongoClient.getDatabase("snam")

    // get a handle to the "documents" collection
    val collection: MongoCollection[Document] = database.getCollection("documents")

    // get documents from the collection
    collection.find().printResults()

    // release resources
    mongoClient.close()
  }

}
