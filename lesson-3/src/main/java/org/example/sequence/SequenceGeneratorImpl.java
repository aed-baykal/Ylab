package org.example.sequence;

public class SequenceGeneratorImpl implements SequenceGenerator {
    private long element;
    private int indicator;

    @Override
    public void a(int n) {
        for (int i = 1; i <= n; i++) {
            element = 2L * i;
            System.out.println(element);
        }
    }

    @Override
    public void b(int n) {
        for (int i = 1; i <= n; i++) {
            element = 2L * i - 1L;
            System.out.println(element);
        }
    }

    @Override
    public void c(int n) {
        for (int i = 1; i <= n; i++) {
            element = (long) i * i;
            System.out.println(element);
        }
    }

    @Override
    public void d(int n) {
        for (int i = 1; i <= n; i++) {
            element = (long) i * i * i;
            System.out.println(element);
        }
    }

    @Override
    public void e(int n) {
        element = -1L;
        for (int i = 1; i <= n; i++) {
            element = -element * element * element;
            System.out.println(element);
        }
    }

    @Override
    public void f(int n) {
        indicator = -1;
        for (int i = 1; i <= n; i++) {
            indicator = -indicator * indicator * indicator;
            element = (long) indicator * i;
            System.out.println(element);
        }
    }

    @Override
    public void g(int n) {
        indicator = -1;
        for (int i = 1; i <= n; i++) {
            indicator = -indicator * indicator * indicator;
            element = (long) i * i * indicator;
            System.out.println(element);
        }
    }

    @Override
    public void h(int n) {
        for (int i = 3; i <= n + 2; i++) {
            element = (i % 2L) * i / 2L;
            System.out.println(element);
        }

//        Еще один вариант
//        for (int i = 1; i <= n; i++) {
//            element = (long) Math.abs((Math.sin(Math.PI * i / 2) * (i * 0.5 + 1)));
//            System.out.println(element);
//        }

    }

    @Override
    public void i(int n) {
        element = 1L;
        for (int i = 1; i <= n; i++) {
            element = element * i;
            System.out.println(element);
        }
    }

    @Override
    public void j(int n) {
        if (n == 1) {
            System.out.println(1);
        } else if (n == 2) {
            System.out.println(1);
            System.out.println(1);
        } else {
            element = 1L;
            long elementNMinus1;
            long elementNMinus2 = 1L;
            System.out.println(1);
            System.out.println(1);
            for (int i = 3; i <= n; i++) {
                elementNMinus1 = element;
                element = elementNMinus1 + elementNMinus2;
                elementNMinus2 = elementNMinus1;
                System.out.println(element);
            }
        }
    }
}
