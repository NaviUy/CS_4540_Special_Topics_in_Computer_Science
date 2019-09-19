package homework1

//Concrete Observer
//Subscriber Class that implements Observer
//Subscriber holds and instance of Subject

class Subscriber(var publisher: newsletterpublisher, var name: String = "Default Name") : Observer {

    override fun update(newUpdate: String) {
        printNewsletter("$name: " + newUpdate);
    }

    //delegating subscribe and unsubscribe to a instance of subject
    //takes publisher in its constructor

    fun subscribe(publisher2: newsletterpublisher) = publisher2.registerObserver(this)

    fun unsubscribe(publisher2: newsletterpublisher) = publisher2.removeObserver(this)

    fun printNewsletter(s: String){
        println(s)
    }

}