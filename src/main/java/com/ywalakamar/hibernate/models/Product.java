package com.ywalakamar.hibernate.models;

public class Product {
    private int productId;
    private String name;
    private String productDescription;
    private float price;
    private ProductDetail productDetail;

    public Product() {
    }

    public Product(String name, String desc, float price) {
        this.name = name;
        this.productDescription = desc;
        this.price = price;
    }

    public ProductDetail getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetail productDetail) {
        this.productDetail = productDetail;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return productId + ". Name: " + name + ", Desc: " + productDescription + ", Part No. "
                + productDetail.getPartNumber() + ", Weight: " + productDetail.getWeight() + ", Manufacturer: "
                + productDetail.getManufacturer() + ", Origin: " + productDetail.getOrigin();
    }

}
