import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class Match implements Comparable<Match> {

    private String team1;
    private String team2;
    private int score1;
    private int score2;
    private LocalDate date;

    @Override
    public int compareTo(Match match2) {
        int compareDate = date.compareTo(match2.getDate());

        if (compareDate != 0)
            return compareDate;

        int compareTeam1 = team1.compareTo(match2.getTeam1());
        if (compareTeam1 != 0)
            return compareTeam1;

        return team2.compareTo(match2.getTeam2());
    }
}
