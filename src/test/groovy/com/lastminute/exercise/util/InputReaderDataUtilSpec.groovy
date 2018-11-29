package com.lastminute.exercise.util

import spock.lang.Specification

class InputReaderDataUtilSpec extends Specification {

    def "read file from resource"(){
        when:
        List<String> linesFromFile = InputReaderDataUtil.readFileLineByLine("ShoppingBasket1.txt")
        then:
        linesFromFile.size()== 4
        linesFromFile.get(0).equals("Input 1:")
        linesFromFile.get(1).equals("1 book at 12.49")
        linesFromFile.get(2).equals("1 music CD at 14.99")
        linesFromFile.get(3).equals("1 chocolate bar at 0.85")
    }


    def "read input info from json"(){
        given:
        String jsonInput = "{\n" +
                "\t\"shopping_basket\": [\"Input 1\",\"1 book at 12.49\",\"1 music CD at 14.99\",\"1 chocolate bar at 0.85\"]\t\t\t\t  \n" +
                "}"
        when:
        List<String> linesFromFile = InputReaderDataUtil.readerFromJson(jsonInput)
        then:
        linesFromFile.size()== 4
        linesFromFile.get(0).equals("Input 1")
        linesFromFile.get(1).equals("1 book at 12.49")
        linesFromFile.get(2).equals("1 music CD at 14.99")
        linesFromFile.get(3).equals("1 chocolate bar at 0.85")
    }
}
