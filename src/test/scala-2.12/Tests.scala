import Solution.Customer
import org.junit.Assert._
import org.junit.Test
import scala.collection.mutable

/**
  * Created by hhmx3422 on 11/1/16.
  */
class Tests {
  @Test def oneElementShouldReturnItsJobCost {
    assertTrue(Solution.caculateWaitingTime(mutable.MutableList(Customer(0, 2))) == 2)
  }

  @Test def testOne {
    assertEquals(9, Solution.caculateWaitingTime(mutable.MutableList(Customer(0, 3), Customer(1, 9), Customer(2, 6))))
  }

  @Test def tesTwo {
    assertEquals(8, Solution.caculateWaitingTime(mutable.MutableList(Customer(0, 3), Customer(1, 9), Customer(2, 5))))
  }

  @Test def testOneGap {
    assertEquals(6, Solution.caculateWaitingTime(mutable.MutableList(Customer(0, 3), Customer(4, 9))))
  }

  @Test def testGapAtStart {
    assertEquals(7, Solution.caculateWaitingTime(mutable.MutableList(Customer(3, 3), Customer(4, 9))))
  }
}
