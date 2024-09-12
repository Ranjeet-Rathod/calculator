package com.example.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.annotation.Timed;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    private final MeterRegistry meterRegistry;

    public CalculatorController(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @GetMapping("/add")
    @Timed(value = "calculator.add.time", description = "Time taken to add")
    public String add(@RequestParam int num1, @RequestParam int num2) {
        int result = num1 + num2;
        meterRegistry.counter("calculator.operations", "operation", "add").increment();
        return "Result: " + result;
    }

    @GetMapping("/subtract")
    @Timed(value = "calculator.subtract.time", description = "Time taken to subtract")
    public String subtract(@RequestParam int num1, @RequestParam int num2) {
        int result = num1 - num2;
        meterRegistry.counter("calculator.operations", "operation", "subtract").increment();
        return "Result: " + result;
    }

    @GetMapping("/multiply")
    @Timed(value = "calculator.multiply.time", description = "Time taken to multiply")
    public String multiply(@RequestParam int num1, @RequestParam int num2) {
        int result = num1 * num2;
        meterRegistry.counter("calculator.operations", "operation", "multiply").increment();
        return "Result: " + result;
    }

    @GetMapping("/divide")
    @Timed(value = "calculator.divide.time", description = "Time taken to divide")
    public String divide(@RequestParam int num1, @RequestParam int num2) {
        if (num2 == 0) {
            return "Error: Division by zero is not allowed.";
        }
        double result = (double) num1 / num2;
        meterRegistry.counter("calculator.operations", "operation", "divide").increment();
        return "Result: " + result;
    }
}
