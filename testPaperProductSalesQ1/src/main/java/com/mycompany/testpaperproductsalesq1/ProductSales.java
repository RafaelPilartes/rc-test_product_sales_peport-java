package com.mycompany.testpaperproductsalesq1;

public class ProductSales implements IProduct {
    public int TotalSales(int[][] productSales) {
        int totalSales = 0;
        for (int[] row : productSales) {
            for (int sale : row) {
                totalSales += sale;
            }
        }
        return totalSales;
    }

    public double AverageSales(int[][] productSales) {
        int currentCount = 0;
        int totalSales = TotalSales(productSales);

        for (int[] row : productSales) {
            currentCount += row.length;
        }

        return (double) totalSales / currentCount;
    }

    public int MaxSale(int[][] productSales) {
        int maxSale = productSales[0][0];

        for (int[] row : productSales) {
            for (int sale : row) {
                if (sale > maxSale) {
                    maxSale = sale;
                }
            }
        }

        return maxSale;
    }

    public int MinSale(int[][] productSales) {
        int minSale = productSales[0][0];

        for (int[] row : productSales) {
            for (int sale : row) {
                if (sale < minSale) {
                    minSale = sale;
                }
            }
        }

        return minSale;
    }
}
