package main;

import net.egork.chelper.task.Test;
import net.egork.chelper.tester.TestCase;

import java.util.ArrayList;
import java.util.Collection;

public class TaskCTestCase {
    @TestCase
    public Collection<Test> createTests() {
        Collection<Test> result = new ArrayList<Test>();
        StringBuffer sb = new StringBuffer();
        sb.append(1000).append("\n");
        sb.append("2 ");
        for(int i = 1; i < 1000; ++i) {
            sb.append("-1 ");
        }
        result.add(new Test(sb.toString()));
        return result;

    }
}
