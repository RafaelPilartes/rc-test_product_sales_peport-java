package com.mycompany.testpaperproductsalesq2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestPaperProductSalesQ2Test {
    @Test
    void GetSalesOverLimit_ReturnsNumberOfSales() {
        ProductSales productSales = new ProductSales();
        // Act
        int result = productSales.GetSalesOverLimit();
        // Assert
        assertEquals(2, result);  // According to the data in the statement:
    }

    @Test
    void GetSalesUnderLimit_ReturnsNumberOfSales() {
        ProductSales productSales = new ProductSales();
        // Act
        int result = productSales.GetSalesUnderLimit();
        // Assert
        assertEquals(2, result); // 2 sales <= 500
    }
}
