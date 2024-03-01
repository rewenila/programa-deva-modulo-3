package br.ada.products.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "productRest", url = "${client.dummy.url}")
public interface ProductRestClient {

    @GetMapping("/products")
    Products getAllProducts();

    @GetMapping("/categories")
    Products getAllCategories();

}
