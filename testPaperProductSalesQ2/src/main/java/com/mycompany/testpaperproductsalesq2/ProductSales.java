package com.mycompany.testpaperproductsalesq2;

import com.mycompany.testpaperproductsalesq2.model.Data;

public class ProductSales {
    private final int salesLimit = 500;
    
    public int[][] GetProductSales() {
        return Data.productSales;
    }

    public int GetTotalSales() {
        int total = 0;
        for (int[] row : Data.productSales) {
            for (int value : row) {
                total += value;
            }
        }
        return total;
    }

    public double GetAverageSales() {
        int total = GetTotalSales();
        int count = 0;

        for (int[] row : Data.productSales) {
            count += row.length;
        }

        return (double) total / count;
    }

    public int GetSalesOverLimit() {
        int count = 0;
        for (int[] row : Data.productSales) {
            for (int value : row) {
                if (value > salesLimit)
                    count++;
            }
        }
        return count;
    }

    public int GetSalesUnderLimit() {
        int count = 0;
        for (int[] row : Data.productSales) {
            for (int value : row) {
                if (value <= salesLimit)
                    count++;
            }
        }
        return count;
    }

    public int GetProductsProcessed() {
        return Data.productSales.length;
    }
}
