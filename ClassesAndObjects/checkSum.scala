import scala.collection.mutable

class ChecksumAccumulator {
    private var sum = 0

    def add(b:Byte):Unit = {
        sum += b
    }

    def checksum():Int = {
        return ~(sum & 0xFF) + 1
    }
}

object ChecksumAccumulator {
    private val cache = mutable.Map.empty[String,Int]

    def calculate(s:String):Int  = {
        if cache.contains(s) then {
            return cache(s)
        } else {
            val acc = new ChecksumAccumulator
            for c <- s do {
                acc.add((c>>8).toByte)
                acc.add(c.toByte)
            }
            val cs = acc.checksum()
            cache += (s-> cs)
            return cs
        }
    }
}