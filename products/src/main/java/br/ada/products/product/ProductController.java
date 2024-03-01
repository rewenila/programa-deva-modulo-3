package br.ada.products.product;

import br.ada.products.client.ProductExternal;
import br.ada.products.client.ProductRestClient;
import br.ada.products.client.Products;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    private final ProductRepository productRepository;
    private final ProductRestClient productRestClient;

    public ProductController(ProductRepository productRepository, ProductRestClient productRestClient) {
        this.productRepository = productRepository;
        this.productRestClient = productRestClient;
    }

    @GetMapping("/products")
    public List<Product> findAllExternal() {
        Products result = productRestClient.getAllProducts();

        List<Product> products = new ArrayList<>();

        for (ProductExternal productExternal : result.products()){
            Product newProduct = convert(productExternal);
            productRepository.save(newProduct);
            products.add(newProduct);
        }

        return products;
    }

    @GetMapping("/result")
    public Products findProducts() {
        return productRestClient.getAllProducts();
    }

    private Product convert(ProductExternal productExternal) {
        Product product = new Product();
        product.setTitle(productExternal.title());
        product.setDescription(productExternal.description());
        product.setPrice(productExternal.price());
        product.setStock(productExternal.stock());
        product.setCategory(productExternal.category());
        product.setBrand(productExternal.brand());
        product.setRating(productExternal.rating());
        return product;
    }
}
