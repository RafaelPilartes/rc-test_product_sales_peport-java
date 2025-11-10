package com.mycompany.testpaperproductsalesq1;

public class TestPaperProductSalesQ1 {

    public static void main(String[] args) {
        int[][] productSales = {
                {300, 150, 700}, // YEAR 1
                {250, 200, 600}  // YEAR 2
        };
        
        ProductSales ps = new ProductSales();
        
        int total = ps.TotalSales(productSales);
        double average = ps.AverageSales(productSales);
        int max = ps.MaxSale(productSales);
        int min = ps.MinSale(productSales);

        System.out.println("PRODUCT SALES REPORT - 2025");
        System.out.println("------------------------------");
        System.out.println("Total sales:       " + total);
        System.out.println("Average sales:     " + (int) average);
        System.out.println("Maximum sale:      " + max);
        System.out.println("Minimum sale:      " + min);
        System.out.println("------------------------------");
    }
}