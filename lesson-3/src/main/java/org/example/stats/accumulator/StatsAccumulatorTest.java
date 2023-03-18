package org.example.stats.accumulator;

public class StatsAccumulatorTest {
    public static void main(String[] args) {
        StatsAccumulator accumulator = new StatsAccumulatorImpl();
        accumulator.add(1);
        accumulator.add(2);
        System.out.println(accumulator.getAvg()); // 1.5 - среднее арифметическое элементов
        accumulator.add(0);
        System.out.println(accumulator.getMin()); // 0 - минимальное из переданных значений
        accumulator.add(3);
        accumulator.add(8);
        System.out.println(accumulator.getMax()); // 8 - максимальный из переданных
        System.out.println(accumulator.getCount()); // 5 - количество переданных элементов
    }
}
