import java.util.*;
import java.util.stream.IntStream;

import static java.time.LocalDate.now;

public class Main {

    public static void main(String[] args) {
//        exemploAlteracaoAtributoStatic();
        exemploProblemaComparableTreeSet();
    }

    private static void exemploAlteracaoAtributoStatic() {
        var classeQualquer = new ClasseQualquer();
        IntStream.rangeClosed(1, 100).forEach(classeQualquer::add);
        //(1 + 100)*100/2 = 101 * 50 = 5050
        System.out.println("Valor da classe qualquer: " + classeQualquer.getValor());

        var novaInstanciaClasseQualquer = new ClasseQualquer();
        System.out.println("Valor da nova instancia: " + novaInstanciaClasseQualquer.getValor());
    }

    private static void exemploProblemaComparableTreeSet() {
        List<Match> matches = List.of(
                Match.builder().team1("SPO").team2("COR").score1(5).score2(1).date(now()).build(),
                Match.builder().team1("SPO").team2("FLA").score1(1).score2(1).date(now()).build(),
                Match.builder().team1("SPO").team2("GRE").score1(2).score2(1).date(now()).build(),
                Match.builder().team1("INT").team2("GRE").score1(2).score2(2).date(now()).build(),
                Match.builder().team1("INT").team2("SAN").score1(2).score2(1).date(now()).build(),
                Match.builder().team1("SAN").team2("SPO").score1(2).score2(1).date(now()).build()
        );

//        Set<Match> matchTreeSet = new TreeSet<>(matches); //Comparable
//        Set<Match> matchTreeSet = new TreeSet<>(Comparator.comparing(Match::getDate)
//                .thenComparing(Match::getTeam1)
//                .thenComparing(Match::getTeam2));
        Set<Match> matchTreeSet = new TreeSet<>();
        matches.forEach(match -> matchTreeSet.add(match));
        System.out.println("Size antes: " + matches.size());
        System.out.println("Size depois: " + matchTreeSet.size());
    }
}
