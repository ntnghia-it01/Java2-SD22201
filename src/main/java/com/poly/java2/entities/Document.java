/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.java2.entities;

/**
 *
 * @author trongnghia
 */
// Đối tượng tưng ứng với bảng của database được gọi là
// Entity
public class Document {
    private int id;
    private String title;
    private String author;
    private String category;

    public Document() {
    }

    public Document(int id, String title, String author, String category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    
    
}


//CREATE TABLE [dbo].[documents] (
//    [id]       INT            IDENTITY (1, 1) NOT NULL,
//    [title]    NVARCHAR (255) NOT NULL,
//    [author]   NVARCHAR (150) NOT NULL,
//    [category] NVARCHAR (100) NOT NULL,
//    CONSTRAINT [PK_DOCUMENT] PRIMARY KEY CLUSTERED ([id] ASC)
//);
//
