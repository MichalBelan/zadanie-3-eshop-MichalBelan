package sk.stuba.fei.uim.oop.assignment3.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.product.IProductRepository;
import sk.stuba.fei.uim.oop.assignment3.product.IProductService;
import sk.stuba.fei.uim.oop.assignment3.product.Product;
import sk.stuba.fei.uim.oop.assignment3.product.ProductRequest;

import java.util.List;

@Service
public class ProductService implements IProductService {

    public IProductRepository repository;

    @Autowired
    public ProductService(IProductRepository repository){
        this.repository = repository;


    }


    @Override
    public List<Product> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Product createProduct(ProductRequest request) {

        Product newProduct = new Product();

        newProduct.setName(request.getName());
        newProduct.setDescription(request.getDescription());
        newProduct.setAmount(request.getAmount());
        newProduct.setUnit(request.getUnit());
        newProduct.setPrice(request.getPrice());

        return this.repository.save(newProduct);

    }

    @Override
    public Product getAllById(Long id) {
        return this.repository.findById(id).orElseThrow();
    }

    @Override
    public Product updateProduct(Long productId,ProductRequest request ) {

        Product productToFind = this.repository.findById(productId).orElseThrow();

        if(request.getDescription() != null) {
            productToFind.setDescription(request.getDescription());
        }

        if(request.getName() != null){
            productToFind.setName(request.getName());
        }
        return this.repository.save(productToFind);
    }

    @Override
    public  void deleteProductById(Long id) {

        this.repository.findById(id).orElseThrow();

        this.repository.deleteById(id);

    }


    @Override
    public Product increaseAmount(Long id, ProductRequest request) {
        Product productToFind = this.repository.findById(id).orElseThrow();
        productToFind.setAmount(productToFind.getAmount()+request.getAmount());
        return this.repository.save(productToFind);
    }

    @Override
    public void decreaseAmount(Long id, int amount) {
        Product productToFind = this.repository.findById(id).orElseThrow();
        productToFind.setAmount(productToFind.getAmount() - amount);
        this.repository.save(productToFind);
    }

    @Override
    public Product getById(long productId) {
        return this.repository.findById(productId).orElseThrow();
    }

}
