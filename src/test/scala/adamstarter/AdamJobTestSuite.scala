package adamstarter;

import junit.framework._;
import Assert._
import org.scalatest.FunSuite
;

class AdamJobSuite extends FunSuite {

  test("Arbitrary test for functionality")
  {
    val x = AdamJob.commandDescription

    assert( x === AdamJob.commandDescription )
  }

}

