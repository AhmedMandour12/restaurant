package com.ahmed.restrunt_project.Controller;

import com.ahmed.restrunt_project.service.ServiceImpl.ProductServiceImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductService {
    private final ProductServiceImpl productService;

}
