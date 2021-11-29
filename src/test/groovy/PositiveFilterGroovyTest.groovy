import com.aor.numbers.PositiveFilter
import spock.lang.Specification

class PositiveFilterGroovyTest extends Specification{

    def "accept"() {
        given:
            def number = 5
            def numberN = -5

        when:
            def psf = new PositiveFilter()
            def result = psf.accept(number)
            def resultN = psf.accept(numberN)

        then:
            result == true
            resultN == false
    }
}
