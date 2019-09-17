package homework1

//Concrete Observer
//Subscriber Class that implements Observer
//Subscriber holds and instance of Subject

class Subscriber(publisher:String = "Default Publisher", name:String = "Default Name") : Observer, s by Subject {

    override fun update(newUpdate: String) {
        println("Look new update: $newUpdate")
        printNewsletter(newUpdate);
    }

    //delegating subscribe and unsubscribe to a instance of subject
    //takes publisher in its constructor

    fun subscribe(){

        s.registerObserver(publisher)

    }

    fun unsubscribe(){

        s.removeObserver(publisher)

    }

    fun printNewsletter(s: String){

        println(s)
    }



}