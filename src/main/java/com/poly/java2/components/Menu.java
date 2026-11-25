/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.java2.components;

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
                case 1:
                    System.out.println("Chức năng thêm tài liệu");
                    break;
                case 2:
                    System.out.println("Chức năng sửa tài liệu");
                    break;
                case 3:
                    System.out.println("Chức năng xóa tài liệu");
                    break;
                case 4:
                    System.out.println("Chức năng xem danh sách tài liệu");
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
}
