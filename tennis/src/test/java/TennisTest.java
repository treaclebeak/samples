import org.junit.Test;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;


public class TennisTest {

    @Test
    public void testGame() {
        Stream<Tennis.Event> eventStream = Stream.of(
                new Tennis.Event(Tennis.Action.DOUBLE_FAULT,1),
                new Tennis.Event(Tennis.Action.OUT,0),
                new Tennis.Event(Tennis.Action.WINNER,0),
                new Tennis.Event(Tennis.Action.WINNER,0),
                new Tennis.Event(Tennis.Action.WINNER,1),
                new Tennis.Event(Tennis.Action.WINNER,1),
                new Tennis.Event(Tennis.Action.WINNER,0));
        String s = eventStream.map(Score::processEvent).reduce(Score::accumulate).get().gameScore();
        assertThat(s,equalTo("ADV 40"));
    }
}
