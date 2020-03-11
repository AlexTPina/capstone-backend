package com.example.demo.recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/recipes")
public class RecipesController {

    @Autowired
    private final RecipesService recipesService;

    public RecipesController(RecipesService recipesService) {
        this.recipesService = recipesService;
    }

    @GetMapping
    public List<Recipe> getAllRecipes() {
        return this.recipesService.getAllRecipes();
    }

    @GetMapping("/{id}")
    public Recipe getOneRecipe(@PathVariable int id) {
        Recipe recipe = recipesService.getOneRecipe(id).orElseThrow(IllegalArgumentException::new);
        return recipe;
    }

    @PostMapping
    public Recipe addOneRecipe(@RequestBody Recipe newRecipe) {
        if(newRecipe.getRecipeName() == null || newRecipe.getHack() == null){
            throw new IllegalArgumentException("Not all fields are valid. Go back and make sure all fields are valid " +
                    "before API call is made.");
        }
        return recipesService.addOneRecipe(newRecipe);
    }

    @PatchMapping
    public Recipe updateOneRecipe(@RequestBody Recipe updatedRecipe) {
        Recipe recipe = recipesService.getOneRecipe(updatedRecipe.getId()).orElseThrow(IllegalArgumentException::new);
        return recipesService.updateOneRecipe(updatedRecipe);
    }

    @DeleteMapping("/{id}")
    public String removeOneRecipe(@PathVariable int id) {
        Recipe recipe = recipesService.getOneRecipe(id).orElseThrow(IllegalArgumentException::new);
        return recipesService.removeOneRecipe(id);
    }
}
