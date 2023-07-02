package org.example.resources;

import java.math.BigInteger;
import java.util.List;


public class FibonacciResponse {
    private List<BigInteger> fibonacci;
    private List<BigInteger> sorted;

    public FibonacciResponse(List<BigInteger> fibonacci, List<BigInteger> sorted) {
        this.fibonacci = fibonacci;
        this.sorted = sorted;
    }

    public List<BigInteger> getFibonacci() {
        return fibonacci;
    }

    public List<BigInteger> getSorted() {
        return sorted;
    }

}