package homework1

//Subject Interface

interface Subject {

    fun registerObserver(s: Subscriber)
    fun removeObserver(s: Subscriber)
    fun notifyObserver(s: String)

}
