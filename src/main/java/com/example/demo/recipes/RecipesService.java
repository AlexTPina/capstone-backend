package com.example.demo.recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipesService {

    @Autowired
    private final RecipesRepository recipesRepository;

    public RecipesService(RecipesRepository recipesRepository) {
        this.recipesRepository = recipesRepository;
    }

    public List<Recipe> getAllRecipes() {
        return this.recipesRepository.findAll();
    }

    public Optional<Recipe> getOneRecipe(int id) {
        return recipesRepository.findById(id);
    }

    public Recipe addOneRecipe(Recipe newRecipe) {
        return recipesRepository.save(newRecipe);
    }

    public Recipe updateOneRecipe(Recipe updatedRecipe) {
        return recipesRepository.save(updatedRecipe);
    }

    public String removeOneRecipe(int id){
        recipesRepository.deleteById(id);
        return "Id " + id + " was removed";
    }
}
