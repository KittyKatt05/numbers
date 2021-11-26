import com.aor.numbers.GenericListDeduplicator
import com.aor.numbers.ListAggregator
import org.junit.jupiter.api.Assertions
import org.mockito.Mockito
import spock.lang.Specification

class ListAggregatorGroovyTest extends Specification{

    def "distinct_bug_8726"() {
        given:
            def deduplicator = Mock(GenericListDeduplicator)
//            deduplicator.deduplicate(Arrays.asList(1, 2, 4, 2)) >> Arrays.asList(1, 2, 4)
//        deduplicator.deduplicate(_) >> Arrays.asList(1, 2, 4)
        deduplicator.deduplicate(_) >>> [Arrays.asList(1, 2, 4), Arrays.asList(6, 7)]

        when:
            def result = deduplicator.deduplicate(Arrays.asList(1, 2, 4, 2))
        then:
            result == Arrays.asList(1,2,4)

    }

    def "sum"(){
        given:
            def list = [1,2,4,2,5]

        when:
            ListAggregator aggregator = new ListAggregator()
            int result = aggregator.sum(list)

        then:
            result == 14

    }


}
