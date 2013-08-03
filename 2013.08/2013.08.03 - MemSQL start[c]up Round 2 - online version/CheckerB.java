package main;

import net.egork.chelper.tester.Verdict;
import net.egork.chelper.checkers.Checker;

public class CheckerB implements Checker {
    public CheckerB(String parameters) {
    }

    public Verdict check(String input, String expectedOutput, String actualOutput) {
        if(expectedOutput == null)
            return Verdict.UNDECIDED;

        return trim(actualOutput).length() == trim(expectedOutput).length() ? Verdict.OK : Verdict.WA;
    }

    private String trim(String expectedOutput) {
        if(expectedOutput.charAt(expectedOutput.length() - 1) == '\n')
            return trim(expectedOutput.substring(0, expectedOutput.length() - 1));
        return expectedOutput;
    }
}
