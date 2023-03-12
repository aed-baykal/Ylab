package org.example.stats.accumulator;

public class StatsAccumulatorImpl implements StatsAccumulator {

    private int min = 0;
    private int max = 0;
    private int count = 0;
    private Double avg = 0.0;
    private int summ = 0;

    @Override
    public void add(int value) {
        count++;
        summ = summ + value;
        avg = ((double) summ / count);
        if (count == 1) {
            min = value;
            max = value;
        }
        if (value < min) {
            min = value;
        } else if (value > max) {
            max = value;
        }

    }

    @Override
    public int getMin() {
        return min;
    }

    @Override
    public int getMax() {
        return max;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public Double getAvg() {
        return avg;
    }
}
