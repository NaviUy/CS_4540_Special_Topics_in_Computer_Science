package homework1

class Subscriber() : Observer {

    override fun update(newUpdate: String) {
        println("Look new update: $newUpdate")
    }

    //delegation

    fun subscribe(s : Subject) {
        s.registerObserver()
    }

    fun unsubscribe(s : Subject) {
        s.removeObserver()
    }

}