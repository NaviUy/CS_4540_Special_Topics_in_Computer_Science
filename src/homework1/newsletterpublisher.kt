package homework1

object newsletterpublisher: Subject {

    init{
        println("New Newsletter Instantiated")
    }

    val sub = mutableListOf<Subscriber>()
    var x: Int = 1

    override fun registerObserver(s: Subscriber) {
        sub.add(s)
    }

    override fun removeObserver(s: Subscriber) {
        val name = s.name
        println("$name has unsubscribed!")
        sub.remove(s)
    }

    override fun notifyObserver(s: String) {
        sub.forEach{e -> e.update(s)}
    }

    fun setState(i : Int){
        this.x = i
    }
}