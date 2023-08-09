package com.example.springbootjunitdemo.service;

public class Calculator {

    public int multiplie(int x, int y) {
        return x * y;
    }

    public double divide(int x, int y) {
        try {
            return x / y;
        } catch (ArithmeticException ex) {
            throw ex;
        }

    }
}
