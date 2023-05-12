package sk.stuba.fei.uim.oop.assignment3.product.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.product.logic.IProductService;
import sk.stuba.fei.uim.oop.assignment3.product.web.bodies.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final IProductService productService;

    @Autowired
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<ProductResponse> getAllProducts() {
        List<Product> products = productService.getAll();
        return products.stream()
                .map(ProductResponse::new)
                .collect(Collectors.toList());
    }

    @PostMapping()
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest request) {
        Product product = productService.create(request);
        ProductResponse response = new ProductResponse(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable("id") Long id) {
        Product product = productService.getProductById(id);
        return new ProductResponse(product);
    }

    @PutMapping("/{id}")
    public ProductResponse updateProduct(@PathVariable("id") Long id, @RequestBody UpdateBody updateBody) {
        Product product = productService.updateProduct(id, updateBody);
        return new ProductResponse(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/{id}/amount")
    public AmountResponse getProductAmount(@PathVariable("id") Long id) {
        int amount = productService.getProductAmount(id);
        return new AmountResponse(amount);
    }

    @PostMapping("/{id}/amount")
    public AmountResponse incrementAmount(@PathVariable("id") Long id, @RequestBody AmountRequest amountRequest) {
        int newAmount = productService.incrementAmount(id, amountRequest);
        return new AmountResponse(newAmount);
    }

}
