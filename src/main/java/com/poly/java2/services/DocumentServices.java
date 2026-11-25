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
}
