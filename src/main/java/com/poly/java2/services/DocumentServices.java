/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.java2.services;

import com.poly.java2.config.DatabaseConnection;
import com.poly.java2.entities.Document;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author trongnghia
 */

// Dùng để xử lý logic tất cả chức năng của Document
// - Kiểm tra dữ liệu phía user nhập vào
// - Kiểm tra dữ liệu tương thích với DB
// - Xử lý dữ liệu ở DB: SELECT, INSERT, UPDATE, DELETE
public class DocumentServices {
    
//    Phương thức lấy danh sách tất cả tài liệu từ Database
    public static List<Document> getAll(){
        List<Document> documents = new ArrayList<Document>();
        
//        Xử lý lấy dữ liệu từ db để thêm vào danh sách
//        Nếu lấy dữ liệu thành công => Danh sách tài liệu trả về
//        Nếu lấy dữ liệu thất bại => Trả về danh sách rỗng

//        Để xử lý dữ liệu ở DB => Bắt buộc phải viết đoạn xử lý bên trong try catch

        try{
//            Tạo kết nối từ dự án java với sql server
            Connection conn = DatabaseConnection.getConnection();
            
//            Lệnh sql để lấy danh sách tài liệu
            String sql = "SELECT * FROM documents";
            
//            Đựa lệnh vào transaction để chờ thực thi 
            PreparedStatement statement = conn.prepareStatement(sql);
            
//            Đối với các lệnh sql là SELECT 
//            executeQuery() => Thực thi lệnh sql để lấy danh sách từ SELECT 
            ResultSet resultSet = statement.executeQuery();
            
//            Sẽ trả về một danh sách đã lấy được từ sql
//            Duyệt qua từng dòng đã lấy được ở sql để trả về giá trị
//            resultSet.next() == true => Có một dòng dữ liệu cần đọc thông tin
//            resultSet.next() == false => Không có dòng dữ liệu => Kết thúc vòng lặp
            while(resultSet.next()){
//                resultSet.get<Kiểu dữ liệu tương ứng>("<Tên cột cần lấy giá trị>");
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String category = resultSet.getString("category");
                
                Document document = new Document();
                document.setId(id);
                document.setTitle(title);
                document.setAuthor(author);
                document.setCategory(category);
                
                documents.add(document);
            }
            
//            Ngắt kết nối database
            conn.close();
            
        }catch(Exception e){
//            Log nếu có ngoại lệ xảy ra và không làm crash ứng dụng
            e.printStackTrace();
        }
        
        return documents;
    }
    
//    Nếu hàm này trả về true => Thêm thành công
//    Nếu hàm trả về false => Thêm thất bại
    public static boolean addDocument(Document document){
        try{
            Connection conn = DatabaseConnection.getConnection();
            
            String sql = "INSERT INTO documents(title, author, category) VALUES(?, ?, ?)";
            
            PreparedStatement statement = conn.prepareStatement(sql);
            
//            Gán giá trị của document khi người dùng nhập vào câu lệnh sql
//            Số đếm của dấu ? trong câu lệnh bắt đầu từ 1
//            Dùng hàm set tương ứng với kiểu dữ liệu để gán giá trị
            statement.setString(1, document.getTitle());
            statement.setString(2, document.getAuthor());
            statement.setString(3, document.getCategory());
            
//            Đối với INSERT, UPDATE, DELETE => executeUpdate
//            - Hàm này sẽ trả về số dòng đã được cập nhật sau khi chạy lệnh sql xong
//            - Nếu trả về 0 => Không có dòng nào được cập nhật => Câu lệnh chưa được thực thi => Lỗi 
//            - Nếu trả về != 0 => Số lượng dòng ở sql đã được thêm hoặc cập nhật => Thành công
            int rowUpdate = statement.executeUpdate();
            
            return rowUpdate != 0;
//            - Nếu rowUpdate != 0 => Đúng => Hàm sẽ return true;
//            - Nếu rowUpdate != 0 => Sai => Hàm sẽ return false;
            
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
//    Cập nhật tất cả thông tin của tài liệu theo điều kiện là id
//    UPDATE ... SET .... WHERE id=...
    public static boolean updateDocument(Document document){
        try{
            Connection conn = DatabaseConnection.getConnection();
            
            String sql = "UPDATE documents SET title=?, author=?, category=? WHERE id=?";
            
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, document.getTitle());
            statement.setString(2, document.getAuthor());
            statement.setString(3, document.getCategory());
            statement.setInt(4, document.getId());
            
            int rowUpdate = statement.executeUpdate();
            
            return rowUpdate != 0;
                    
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
//    Xây dựng một phương thức
//    Lấy thông tin danh mục ở Database từ id
    public static Document findById(int id){
        try{
            Connection conn = DatabaseConnection.getConnection();
            
            String sql = "SELECT * FROM documents WHERE id=?";
            
            PreparedStatement statement = conn.prepareStatement(sql);
            
//            ? => Ngăn chặn tấn công SQL Injection
//          Chèn các mã sql vào ngay lệnh chỗ nối chuỗi
//          => Dẫn đến lệnh sql luôn đúng


//            SELECT * FROM users WHERE username='abc' AND password=1 OR 1=1
//              <=> SELECT * FROM users

//                username='abc' AND password=1 OR 1=1
//                => FALSE OR TRUE => TRUE

//            username => abc

//            password => 1 OR 1=1
            
            statement.setInt(1, id);
            
            ResultSet resultSet = statement.executeQuery();
            
//            Do đang tìm kiếm theo id => Khoá chính
//            Nếu tìm thấy thì chỉ thấy được một tài liệu duy nhất hoặc không thấy tài liệu nào
//            resultSet.next() == true => Tìm thấy document với id tương ứng
            if(resultSet.next()){
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String category = resultSet.getString("category");
                
                Document document = new Document();
                document.setId(id);
                document.setTitle(title);
                document.setAuthor(author);
                document.setCategory(category);
                
                return document;
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return null;
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

