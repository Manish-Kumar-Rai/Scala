//  ------ Composition

class Engine {
    def start:Unit = println("Engine started.")
}

class Car(val engine:Engine){
    def drive:Unit = 
        engine.start
        println("Car is driving.")
}
