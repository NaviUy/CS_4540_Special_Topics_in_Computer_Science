package homework1

    fun main(){
        //instantiate newsletter
        var  ymcmb = newsletterpublisher

        //subscribers
        var mike = Subscriber(ymcmb, "Mike")
        var kevin = Subscriber(ymcmb, "Kevin")
        var esmeralda = Subscriber(ymcmb, "Esmerelda")
        var hector = Subscriber(ymcmb, "Hector")
        var letty = Subscriber(ymcmb, "Letty")

        //register
        mike.subscribe(ymcmb)
        kevin.subscribe(ymcmb)
        esmeralda.subscribe(ymcmb)
        hector.subscribe(ymcmb)
        letty.subscribe(ymcmb)

        //works both ways


//        ymcmb.registerObserver(mike)
//        ymcmb.registerObserver(kevin)
//        ymcmb.registerObserver(esmeralda)
//        ymcmb.registerObserver(hector)
//        ymcmb.registerObserver(letty)

        //update newsletter
        for(i in 1..20){
            //set state
            ymcmb.setState(i)

            //update variable
            val x = ymcmb.x

            //notify
            ymcmb.notifyObserver("Exciting news! We have raised $x million dollars!")

            //remove
            if(x == 3){

                mike.unsubscribe(ymcmb)
                esmeralda.unsubscribe(ymcmb)

                //works both ways you can have the publisher remove the observer

//                ymcmb.removeObserver(mike)
//                ymcmb.removeObserver(esmeralda)
            }

            if(x == 10){

                kevin.unsubscribe(ymcmb)
                hector.unsubscribe(ymcmb)

                //works both ways you can have the publisher remove the observer

//                ymcmb.removeObserver(kevin)
//                ymcmb.removeObserver(hector)
            }
        }

    }