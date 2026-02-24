package hh.sof3.bookstore.web;

import hh.sof3.bookstore.domain.CategoryRepository;
import hh.sof3.bookstore.domain.Category;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.ui.Model;

@Controller
public class CategoryController {

    private final CategoryRepository categoryRepository;

    CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // category list from database
    @GetMapping("/categorylist")
    public String getCategories(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "categorylist"; // addcategory.html
    }

    // add new category (form)
    @GetMapping("/addcategory")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());

        return "addcategory"; // addcategory.html
    }

    // save category
    @PostMapping("/savecategory")
    public String saveCategory(@ModelAttribute Category category) {
        categoryRepository.save(category);
        return "redirect:categorylist"; // categorylist.html
    }

    // delete category
    @GetMapping("/deletecategory/{id}")
    public String deleteCategory(@PathVariable("id") Long categoryid, Model model) {
        categoryRepository.deleteById(categoryid);
        return "redirect:../categorylist";
    }

}
