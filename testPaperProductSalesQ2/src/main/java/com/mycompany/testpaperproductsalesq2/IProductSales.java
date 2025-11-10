package com.mycompany.testpaperproductsalesq2;

public interface IProductSales {
    int [][] GetProductSales();
    int GetTotalSales();
    int GetSalesOverLimit();
    int GetSalesUnderLimit();
    int GetProductsProcessed();
    double GetAverageSales();
}
