package dev.emanoel.modulo06.model;

public class Product {

    private Integer productKey;
    private String productName;
    private String brandName;
    private String colorName;

    public Product(String productName, String brandName, String colorName) {
        this.productName = productName;
        this.brandName = brandName;
        this.colorName = colorName;
    }

    public String getProductName() {
        return productName;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getColorName() {
        return colorName;
    }

    public void setProductKey(Integer productKey) {
        this.productKey = productKey;
    }

    public String toString() {
        return String.format("O produto criado foi: %d, %s, %s, %s",
                this.productKey, this.productName, this.brandName, this.colorName);
    }
}
