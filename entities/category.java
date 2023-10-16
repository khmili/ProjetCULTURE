/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion4se3.entities;

/**
 *
 * @author user
 */
public class category {
        private int id ;
        private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public category(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public category() {
    }

    public category(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type ;
    }
}

