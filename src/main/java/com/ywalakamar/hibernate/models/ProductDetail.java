package com.ywalakamar.hibernate.models;

public class ProductDetail {
    private Integer productId;
    private String partNumber;
    private float weight;
    private String manufacturer;
    private String origin;
    private Product product;

    public ProductDetail() {
    }

    public ProductDetail(String partNumber, float weight, String manufacturer, String origin) {
        this.partNumber = partNumber;
        this.weight = weight;
        this.manufacturer = manufacturer;
        this.origin = origin;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

}
