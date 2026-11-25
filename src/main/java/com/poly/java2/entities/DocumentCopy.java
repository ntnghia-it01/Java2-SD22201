/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.java2.entities;

/**
 *
 * @author trongnghia
 */
public class DocumentCopy {
    private int id;
    private Document document;
    private String status;

    public DocumentCopy() {
    }

    public DocumentCopy(int id, Document document, String status) {
        this.id = id;
        this.document = document;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}

// Khi khai báo entity mà gặp khoá ngoại
// Chuyển khoá ngoại đó thành đối tượng tương ứng 
// private String documentId => private Document document


//CREATE TABLE [dbo].[document_copies] (
//    [id]          INT          IDENTITY (1, 1) NOT NULL,
//    [document_id] INT          NOT NULL,
//    [status]      VARCHAR (20) CONSTRAINT [DF_document_copies_status] DEFAULT ('GOOD') NOT NULL,
//    CONSTRAINT [PK_document_copies] PRIMARY KEY CLUSTERED ([id] ASC),
//    CONSTRAINT [CK_document_copies_status] CHECK ([status]='LOST' OR [status]='DAMAGED' OR [status]='GOOD'),
//    CONSTRAINT [FK_document_copies_documents] FOREIGN KEY ([document_id]) REFERENCES [dbo].[documents] ([id]) ON DELETE CASCADE
//);
//
//
//GO
//CREATE NONCLUSTERED INDEX [IX_document_copies_document_id]
//    ON [dbo].[document_copies]([document_id] ASC);
//
