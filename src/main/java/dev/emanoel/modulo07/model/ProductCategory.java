package dev.emanoel.modulo07.model;

public class ProductCategory {

    private Integer productCategoryKey;
    private String productCategoryLabel;
    private String productCategoryName;

    public ProductCategory(Integer productCategoryKey, String productCategoryLabel, String productCategoryName) {
        this.productCategoryKey = productCategoryKey;
        this.productCategoryLabel = productCategoryLabel;
        this.productCategoryName = productCategoryName;
    }

    public Integer getProductCategoryKey() {
        return productCategoryKey;
    }

    public String getProductCategoryLabel() {
        return productCategoryLabel;
    }

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public String toString() {
        return String.format("A categoria do produto é: %d, %s, %s",
                this.productCategoryKey, this.productCategoryLabel, this.productCategoryName);
    }
}
