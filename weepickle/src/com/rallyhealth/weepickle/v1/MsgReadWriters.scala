package com.rallyhealth.weepickle.v0

import com.rallyhealth.weepickle.v0.core.Visitor
import com.rallyhealth.weepickle.v0.implicits.MacroImplicits

trait MsgReadWriters extends com.rallyhealth.weepickle.v0.core.Types with MacroImplicits{
  implicit val MsgValueR: Reader[com.rallyhealth.upack.v0.Msg] = new Reader.Delegate(com.rallyhealth.upack.v0.Msg)

  implicit val MsgValueW: Writer[com.rallyhealth.upack.v0.Msg] = new Writer[com.rallyhealth.upack.v0.Msg] {
    def write0[R](out: Visitor[_, R], v: com.rallyhealth.upack.v0.Msg): R = com.rallyhealth.upack.v0.transform(v, out)
  }
}