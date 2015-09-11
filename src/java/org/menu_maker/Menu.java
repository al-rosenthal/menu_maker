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
public class Menu {

    private String name;
    private ArrayList<Section> sections;

    public Menu() {
        name = "Menu";
        sections = null;
    }

    public Menu(String name) {
        this.name = name;
        sections = null;
    }

    public void addSection(Section s) {
        if (getSections() == null) {
            sections = new ArrayList<>();
        }
        getSections().add(s);
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
     * @return the sections
     */
    public ArrayList<Section> getSections() {
        return sections;
    }
}
