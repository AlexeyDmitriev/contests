package main;

import net.egork.chelper.task.Test;
import net.egork.chelper.tester.TestCase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class TaskDTestCase {
    @TestCase
    public Collection<Test> createTests() {
        Collection<Test> tests = new ArrayList<Test>();
        StringBuilder sb = new StringBuilder();
        sb.append("50 50 50\n");
        sb.append("ASDFGHJKL\n");
        Random random = new Random();
        for(int i = 0; i < 50; ++i) {
            for(int j = 0; j < 50; ++j) {
                sb.append((char)(random.nextInt(26) + 'A'));
            }
            sb.append("\n");
        }
        tests.add(new Test(sb.toString()));
        return tests;
    }
}
