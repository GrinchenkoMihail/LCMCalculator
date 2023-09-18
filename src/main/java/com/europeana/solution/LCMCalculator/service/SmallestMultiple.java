package com.europeana.solution.LCMCalculator.service;

import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Setter
public class SmallestMultiple {

    private int limit;
    // Function to find the greatest common divisor (GCD) of two numbers
    private long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // Function to find the least common multiple (LCM) of two numbers
    private long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    // Function to find the smallest number divisible by all numbers from 1 to limit
    public long findSmallestMultiple() {
        long result = 1;
        for (int i = 2; i <= limit; i++) {
            result = lcm(result, i);
        }
        return result;
    }

}
