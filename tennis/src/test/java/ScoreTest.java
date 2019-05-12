import org.junit.Test;


import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.*;

public class ScoreTest {


    @Test
    public void testAccumulateForEachPlayer() {
        Score score = Score.startingScore();
        Score addend = mock(Score.class);
        given(addend.getGamePoints()).willReturn(new int[]{1, 0});
        Score result = score.accumulate(addend);
        given(addend.getGamePoints()).willReturn(new int[]{0, 1});
        result = score.accumulate(addend);
        assertThat(result.getGamePoints()[0], is(equalTo(1)));
        assertThat(result.getGamePoints()[1], is(equalTo(1)));

    }

    @Test
    public void testAccumulateGames() {
        Score score = Score.startingScore();
        Score addend = mock(Score.class);
        given(addend.getGamePoints()).willReturn(new int[]{3, 5});
        Score result = score.accumulate(addend);
        assertThat(result.getGamePoints()[0], is(equalTo(0)));
        assertThat(result.getGamePoints()[1], is(equalTo(0)));
        assertThat(result.getSets()[result.getCurrentSet()][0], is(equalTo(0)));
        assertThat(result.getSets()[result.getCurrentSet()][1], is(equalTo(1)));
    }

    @Test
    public void testAccumulateSets() {
        Score score = Score.startingScore();
        Score addend = mock(Score.class);
        Score result = null;
        for (int i = 0; i < 6; i++) {
            given(addend.getGamePoints()).willReturn(new int[]{3, 5});
            result = score.accumulate(addend);
        }
        assertThat(result.getSets()[0][0], is(equalTo(0)));
        assertThat(result.getSets()[0][1], is(equalTo(6)));
        assertThat(result.getCurrentSet(), is(equalTo(1)));
    }

}
