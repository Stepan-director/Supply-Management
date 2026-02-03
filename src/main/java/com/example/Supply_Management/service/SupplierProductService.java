package com.example.Supply_Management.service;

import com.example.Supply_Management.model.Product;
import com.example.Supply_Management.model.Supplier;
import com.example.Supply_Management.model.SupplierProduct;
import com.example.Supply_Management.repository.ProductRepository;
import com.example.Supply_Management.repository.SupplierProductRepository;
import com.example.Supply_Management.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierProductService {

    @Autowired
    private SupplierProductRepository supplierProductRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private ProductRepository productRepository;

    public SupplierProduct addProductToSupplier(Long supplierId, Long productId, Double  price) {
        Supplier supplier = supplierRepository.findById(supplierId).orElseThrow(()
                -> new RuntimeException("Не удалось найти поставщика с данным ID " + supplierId));

        Product product = productRepository.findById(productId).orElseThrow(()
                -> new RuntimeException("Не удалось найти товар с данным ID " + productId));

        SupplierProduct supplierProduct = new SupplierProduct();
        supplierProduct.setSupplierId(supplierId);
        supplierProduct.setSupplierName(supplier.getName());
        supplierProduct.setProductId(productId);
        supplierProduct.setProductName(product.getName());
        supplierProduct.setProductType(product.getType());
        supplierProduct.setVariety(product.getVariety());
        supplierProduct.setPrice(price);
        supplierProduct.setMeasureUnit("кг");

        return supplierProductRepository.save(supplierProduct);
    }

    public List<SupplierProduct> getSupplierPrices(){
        return supplierProductRepository.findAll();
    }

    public List<SupplierProduct> getProductSuppliers(String productName){
        return supplierProductRepository.findByProductName(productName);
    }

/*    public SupplierProduct getBestPrice(){

    }*/

    public SupplierProduct updatePrice(Long id, Double  newPrice) {
        SupplierProduct supplierProduct = supplierProductRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Запись о цене не найдена"));

        supplierProduct.setPrice(newPrice);
        return supplierProductRepository.save(supplierProduct);
    }
}
