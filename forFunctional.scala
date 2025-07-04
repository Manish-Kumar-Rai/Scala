@main def forLoop(args:String*):Unit = {
    for (arg:String) <- args do
        println(arg)
}