/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion4se3.entities;

import java.sql.Date;
/**
 *
 * @author User
 */
public class Culture {
      private int id ;
    private String libelle;
    private Date  datePlantation;
    private Date  dateRecolte;
    private int category_id;
    private String category_type;
    private category category;

    private Double revenuesCultures;
    private Double coutsPlantations;
    private User user;

    public Culture(String libelle, Double coutsPlantations, Double revenuesCultures, Date datePlantation, Date dateRecolte, int category_id) {
        this.libelle = libelle;
        this.datePlantation = datePlantation;
        this.dateRecolte = dateRecolte;
        this.category_id = category_id;
        this.revenuesCultures = revenuesCultures;
        this.coutsPlantations = coutsPlantations;
    }

    public Culture(int id, String libelle, Date datePlantation, Date dateRecolte, int category_id, Double revenuesCultures, Double coutsPlantations) {
        this.id = id;
        this.libelle = libelle;
        this.datePlantation = datePlantation;
        this.dateRecolte = dateRecolte;
        this.category_id = category_id;
        this.revenuesCultures = revenuesCultures;
        this.coutsPlantations = coutsPlantations;
    }
    

    public category getCategory() {
        return category;
    }

    public void setCategory(category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    
    

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Double getRevenuesCultures() {
        return revenuesCultures;
    }

    public void setRevenuesCultures(Double revenuesCultures) {
        this.revenuesCultures = revenuesCultures;
    }

    public Double getCoutsPlantations() {
        return coutsPlantations;
    }

    public void setCoutsPlantations(Double coutsPlantations) {
        this.coutsPlantations = coutsPlantations;
    }

    public Date getDatePlantation() {
        return datePlantation;
    }

    public void setDatePlantation(Date datePlantation) {
        this.datePlantation = datePlantation;
    }

    public Date getDateRecolte() {
        return dateRecolte;
    }

    public void setDateRecolte(Date dateRecolte) {
        this.dateRecolte = dateRecolte;
    }

    public Culture() {
    }

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_type() {
        return category_type;
    }

    public void setCategory_type(String category_type) {
        this.category_type = category_type;
    }

    



}

