package com.ywalakamar.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.ywalakamar.hibernate.models.Product;
import com.ywalakamar.hibernate.models.ProductDetail;

public class ProductDao implements DAO<Product> {
    private DataSource ds;

    public ProductDao(DataSource ds) {
        this.ds = ds;
    }

    EntityManagerFactory factory = null;
    EntityManager entityManager = null;

    public void create(Product product) {

        entityManager = ds.getEntityManager();
        entityManager.getTransaction().begin();
        ProductDetail detail = product.getProductDetail();
        /** Set the bi-directional association */
        product.setProductDetail(detail);
        detail.setProduct(product);

        entityManager.persist(product);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public List<Product> findAll() {
        entityManager = ds.getEntityManager();
        entityManager.getTransaction().begin();
        List<Product> results = entityManager.createQuery("from Product", Product.class).getResultList();
        return results;
    }

    @Override
    public Product findOne(int id) {
        entityManager = ds.getEntityManager();
        entityManager.getTransaction().begin();

        Product product = entityManager.find(Product.class, id);
        return product;
    }

    @Override
    public void update(Product product, int id) {
        entityManager = ds.getEntityManager();
        entityManager.getTransaction().begin();

        Product existingProduct = entityManager.find(Product.class, id);
        ProductDetail existingDetail = existingProduct.getProductDetail();
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setProductDescription(product.getProductDescription());
        existingDetail.setManufacturer(product.getProductDetail().getManufacturer());
        existingDetail.setPartNumber(product.getProductDetail().getPartNumber());
        existingDetail.setWeight(product.getProductDetail().getWeight());
        existingDetail.setOrigin(product.getProductDetail().getOrigin());

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void delete(int id) {
    entityManager = ds.getEntityManager();
    entityManager.getTransaction().begin();

    Product product = entityManager.getReference(Product.class, id);
    entityManager.remove(product);
    entityManager.getTransaction().commit();
    entityManager.close();

    }

}
