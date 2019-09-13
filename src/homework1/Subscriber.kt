package homework1

class Subscriber(s : Subject) : Observer, Subject by s {

    override fun update(newUpdate: String) {
        println("Look new update: $newUpdate")
    }


}