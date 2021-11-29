import com.aor.numbers.GenericListDeduplicator
import com.aor.numbers.ListAggregator
import org.junit.jupiter.api.Assertions
import org.mockito.Mockito
import spock.lang.Specification
import sun.security.x509.OtherName

class ListAggregatorGroovyTest extends Specification{


    def "sum"(){
        given:
            def list = [1,2,4,2,5]

        when:
            ListAggregator aggregator = new ListAggregator()
            int result = aggregator.sum(list)

        then:
            result == 14

    }

    def "max"(){
        given:
            def list = [1,2,4,2,5]

        when:
            ListAggregator aggregator = new ListAggregator()
            int result = aggregator.max(list);

        then:
            result == 5
    }

    def "max_bug_7263"() {
        given:
            def list = [-1,-4,-5]

        when:
            ListAggregator aggregator = new ListAggregator()
            int result = aggregator.max(list)

        then:
            result == -1
    }

    def "min"() {
        given:
            def list = [1,2,4,2,5]

        when:
            ListAggregator aggregator = new ListAggregator()
            int result = aggregator.min(list)

        then:
            result == 1

    }

    def "distinct_bug_8726"() {
        given:
            def deduplicator = Mock(GenericListDeduplicator)
//          deduplicator.deduplicate(Arrays.asList(1, 2, 4, 2)) >> Arrays.asList(1, 2, 4)
//          deduplicator.deduplicate(_) >> Arrays.asList(1, 2, 4)
            deduplicator.deduplicate(_) >>> [Arrays.asList(1, 2, 4), Arrays.asList(6, 7)]

        when:
            def result = deduplicator.deduplicate(Arrays.asList(1, 2, 4, 2))
        then:
            result == Arrays.asList(1,2,4)

    }

    def "distinct"() {
        given:
            def aggregator = new ListAggregator()
            def deduplicator = Mock(GenericListDeduplicator)
            deduplicator.deduplicate(_) >>> [Arrays.asList(1, 2, 4, 5)]

        when:
            def aux = deduplicator.deduplicate(Arrays.asList(1, 2, 2, 4, 2, 5, 5))
            def distinct = aggregator.distinct(aux, deduplicator)

        then:
            distinct == 4
    }




}
