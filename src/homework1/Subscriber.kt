package homework1

class Subscriber : Observer {
    override fun update(newUpdate: String) {
        println("Look new update: $newUpdate")
    }


}