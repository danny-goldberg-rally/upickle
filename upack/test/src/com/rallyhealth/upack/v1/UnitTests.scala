package com.rallyhealth.upack.v0
import com.rallyhealth.weepickle.v0.core.Abort
import utest._

object UnitTests extends TestSuite{
  val tests = Tests {
    test("compositeKeys"){
      val msg = Obj(Arr(Int32(1), Int32(2)) -> Int32(1))
      val written = com.rallyhealth.upack.v0.write(msg)
      val writtenStr = com.rallyhealth.weepickle.v0.core.Util.bytesToString(written)
      writtenStr ==> "81-92-01-02-01"

      com.rallyhealth.upack.v0.read(written) ==> msg


      intercept[Abort]{
        com.rallyhealth.upack.v0.transform(written, com.rallyhealth.ujson.v0.Value)
      }
      intercept[Abort] {
        com.rallyhealth.upack.v0.transform(msg, com.rallyhealth.ujson.v0.Value)
      }
    }
  }
}