import com.aor.numbers.DivisibleByFilter
import spock.lang.Specification

class DivisibleByFilterGroovyTest extends Specification{

    def "accept"() {
        given:
            def div = 3
            def number = 12
            def number1 = 10

        when:
            def dbf = new DivisibleByFilter(div)
            def result = dbf.accept(number);
            def result1 = dbf.accept(number1)

        then:
            result == true
            result1 == false
    }
}
