package sk.stuba.fei.uim.oop.assignment3.product.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.web.bodies.AmountRequest;
import sk.stuba.fei.uim.oop.assignment3.product.web.bodies.ProductRequest;
import sk.stuba.fei.uim.oop.assignment3.product.web.bodies.UpdateBody;
import sk.stuba.fei.uim.oop.assignment3.product.data.IProductRepository;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;

import java.util.List;

@Service
public class ProductService implements IProductService {

    private IProductRepository repository;

    @Autowired
    public ProductService(IProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }

    @Override
    public Product create(ProductRequest request) {
        Product product = new Product();
        updateProductFromRequest(product, request);
        return repository.save(product);
    }

    @Override
    public Product getProductById(Long id) {
        return repository.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public Product updateProduct(Long id, UpdateBody updateBody) {
        Product product = repository.findById(id)
                .orElseThrow(NotFoundException::new);
        if (updateBody.getName() != null) {
            product.setName(updateBody.getName());
        }
        if (updateBody.getDescription() != null) {
            product.setDescription(updateBody.getDescription());
        }
        return repository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = repository.findById(id)
                .orElseThrow(NotFoundException::new);
        repository.delete(product);
    }

    @Override
    public int getProductAmount(Long id) {
        Product product = repository.findById(id)
                .orElseThrow(NotFoundException::new);
        return product.getAmount();
    }

    @Override
    public int incrementAmount(Long id, AmountRequest amountRequest) {
        Product product = repository.findById(id)
                .orElseThrow(NotFoundException::new);
        product.setAmount(product.getAmount() + amountRequest.getAmount());
        repository.save(product);
        return product.getAmount();
    }

    private void updateProductFromRequest(Product product, ProductRequest request) {
        product.setUnit(request.getUnit());
        product.setId(request.getId());
        product.setPrice(request.getPrice());
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setAmount(request.getAmount());
    }

}
