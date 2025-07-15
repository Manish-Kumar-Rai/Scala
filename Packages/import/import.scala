import bobsdelights.Fruit
import bobsdelights.Fruits.{Apple,Orange}

@main def run():Unit = 
    // println(Fruits.menu(1).name)
    println(Apple.name)

    def showFruit(fruit:Fruit):Unit =
        import fruit.* 
        println(s"${name} are ${color}")

    showFruit(Apple)

// -- To run
// scala-cli run fruit.scala import.scala