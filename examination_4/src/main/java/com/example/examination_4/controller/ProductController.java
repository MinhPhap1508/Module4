package com.example.examination_4.controller;

import com.example.examination_4.service.IProductService;
import com.example.examination_4.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private IProductTypeService productTypeService;

    @GetMapping("")
    public String listProduct(@PageableDefault(value = 2,sort = "id",direction = Sort.Direction.DESC) Pageable pageable,
                              @RequestParam(defaultValue = "") String name,
                              @RequestParam(defaultValue = "") String price, Model model){

        model.addAttribute("productList",productService.findAll(name,price,pageable));
        model.addAttribute("name",name);
        model.addAttribute("price",price);
        model.addAttribute("typeList",productTypeService.findAll());
        return "/list";
    }
    @GetMapping("/info/{id}")
    public String detailProduct(@PathVariable Integer id, Model model){
        model.addAttribute("product",productService.findById(id));
        model.addAttribute("typeList",productTypeService.findAll());
        return "/detail";
    }
}
