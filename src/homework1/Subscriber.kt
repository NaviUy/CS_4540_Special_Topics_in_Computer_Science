package homework1

//Subscriber Class that implements Observer
//Subscriber holds and instance of Subject

class Subscriber(s : Subject) : Observer {

    override fun update(newUpdate: String) {
        println("Look new update: $newUpdate")
    }

    //delegating subscribe and unsubscribe to a instance of subject
    //takes publisher in its constructor

    fun subscribe(publisher : String) {
        s.registerObserver(publisher)
    }

    fun unsubscribe(publisher : String) {
        s.removeObserver(publisher)
    }

    fun printNewsLetter(newsletter: String){
        update(newsletter)
    }

}