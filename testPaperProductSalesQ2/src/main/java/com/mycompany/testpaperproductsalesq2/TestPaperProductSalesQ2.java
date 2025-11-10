package com.mycompany.testpaperproductsalesq2;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestPaperProductSalesQ2 extends JFrame {
     // UI components (descriptive names)
    private final JButton btnLoadProductData;
    private final JButton btnSaveProductData;
    private final JTextArea txtReportArea;
    private final JLabel lblYearsProcessed;


    // Logic
    private final ProductSales productSalesManager = new ProductSales();

    public TestPaperProductSalesQ2() {
        super("Product Sales Application");

        // Window settings
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(480, 360);
        setLocationRelativeTo(null); // Centers the window

        // ---------- Menu Bar ----------
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenu toolsMenu = new JMenu("Tools");

        JMenuItem menuItemExit = new JMenuItem("Exit");
        menuItemExit.addActionListener(e -> System.exit(0));

        JMenuItem menuItemLoad = new JMenuItem("Load Product Data");
        JMenuItem menuItemSave = new JMenuItem("Save Product Data");
        JMenuItem menuItemClear = new JMenuItem("Clear");

        // Items reuse the same methods as the buttons
        menuItemLoad.addActionListener(e -> loadProductData());
        menuItemSave.addActionListener(e -> saveProductData());
        menuItemClear.addActionListener(e -> clearReport());

        fileMenu.add(menuItemExit);
        toolsMenu.add(menuItemLoad);
        toolsMenu.add(menuItemSave);
        toolsMenu.add(menuItemClear);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);

        // ---------- Top buttons panel ----------
        btnLoadProductData = new JButton("Load Product Data");
        btnSaveProductData = new JButton("Save Product Data");

        btnLoadProductData.addActionListener(e -> loadProductData());
        btnSaveProductData.addActionListener(e -> saveProductData());

        JPanel topButtonsPanel = new JPanel();
        topButtonsPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        topButtonsPanel.add(btnLoadProductData, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        topButtonsPanel.add(btnSaveProductData, gbc);

        // ---------- Report text area ----------
        txtReportArea = new JTextArea();
        txtReportArea.setEditable(false);
        txtReportArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        JScrollPane reportScrollPane = new JScrollPane(txtReportArea);

        // ---------- Bottom status (Years Processed) ----------
        lblYearsProcessed = new JLabel("Years Processed: 0");
        lblYearsProcessed.setBorder(BorderFactory.createEmptyBorder(6, 6, 6, 6));

        // ---------- Layout main ----------
        // I use BorderLayout: topButtonsPanel (NORTH), reportScrollPane (CENTER), lblYearsProcessed (SOUTH)
        Container content = getContentPane();
        content.setLayout(new BorderLayout(8, 8));
        content.add(topButtonsPanel, BorderLayout.NORTH);
        content.add(reportScrollPane, BorderLayout.CENTER);
        content.add(lblYearsProcessed, BorderLayout.SOUTH);

        setVisible(true);
    }

    // Formats average to rounded integer
    private String formatAverage(double avg) {
        // Rounds to the nearest integer
        long rounded = Math.round(avg);
        return Long.toString(rounded);
    }

    // Loads the data and fills the text area
    private void loadProductData() {
        txtReportArea.setText("");

        int totalSales = productSalesManager.GetTotalSales();
        double averageSales = productSalesManager.GetAverageSales();
        int salesOverLimit = productSalesManager.GetSalesOverLimit();
        int salesUnderLimit = productSalesManager.GetSalesUnderLimit();
        int yearsProcessed = productSalesManager.GetProductsProcessed();

        // Assembles report
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Total Sales: %d%n", totalSales));
        sb.append(String.format("Average Sales: %s%n", formatAverage(averageSales)));
        sb.append(String.format("Sales over limit: %d%n", salesOverLimit));
        sb.append(String.format("Sales under limit: %d%n", salesUnderLimit));

        txtReportArea.setText(sb.toString());
        lblYearsProcessed.setText("Years Processed: " + yearsProcessed);
    }

    // Saves the report to a Data.txt file
    private void saveProductData() {
        int totalSales = productSalesManager.GetTotalSales();
        double averageSales = productSalesManager.GetAverageSales();
        int salesOverLimit = productSalesManager.GetSalesOverLimit();
        int salesUnderLimit = productSalesManager.GetSalesUnderLimit();

        String filePath = System.getProperty("user.dir") + File.separator + "data.txt";
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("DATA LOG\n");
            writer.write("**************************\n");
            writer.write("Total Sales: " + totalSales + "\n");
            writer.write("Average Sales: " + formatAverage(averageSales) + "\n");
            writer.write("Sales over limit: " + salesOverLimit + "\n");
            writer.write("Sales under limit: " + salesUnderLimit + "\n");
            writer.write("**************************\n");
            writer.flush();

            JOptionPane.showMessageDialog(this, "Report saved to Data.txt", "Saved", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Clears the report area and the label
    private void clearReport() {
        txtReportArea.setText("");
        lblYearsProcessed.setText("Years Processed: 0");
    }

    public static void main(String[] args) {
        // Adjusts the system's look & feel (optional)
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        SwingUtilities.invokeLater(TestPaperProductSalesQ2::new);
    }
}
