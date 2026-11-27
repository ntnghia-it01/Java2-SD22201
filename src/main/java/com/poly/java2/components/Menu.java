/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.java2.components;

import com.poly.java2.entities.Document;
import com.poly.java2.services.DocumentServices;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author trongnghia
 */
public class Menu {
    private final Scanner scanner = new Scanner(System.in);

    public void hienThi() {
        int luaChon;

        do {
            System.out.println("\n========== QUẢN LÝ THƯ VIỆN ==========");
            System.out.println("1.  Thêm tài liệu");
            System.out.println("2.  Sửa tài liệu");
            System.out.println("3.  Xóa tài liệu");
            System.out.println("4.  Xem danh sách tài liệu");
            System.out.println("5.  Thêm bản sao");
            System.out.println("6.  Sửa trạng thái bản sao");
            System.out.println("7.  Xóa bản sao");
            System.out.println("8.  Xem bản sao theo tài liệu");
            System.out.println("9.  Tìm kiếm tài liệu");
            System.out.println("10. Sắp xếp tài liệu");
            System.out.println("11. Xem tài liệu theo trang");
            System.out.println("12. Thêm nhiều bản sao");
            System.out.println("13. Cập nhật trạng thái nhiều bản sao");
            System.out.println("14. Thống kê");
            System.out.println("15. Lưu và đọc dữ liệu từ file");
            System.out.println("0.  Thoát");
            System.out.println("======================================");

            luaChon = nhapLuaChon();

            switch (luaChon) {
                case 1:{
                    System.out.println("Chức năng thêm tài liệu");
                    Document document = this.enterInfo();
                    boolean check = DocumentServices.addDocument(document);
                    if(check){
                        System.out.println("Thêm tài liệu thành công");
                    }else{
                        System.out.println("Thêm tài liệu thất bại");
                    }
                    break;
                }
                case 2:{
                    System.out.println("Chức năng sửa tài liệu");
                    System.out.println("Tìm tài liệu cần sửa");
//                  Cho người dùng nhập vào id của tài liệu có kiểm tra theo quy ước
                    int id = this.enterId();
//                  Tìm tài liệu theo id vừa nhập xem có trong db hay không?
                    Document documentCheck = DocumentServices.findById(id);
                    
                    if(documentCheck == null){
                        System.out.println("Tài liệu không tồn tại. Không thể sửa.");
                        break;
                    }
                    
                    System.out.println("Đã tìm thấy tài liệu. Vui lòng nhập nội dung cần sửa");
//                  Cho người dùng nhập thông tin của tài liệu có kiểm tra theo quy ước
                    Document document = this.enterInfo();
//                  Thông tin ở đây không có id
//                  Nhưng khi sửa sẽ cần id để sửa
//                  Nên sẽ set thêm id vào đối tượng document trước khi thực hiện sửa
                    document.setId(id);
                    
                    boolean check = DocumentServices.updateDocument(document);
                    if(check){
                        System.out.println("Cập nhật tài liệu thành công");
                    }else{
                        System.out.println("Cập nhật tài liệu thất bại");
                    }
                    break;
                }
                case 3:
                    System.out.println("Chức năng xóa tài liệu");
                    break;
                case 4:
                    System.out.println("Chức năng xem danh sách tài liệu");
                    this.showDocumentList(DocumentServices.getAll());
                    break;
                case 5:
                    System.out.println("Chức năng thêm bản sao");
                    break;
                case 6:
                    System.out.println("Chức năng sửa trạng thái bản sao");
                    break;
                case 7:
                    System.out.println("Chức năng xóa bản sao");
                    break;
                case 8:
                    System.out.println("Chức năng xem bản sao theo tài liệu");
                    break;
                case 9:
                    System.out.println("Chức năng tìm kiếm tài liệu");
                    break;
                case 10:
                    System.out.println("Chức năng sắp xếp tài liệu");
                    break;
                case 11:
                    System.out.println("Chức năng xem tài liệu theo trang");
                    break;
                case 12:
                    System.out.println("Chức năng thêm nhiều bản sao");
                    break;
                case 13:
                    System.out.println("Chức năng cập nhật trạng thái nhiều bản sao");
                    break;
                case 14:
                    System.out.println("Chức năng thống kê");
                    break;
                case 15:
                    System.out.println("Chức năng lưu và đọc dữ liệu từ file");
                    break;
                case 0:
                    System.out.println("Đã thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (luaChon != 0);
    }

    private int nhapLuaChon() {
        while (true) {
            System.out.print("Nhập lựa chọn: ");
            String input = scanner.nextLine();

            try {
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số nguyên.");
            }
        }
    }
    
    private void showDocumentList(List<Document> documents){
        for(Document document : documents){
            System.out.printf("Mã tài liệu: %d\n", document.getId());
            System.out.printf("Tên tài liệu: %s\n", document.getTitle());
            System.out.printf("Tác giả tài liệu: %s\n", document.getAuthor());
            System.out.printf("Danh mục tài liệu: %s\n", document.getCategory());
            System.out.println("============================================");
        }
    }
    
//    Cho người dùng nhập thông tin của tài liệu 
//    Cho người dùng nhập lần lượt thông tin của tài liệu và có kiểm tra lỗi
//    Nếu phát sinh lỗi ở bất kỳ dữ liệu nào sẽ yêu cầu nhập lại
//    - Tiêu đề không rỗng và phải có ít nhất 2 từ
//      - Ví dụ: Sách Java == 2 từ => Đúng, Sách == 1 từ => Sai nhập lại
//    - Tên tác giả không rỗng
//    - Danh mục không rỗng
//    Sau khi nhập xong sẽ gán giá trị vào đối tượng document
    private Document enterInfo(){
        Scanner scanner = new Scanner(System.in);
        Document document = new Document();
        while(true){
            System.out.print("Nhập tiêu đề tài liệu: ");
            String title = scanner.nextLine();
//            Hàm để loại bỏ khoản trắng dư ở hai đầu nội dung
//            => " sách java    " => "sách java"
//            Hàm chuyển đổi chuỗi thành mảng và được cắt ra từ ký tự space " "
//            => "sách java" => ["sách", "java"]
//            Đếm số phần tử của mảng nếu từ 2 trở lên là có hai từ 

//            .trim()=> Bỏ khoản trắng 2 đầu
//            .split(" ") => Chuyển chuỗi thành mảng cắt ra từ nội dung ??
            if(title.trim().split(" ").length >= 2){
//              Thoả điều kiện 
                document.setTitle(title);
                break;
            }
            System.out.println("Nhập tiêu đề sai. Nhập lại");
        }
        
        while(true){
            System.out.print("Nhập tên tác giả: ");
            String author = scanner.nextLine();
//            .isBlank() => "     " => Rỗng => True => Không rỗng
//            .isEmpty() => "     " => Có ký tự => False => Không bỏ trống
            if(!author.isBlank()){
                document.setAuthor(author);
                break;
            }
            System.out.println("Nhập tên tác giả sai. Nhập lại");
        }
        
        while(true){
            System.out.print("Nhập danh mục: ");
            String category = scanner.nextLine();

            if(!category.isBlank()){
                document.setCategory(category);
                break;
            }
            System.out.println("Nhập danh mục sai. Nhập lại");
        }
        
        return document;
    }
    
//    Cho người dùng nhập vào Id
//    Kiểm tra các điều kiện sau nếu sai nhập lại
//    - Id phải là số
//    - Id phải lớn hơn 0
//    Nếu nhập đúng thì return về giá trị của id
    private int enterId(){
        while(true){
            Scanner scanner = new Scanner(System.in);
            
            System.out.print("Nhập ID: ");
            String idString = scanner.nextLine();
            
            try{
                int id = Integer.parseInt(idString);
                
                if(id > 0){
                    return id;
                }
            }catch(Exception e){
//                e.printStackTrace();
            }
            
            System.out.println("ID phải là số nguyên dương. Nhập lại!");
        }
    }
}
