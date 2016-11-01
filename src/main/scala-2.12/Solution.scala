import scala.collection.mutable
import java.util.Scanner

object Solution {

  case class Customer(arrivalTime: Long, cookingTime: Long)

  implicit val CustomerOrdering = Ordering.by[Customer, Long](customer => -customer.cookingTime)

  def caculateWaitingTime(customersList: mutable.MutableList[Customer]): Long = {
    var currentTime = 0L
    var totalTime = 0L
    var customers = customersList
    val queue = new mutable.PriorityQueue[Customer]()
    while (customers.nonEmpty || queue.nonEmpty) {
      val customersAtTimeT = customers.takeWhile(customer => customer.arrivalTime <= currentTime)
      customers = customers.drop(customersAtTimeT.length)
      customersAtTimeT.foreach(x => queue.enqueue(x))
      if (queue.nonEmpty) {
        val customerToServe = queue.dequeue()
        totalTime += currentTime + customerToServe.cookingTime - customerToServe.arrivalTime
        currentTime += customerToServe.cookingTime
      }
      else if (customers.nonEmpty && queue.isEmpty && currentTime < customers.head.arrivalTime)
        currentTime = customers.head.arrivalTime
    }
    val result = totalTime / customersList.length
    result
  }

  def main(args: Array[String]) {
    val inputReader = new Scanner(System.in)
    val numberOfCustomers = inputReader.nextInt()
    var customers = mutable.MutableList.fill(numberOfCustomers)(Customer(inputReader.nextLong(), inputReader.nextLong()))
    customers = customers.sortBy(customer => customer.arrivalTime)
    val result: Long = caculateWaitingTime(customers)
    println(result)
  }
}
