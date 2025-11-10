package com.mycompany.testpaperproductsalesq1;

public class ProductSales implements IProduct {
    
    public int TotalSales(int[][] salesData) {
        int total = 0;
        for (int[] period : salesData) {
            for (int saleAmount : period) {
                total += saleAmount;
            }
        }
        return total;
    }

    public double AverageSales(int[][] salesData) {
        int totalCount = 0;
        int totalAmount = TotalSales(salesData);

        for (int[] period : salesData) {
            totalCount += period.length;
        }

        return (double) totalAmount / totalCount;
    }

    public int MaxSale(int[][] salesData) {
        int highestSale = salesData[0][0];

        for (int[] period : salesData) {
            for (int saleAmount : period) {
                if (saleAmount > highestSale) {
                    highestSale = saleAmount;
                }
            }
        }

        return highestSale;
    }

    public int MinSale(int[][] salesData) {
        int lowestSale = salesData[0][0];

        for (int[] period : salesData) {
            for (int saleAmount : period) {
                if (saleAmount < lowestSale) {
                    lowestSale = saleAmount;
                }
            }
        }

        return lowestSale;
    }
}