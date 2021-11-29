import com.aor.numbers.GenericListSorter
import com.aor.numbers.ListDeduplicator
import spock.lang.Specification

class ListDeduplicatorGroovyTest extends Specification{

    def "deduplicate"(){
        given:
            def deduplicator = new ListDeduplicator()
            def sorter = Mock(GenericListSorter)
            sorter.sort(_) >>> [Arrays.asList(1, 2, 2, 4)]

        when:
            def aux = sorter.sort(Arrays.asList(1,2,4,2))
            def result = deduplicator.deduplicate2(aux, sorter)
            def expected = [1, 2, 4]

        then:
            result == expected
    }
}
