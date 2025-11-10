package com.mycompany.testpaperproductsalesq1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestPaperProductSalesQ1Test {
    @Test
    public void CalculateTotalSales_ReturnsTotalSales() {
        // Declaration Array
        int[][] productSalesData = {
            {1000, 2000},
            {1500, 2500}
        };
        ProductSales sales = new ProductSales();

        // Act
        int result = sales.TotalSales(productSalesData);

        // Assert
        assertEquals(7000, result, "Total sales should be 7000");
    }

    @Test
    public void AvarageSales_ReturnsAverageProductSales() {
        // Declaration Array
        int[][] productSalesData = {
            {1000, 2000},
            {1500, 2500}
        };
        ProductSales sales = new ProductSales();

        double result = sales.AverageSales(productSalesData);
        // Assert test
        assertEquals(1750.0, result, 0.01, "Average sales should be 1750.0");
    }
}