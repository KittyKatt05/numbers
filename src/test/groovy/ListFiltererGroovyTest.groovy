import com.aor.numbers.DivisibleByFilter
import com.aor.numbers.GenericListFilter
import com.aor.numbers.ListFilterer
import com.aor.numbers.PositiveFilter
import org.mockito.Mockito
import spock.lang.Specification

class ListFiltererGroovyTest extends Specification{

    def "filterPositive"() {
        given:
            def list = [-5, 1, 0, 2, 10, -8]
            def positiveFilter = Mock(PositiveFilter)
            def lsf = new ListFilterer(positiveFilter)
            positiveFilter.accept(_) >>> [false, true, false, true, true, false]

        when:
            def distinct = lsf.filter(list)
            def expected = [1, 2, 10]

        then:
            distinct == expected
    }

    def "filterDivisibleBy"() {
        given:
            def list = [8, 4, 0, -2, -6, -9, 5, 3]
            def divisbleByFilter = Mock(DivisibleByFilter)
            def lsf = new ListFilterer(divisbleByFilter)
            divisbleByFilter.accept(_) >>> [true, true, true, true, true, false, false, false]

        when:
            def distinct = lsf.filter(list)
            def expected = [8, 4, 0, -2, -6]

        then :
            distinct == expected
    }
}
