package bobsdelights

abstract class Fruit(val name:String, val color:String)

object Fruits:
    object Apple extends Fruit("Apple","Red")
    object Orange extends Fruit("Orange","Orange")
    object Pear extends Fruit("Pear","Yellowish")
    val menu = List(Apple,Orange,Pear)