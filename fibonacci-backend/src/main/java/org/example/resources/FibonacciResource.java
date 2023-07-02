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

        List<BigInteger> fibonacciSequence = generateFibonacciSequence(elements);
        List<BigInteger> sortedSequence = sortSequence(fibonacciSequence);

        return new FibonacciResponse(fibonacciSequence, sortedSequence);
    }

    private List<BigInteger> generateFibonacciSequence(int n) {
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
        return sequence;
    }

    private List<BigInteger> sortSequence(List<BigInteger> sequence) {
        List<BigInteger> evenNumbers = new ArrayList<>();
        List<BigInteger> oddNumbers = new ArrayList<>();

        for (BigInteger num : sequence) {
            if (num.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
                evenNumbers.add(num);
            } else {
                oddNumbers.add(num);
            }
        }

        Collections.sort(evenNumbers, Collections.reverseOrder());
        Collections.sort(oddNumbers, Collections.reverseOrder());

        List<BigInteger> sortedSequence = new ArrayList<>();
        sortedSequence.addAll(evenNumbers);
        sortedSequence.addAll(oddNumbers);

        return sortedSequence;
    }
}
