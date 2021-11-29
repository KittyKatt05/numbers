import com.aor.numbers.ListSorter
import spock.lang.Specification

class ListSorterGroovyTest extends Specification{

    def "sort"(){
        given:
            def list = [1, 2, 4, 2]

        when:
            def sorter = new ListSorter()
            def sorted = sorter.sort(list)
            def expected = [1, 2, 2, 4]

        then:
            sorted == expected
    }
}
