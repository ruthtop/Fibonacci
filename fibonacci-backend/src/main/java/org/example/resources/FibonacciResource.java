package org.example.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.math.BigInteger;


@Path("/fibonacci")
@Produces(MediaType.APPLICATION_JSON)
public class FibonacciResource {

    @GET
    public FibonacciResponse fibonacci(@QueryParam("elements") int elements) {
        if (elements < 1 || elements > 100) {
            throw new IllegalArgumentException("Invalid input. Please provide a number between 1 and 100.");
        }

        List<String> fibonacciSequence = generateFibonacciSequence(elements);
        List<String> sortedSequence = sortSequence(fibonacciSequence);

        return new FibonacciResponse(fibonacciSequence, sortedSequence);
    }

    private List<String> generateFibonacciSequence(int n) {
        List<BigInteger> sequence = new ArrayList<>();
        if (n >= 1) {
            sequence.add(BigInteger.ZERO);
        }
        if (n >= 2) {
            sequence.add(BigInteger.ONE);
        }
        for (int i = 2; i < n; i++) {
            BigInteger next = sequence.get(i - 1).add(sequence.get(i - 2));
            sequence.add(next);
        }

        // Convert BigInteger values to strings
        List<String> stringSequence = new ArrayList<>();
        for (BigInteger num : sequence) {
            stringSequence.add(num.toString());
        }

        return stringSequence;
    }

    private List<String> sortSequence(List<String> sequence) {
        List<String> evenNumbers = new ArrayList<>();
        List<String> oddNumbers = new ArrayList<>();

        for (String num : sequence) {
            BigInteger value = new BigInteger(num);
            if (value.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
                evenNumbers.add(num);
            } else {
                oddNumbers.add(num);
            }
        }

        Collections.sort(evenNumbers, Collections.reverseOrder());
        Collections.sort(oddNumbers, Collections.reverseOrder());

        List<String> sortedSequence = new ArrayList<>();
        sortedSequence.addAll(evenNumbers);
        sortedSequence.addAll(oddNumbers);

        return sortedSequence;
    }
}
