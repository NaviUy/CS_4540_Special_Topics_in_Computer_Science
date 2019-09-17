package homework1

//Subject Interface

interface Subject {
    fun registerObserver(p: String)
    fun removeObserver(p: String)
    fun notifyObserver()
}