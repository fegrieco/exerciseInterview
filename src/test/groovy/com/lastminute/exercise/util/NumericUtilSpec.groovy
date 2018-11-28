package com.lastminute.exercise.util

import spock.lang.Specification

class NumericUtilSpec extends Specification {

    def "test for  rounding up rules for sales tax"(){
        given:
        double valueWithMoreDecimal = 54.625
        when:
        double valueRound = NumericUtil.roundOff(valueWithMoreDecimal)
        then:
        valueRound == 54.65
    }

    def "test for  rounding down rules for sales tax"(){
        given:
        double valueWithMoreDecimal = 0.5625
        when:
        double valueRound = NumericUtil.roundOff(valueWithMoreDecimal)
        then:
        valueRound == 0.6
    }
}
