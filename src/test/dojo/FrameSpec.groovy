package dojo

import spock.lang.Specification

class FrameSpec extends Specification {
    Frame frame = new Frame()

    def "add roll"(){
        when:
        frame.addRoll(1)
        frame.addRoll(2)
        then:
        frame.rolls[0] == 1
        frame.rolls[1] == 2
    }

    def "is strike true"(){
        when:
        frame.addRoll(10)

        then:
        frame.isStrike()
    }

    def "is strike fail"(){
        when:
        frame.addRoll(5)
        frame.addRoll(5)

        then:
        !frame.isStrike()
    }

    def "is spare pass"(){
        when:
        frame.addRoll(5)
        frame.addRoll(5)

        then:
        frame.isSpare()
    }

    def "is spare fail"(){
        when:
        frame.addRoll(1)
        frame.addRoll(5)

        then:
        !frame.isSpare()
    }

}
