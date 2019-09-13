package homework1

//Subscriber Class that implements Observer

class Subscriber(s : Subject) : Observer {

    override fun update(newUpdate: String) {
        println("Look new update: $newUpdate")
    }

    //delegating subscribe and unsubscribe to a instance of subject
    //takes publisher in its constructor

    fun subscribe(p : Publisher) {
        s.registerObserver(p)
    }

    fun unsubscribe(p : Publisher) {
        s.removeObserver(p)
    }

    fun printNewsLetter(newsletter: String){
        update(newsletter)
    }

}