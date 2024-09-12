package com.example.calculator;

import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class RandomNumberService {

    private final Random random = new Random();

    public int[] generateRandomNumbers() {
        int number1 = random.nextInt(100) + 1; // Generates a number between 1 and 100
        int number2 = random.nextInt(100) + 1; // Generates a number between 1 and 100
        return new int[] { number1, number2 };
    }
}
