package org.example.resources;

import java.math.BigInteger;
import java.util.List;


public class FibonacciResponse {
    private List<String> fibonacci;
    private List<String> sorted;

    public FibonacciResponse(List<String> fibonacci, List<String> sorted) {
        this.fibonacci = fibonacci;
        this.sorted = sorted;
    }

    public List<String> getFibonacci() {
        return fibonacci;
    }

    public List<String> getSorted() {
        return sorted;
    }

}