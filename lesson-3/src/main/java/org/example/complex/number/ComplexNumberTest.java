package org.example.complex.number;

public class ComplexNumberTest {
    public static void main(String[] args) {
        ComplexNumber z1  = new ComplexNumber(2, 3);
        ComplexNumber z2  = new ComplexNumber(-1, 3);
        ComplexNumber z3  = new ComplexNumber(3, -2);
        ComplexNumber z4  = new ComplexNumber(4);

        System.out.println(z1.add(z2));
        System.out.println(z3.add(z2));
        System.out.println(z4.add(z3));
        System.out.println(z1.add(z1));
        System.out.println("_______________");
        System.out.println(z1.subtract(z2));
        System.out.println(z3.subtract(z2));
        System.out.println(z4.subtract(z3));
        System.out.println(z1.subtract(z1));
        System.out.println("_______________");
        System.out.println(z1.multiply(z2));
        System.out.println(z3.multiply(z2));
        System.out.println(z4.multiply(z3));
        System.out.println(z1.multiply(z1));
        System.out.println("_______________");
        System.out.println(z1.module());
        System.out.println(z2.module());
        System.out.println(z3.module());
        System.out.println(z4.module());
    }
}
