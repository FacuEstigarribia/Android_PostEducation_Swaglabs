package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.utils;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductsDataProvider {
    @DataProvider(name = "productNames")
    public Object[][] getProductNames() throws IOException {
        List<String> productNames = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/products.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                productNames.add(line);
            }
        }

        return new Object[][] {{productNames}};
    }
}
