package edu.neu.coe.info6205.finalProject.benchMark;

import java.util.function.Supplier;

public interface Benchmark<T>
{
    /**
     * Run function f m times and return the average time in milliseconds.
     *
     * @param t the value that will in turn be passed to function f.
     * @param m the number of times the function f will be called.
     * @return the average number of milliseconds taken for each run of function f.
     */
    default double run(T t, int m) {
        return runFromSupplier(() -> t, m);
    }

    /**
     * Run function f m times and return the average time in milliseconds.
     *
     * @param supplier a Supplier of a T
     * @param m        the number of times the function f will be called.
     * @return the average number of milliseconds taken for each run of function f.
     */
    double runFromSupplier(Supplier<T> supplier, int m);
}
