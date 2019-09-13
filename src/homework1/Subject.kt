package homework1

//Subject Interface

interface Subject {
    fun registerObserver(p : Publisher)
    fun removeObserver(p : Publisher)
    fun notifyObserver()
}