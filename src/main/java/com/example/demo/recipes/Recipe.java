package com.example.demo.recipes;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "recipes")
@Data
public class Recipe {

    public Recipe() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String recipeName;

    @Column(columnDefinition = "TEXT")
    private String ingredients;

    @Column(columnDefinition = "TEXT")
    private String preparation;

    @Column(columnDefinition = "TEXT")
    private String cookingInstructions;

    @Column(columnDefinition = "TEXT")
    private String hackNeeded;

    @Column(columnDefinition = "TEXT")
    private String hack;

    public int getId() {
        return id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getPreparation() {
        return preparation;
    }

    public String getCookingInstructions() {
        return cookingInstructions;
    }

    public String getHackNeeded() {
        return hackNeeded;
    }

    public String getHack() {
        return hack;
    }
}