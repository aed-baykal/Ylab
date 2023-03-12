package org.example.complex.number;

public class ComplexNumber {

    private double a;
    private double bi;

    public ComplexNumber(double a) {
        this.a = a;
        this.bi = 0;
    }

    public ComplexNumber(double a, double bi) {
        this.a = a;
        this.bi = bi;
    }

    public ComplexNumber() {
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getBi() {
        return bi;
    }

    public void setBi(double bi) {
        this.bi = bi;
    }

    public ComplexNumber add(ComplexNumber z2) {
        ComplexNumber summ = new ComplexNumber();
        summ.a = this.a + z2.a;
        summ.bi = this.bi + z2.bi;
        return summ;
    }

    public ComplexNumber subtract(ComplexNumber z2) {
        ComplexNumber sub = new ComplexNumber();
        sub.a = this.a - z2.a;
        sub.bi = this.bi - z2.bi;
        return sub;
    }

    public ComplexNumber multiply(ComplexNumber z2) {
        ComplexNumber mult = new ComplexNumber();
        mult.a = this.a * z2.a - this.bi * z2.bi;
        mult.bi = this.a * z2.bi + this.bi * z2.a;
        return mult;
    }

    public double module() {
        return Math.sqrt(this.a * this.a + this.bi * this.bi);
    }

    @Override
    public String toString() {
        String complexNumber;
        if (this.bi < 0) {
            complexNumber = this.a + " - " + (-1 * this.bi) +"i";
        } else {
            complexNumber = this.a + " + " + this.bi +"i";
        }
        return complexNumber;
    }
}
