package org.example.lr3_model;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

public class HelloController {
    private final int seed=21*1000;
    private final int count=10000;
    @FXML
    private LineChart<Number, Number> lineChart;
    @FXML
    private void initialize(){
        Generator generator = new Generator(seed);
        double[] values = generator.generate(count);
        displayNumbers(values);
        plotGraph(values);
        evaluateGenerator(values);
    }

    private void displayNumbers(double[] values) {
        System.out.println("Згенеровані псевдовипадкові числа:");
        for (int i = 0; i < values.length; i++) {
            System.out.printf("%5d: %8.2f\n", i + 1, values[i]);
            if (i % 10 == 9) {
                System.out.println();
            }
        }
    }
    private void plotGraph(double[] values) {
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("Псевдовипадкові числа");

        for (int i = 1; i < values.length; i++) {
            if ((i + 1) % 100 == 1) {  // Перше число кожного десятка (9981, 9991, 10000)
                XYChart.Data<Number, Number> data = new XYChart.Data<>(i + 1, values[i]);
                series.getData().add(data);
            }
        }

        // Очищаємо старі дані і додаємо нову серію
        lineChart.getData().clear();
        lineChart.getData().add(series);
    }
    private void evaluateGenerator(double[] values) {
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        double sum = 0;
        double sumSquares = 0;
        for (double value : values) {
            if (value < min) min = value;
            if (value > max) max = value;
            sum += value;
            sumSquares += value * value;
        }
        double mean = sum / values.length;
        double variance = (sumSquares / values.length) - (mean * mean);
        double stdDeviation = Math.sqrt(variance);
        System.out.println("Якість генератора:");
        System.out.printf("Мінімальне значення: %.2f\n", min);
        System.out.printf("Максимальне значення: %.2f\n", max);
        System.out.printf("Середнє значення: %.2f\n", mean);
        System.out.printf("Стандартне відхилення: %.2f\n", stdDeviation);
    }
}
