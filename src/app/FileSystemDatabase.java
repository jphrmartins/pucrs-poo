package app;

import entities.*;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileSystemDatabase implements SystemDatabase {
    private static final String STOCK_FILE_NAME = "stock.txt";
    private static final String SALES_FILE_NAME = "sales.txt";

    @Override
    public SystemDependencies loadSystem() {
        Stock stock = new Stock(this, getStock());
        SalesBase salesBase = new SalesBase(this, this.getSalesBase());
        return new SystemDependencies(stock, salesBase);
    }

    private Map<Integer, Sale> getSalesBase() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(SALES_FILE_NAME)));
            return bufferedReader.lines()
                    .map(it -> it.split(";"))
                    .map(this::buildSale)
                    .collect(Collectors.toMap(Sale::getId, Function.identity()));
        } catch (FileNotFoundException e) {
            System.err.println("Could not find file " + SALES_FILE_NAME + " on the root, will return an empty sales");
            return new HashMap<>();
        }
    }

    @Override
    public void updateStockItems(Map<String, Product> products) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(STOCK_FILE_NAME)));

            for (Map.Entry<String, Product> entry : products.entrySet()) {
                Product value = entry.getValue();
                String product = value.getDescription() + ";" + value.getPrice() + ";"
                        + value.getBarCode() + ";" + value.getAmount();
                bufferedWriter.write(product);
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            System.err.println("Error trying to update stock items, will terminate system");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateSalesBase(Map<Integer, Sale> sales) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(SALES_FILE_NAME)));
            for (Map.Entry<Integer, Sale> entry : sales.entrySet()) {
                Sale value = entry.getValue();
                String items = value.getItems().stream().map(it ->
                        it.getDescription() + "|" + it.getPrice() + "|"
                                + it.getBarCode() + "|" + it.getAmount()
                ).collect(Collectors.joining("?"));
                String sale = value.getStatus().name() + ";" + value.getDiscountPercent() + ";" + items;
                bufferedWriter.write(sale);
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            System.err.println("Error trying to update sales, will terminate system");
            throw new RuntimeException(e);
        }
    }

    private Map<String, Product> getStock() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(STOCK_FILE_NAME)));
            return bufferedReader.lines()
                    .map(it -> it.split(";"))
                    .map(this::buildProduct)
                    .collect(Collectors.toMap(Product::getBarCode, Function.identity()));
        } catch (FileNotFoundException e) {
            System.err.println("Could not find file " + STOCK_FILE_NAME + " on the root, will return an empty stock");
            return new HashMap<>();
        }
    }

    private Sale buildSale(String[] splitedSale) {
        String[] splittedItems = splitedSale[2].split("\\?");
        List<Product> items = Stream.of(splittedItems)
                .map(it -> it.split("\\|"))
                .map(this::buildProduct)
                .collect(Collectors.toList());
        return new Sale(SaleStatus.valueOf(splitedSale[0]), Double.parseDouble(splitedSale[1]), items);
    }

    private Product buildProduct(String[] it) {
        return new Product(it[0], Double.parseDouble(it[1]), it[2], Integer.parseInt(it[3]));
    }
}
