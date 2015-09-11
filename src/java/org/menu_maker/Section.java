/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.menu_maker;

import java.util.ArrayList;

/**
 *
 * @author alfre_000
 */
public class Section {

    private String name;
    private String description;
    private ArrayList<Dish> dishes;

    public Section() {
        name = null;
        description = null;
    }

    public Section(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void addDish(Dish d) {
        if (getDishes() == null) {
            dishes = new ArrayList<>();
        }
        getDishes().add(d);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the dishes
     */
    public ArrayList<Dish> getDishes() {
        return dishes;
    }
}
