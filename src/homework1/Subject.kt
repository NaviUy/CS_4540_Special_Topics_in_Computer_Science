package homework1

//Subject Interface

interface Subject {
    fun registerObserver(publisher : String)
    fun removeObserver(publisher : String)
    fun notifyObserver()
}