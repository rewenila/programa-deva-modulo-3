package br.ada.products.client;

import java.util.List;

public record ProductExternal(
        Long id,
        String title,
        String description,
        Double price,
        Double discountPercentage,
        Double rating,
        Long stock,
        String brand,
        String category,
        String thumbnail,
        List<String> images
) {
}
