package main;

import name.admitriev.spsl.collections.Pair;
import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

public class TaskB {
    class Student implements Comparable<Student> {
        long skill;
        long needs;
        int id;

        Student(long skill, long needs, int id) {
            this.skill = skill;
            this.needs = needs;
            this.id = id;
        }


        @Override
        public int compareTo(Student o) {
            if(skill != o.skill)
                return Long.compare(o.skill, skill);
            return Integer.compare(id, o.id);
        }
    }
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        long s = in.nextInt();
        long[] a = in.nextLongArray(m);
        long[] b = in.nextLongArray(n);
        long[] c = in.nextLongArray(n);

        ArrayList<Pair<Long, Integer>> bugs = new ArrayList<Pair<Long, Integer>>();
        ArrayList<Student> students = new ArrayList<Student>();
        for(int i = 0; i < n; ++i) {
            students.add(new Student(b[i], c[i], i));
        }
        for(int i = 0; i < m; ++i) {
            bugs.add(new Pair<Long, Integer>(a[i], i));
        }
        Collections.sort(bugs, Collections.reverseOrder());
        Collections.sort(students);
        int l = 0, r = m + 1;
        Comparator<Student> BY_NEEDS = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.needs != o2.needs) {
                    return Long.compare(o1.needs, o2.needs);
                }
                return Integer.compare(o1.id, o2.id);
            }
        };
        int[] res = new int[m];
        while(r - l > 1) {
            int d = (l + r) / 2;
            int start = 0;
            TreeSet<Student> mayWork = new TreeSet<Student>(BY_NEEDS);

            boolean ok = true;
            long sum = 0;
            for(int i = 0; i < m; i += d) {
                for(; start != n && students.get(start).skill >= bugs.get(i).first; ++ start) {
                    mayWork.add(students.get(start));
                }

                if(mayWork.isEmpty()) {
                    ok = false;
                    break;
                }
                else {
                    Student cheap = mayWork.first();
                    mayWork.remove(cheap);
                    sum += cheap.needs;
                    for(int j = i; j < i + d && j < m; ++j) {
                        res[bugs.get(j).second] = cheap.id + 1;
                    }
                }

            }

            if(ok && sum <= s) {
                r = d;
            }
            else
                l = d;



        }

        if(r == m + 1) {
            out.println("NO");

        }
        else {
            out.println("YES");

            {
                int d = r;
                int start = 0;
                TreeSet<Student> mayWork = new TreeSet<Student>(BY_NEEDS);

                boolean ok = true;
                long sum = 0;
                for(int i = 0; i < m; i += d) {
                    for(; start != n && students.get(start).skill >= bugs.get(i).first; ++ start) {
                        mayWork.add(students.get(start));
                    }

                    if(mayWork.isEmpty()) {
                        ok = false;
                        break;
                    }
                    else {
                        Student cheap = mayWork.first();
                        mayWork.remove(cheap);
                        sum += cheap.needs;
                        for(int j = i; j < i + d && j < m; ++j) {
                            res[bugs.get(j).second] = cheap.id + 1;
                        }
                    }

                }

            }
            for(int i = 0; i < m; ++i) {
                out.print(res[i] + " ");
            }


        }
    }
}
