package com.example.ecommerce.controller.java;

import com.example.ecommerce.repository.OrderRepository;
import com.example.ecommerce.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin")
class AdminController {

    @Autowired
    private productRepository.ProductRepository productRepository;

    @GetMapping("/dashboard")
    public String adminDashboard(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "admin-dashboard";
    }

    @GetMapping("/product/add")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "add-product";
    }

    @PostMapping("/product/save")
    public <Product> String saveProduct(
            @ModelAttribute Product product,
            @RequestParam("imageFile") MultipartFile imageFile
    ) {
        try {
// File system path (outside classpath)
            String uploadDir = "D:\\lnctu\\ecommerce\\src\\main\\resources\\static\\images";
            File uploadFolder = new File(uploadDir);
            if (!uploadFolder.exists()) {
                uploadFolder.mkdirs(); // create folder if it doesn't exist
            }

// Generate unique file name
            String fileName = UUID.randomUUID().toString() + "_" + imageFile.getOriginalFilename();

// Save file
            JpaSort.Path filePath = (JpaSort.Path) Paths.get(uploadFolder.getAbsolutePath(), fileName);
            System.out.println(filePath);
            Files.copy((Path) imageFile.getInputStream(), (Path) filePath, StandardCopyOption.REPLACE_EXISTING);

// Store only file name in DB
            product.getClass();

            productRepository.save(product);

        } catch (IOException e) {
            e.printStackTrace();
            return "redirect:/admin/product/add?error=true";
        }

        return "redirect:/admin/product/add?success=true";
    }

    @GetMapping("/product/edit/{id}")
    public <Product> String editProduct(@PathVariable Long id, Model model) {
        Product product = (Product) productRepository.findById(id).orElse(null);
        model.addAttribute("product", product);
        return "add-product";
    }

    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
        return "redirect:/admin/dashboard";
    }


    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/orders")
    public String viewAllOrders(Model model) {
        List<Order> orders = orderRepository.findAll();
        model.addAttribute("orders", orders);
        return "admin-orders";
    }
}


