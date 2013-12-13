package main;

import net.egork.chelper.task.Test;
import net.egork.chelper.tester.TestCase;

import java.util.ArrayList;
import java.util.Collection;

public class TaskBTestCase {
    @TestCase
    public Collection<Test> createTests() {
        Collection<Test> tests = new ArrayList<Test>();
        StringBuffer test = new StringBuffer();
        int n = 40;
        int q = 300000;
        test.append(n + " " + n + " " + q + "\n");
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j)
                test.append(0);
            test.append("\n");
        }
        for(int i = 0; i < q; ++i){
            test.append(1 + " " + 1 + " " + n + " " + n + "\n");
        }
        tests.add(new Test(test.toString()));
        return tests;
    }
}
