package com.example.productthymeleaf.controller;

import com.example.productthymeleaf.model.Product;
import com.example.productthymeleaf.service.IProductService;
import com.example.productthymeleaf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping
    public String showList(Model model) {
        List<Product> productList = productService.displayAll();
        model.addAttribute("list", productList);
        return "/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.addProduct(product);
        redirectAttributes.addFlashAttribute("message","Thêm mới thành công");
        return "redirect:/product";
    }

    @GetMapping("/remove")
    public String remove(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.remove(product.getId());
        redirectAttributes.addFlashAttribute("message"," Xóa thành công");
        return "redirect:/product";
    }

    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.getByID(id));
        return "/update";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        productService.updateProduct(product.getId(),product);
        redirectAttributes.addFlashAttribute("message","Chỉnh sửa thành công");
        return "redirect:/product";
    }
    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model){
        model.addAttribute("product",productService.getByID(id));
        return "/view";
    }
    @GetMapping("/search")
    public String search(@RequestParam String name, Model model){
        List<Product> productList = productService.search(name);
        model.addAttribute("product", productList);
        return "/search";
    }

}
