package com.ywalakamar.hibernate;

import com.ywalakamar.hibernate.models.Product;
import com.ywalakamar.hibernate.models.ProductDetail;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {

		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		try {
			ProductDao dao = context.getBean(ProductDao.class, "productDao");

			/** Create product */
			Product product = context.getBean(Product.class, "product");
			dao.create(product);

			/** Fetch one product */
			System.out.println(dao.findOne(66));

			/** Fetch all products */
			for (Product prod : dao.findAll()) {
				System.out.println(prod);
			}

			/** Update product */
			Product p = new Product("Avocadoes", "Gorilla Avocadoes", 4000);
			ProductDetail pd = new ProductDetail("AV23M", 1, "Townsend Farms", "Congo");
			pd.setProduct(p);
			p.setProductDetail(pd);
			dao.update(p, 69);

			/** Delete product */
			dao.delete(52);

		} catch (Exception e) {
			((ClassPathXmlApplicationContext) context).close();
		}

	}
}