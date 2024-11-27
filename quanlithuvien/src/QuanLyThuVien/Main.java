import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static danhSachNhanSu dsnd = new danhSachNhanSu();
    private static danhSachTaiLieu dstl = new danhSachTaiLieu(); 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 5) {
            System.out.println("----------------------HE THONG QUAN LY THU VIEN----------------------");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("=== MENU CHINH ===");
            System.out.println("1. Quan ly Nguoi dung");
            System.out.println("2. Quan ly Tai lieu");
            System.out.println("3. Quan ly Hoa don");
            System.out.println("4. Thoat");
            System.out.println("---------------------------------------------------------------------");
            System.out.print("Lua chon cua ban: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    quanLyNhanSu();
                    break;

                case 2:
                    quanLyTaiLieu();
                    break;

                case 3:
                    // Chức năng quản lý hóa đơn (bổ sung sau)
                    break;

                case 4:
                    System.out.println("Da thoat khoi chuong trinh. Tam biet!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le, vui long thu lai!");
                    break;
            }
        }
    }

    private static void quanLyNhanSu() {
        Scanner sc = new Scanner(System.in);
    	int subChoice = 0;
        do {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("=== QUAN LY NHAN SU ===");
            System.out.println("1. Them nhan su");
            System.out.println("2. Xoa nhan su");
            System.out.println("3. Sua nhan su");
            System.out.println("4. Tim kiem nhan su");
            System.out.println("5. Muon tai lieu");
            System.out.println("6. Hien thi danh sach nhan su");
            System.out.println("7. Hien thi tai lieu da muon");
            System.out.println("8. Doc danh sach tu file txt");
            System.out.println("9. Ghi danh sach tu file txt");
            System.out.println("10. Quay lai menu chinh");
            System.out.println("---------------------------------------------------------------------");
            System.out.print("Lua chon cua ban la: ");
            subChoice = sc.nextInt();
            sc.nextLine();
            switch (subChoice) {
                case 1:
                    System.out.print("Nhap loai nhan su (1. Nhan vien, 2. Doc gia, 3. Lua chon khac): ");
                    int typeChoice = sc.nextInt();
                    sc.nextLine(); 
                    System.out.println("---------------------------------------------------------------------");

                    if (typeChoice == 1) {
                        Employee nhanVien = new Employee();
                        System.out.print("Nhap ID nhan vien: ");
                        String ID = sc.nextLine();
                        boolean check = true;
                        for (Person p : dsnd.getlistofperson()) {
                        	if (p.getid().equals(ID)) {
                        		check = false;
                        		System.out.println("ID nay da duoc dung");
                        		break;
                        	}
                        }
                        if (check == true) {
                            nhanVien.setid(ID);
                            nhanVien.nhap();
                            dsnd.them(nhanVien);

                        }
                    } else if(typeChoice == 2){
                    	
                        Reader docGia = new Reader();
                        System.out.print("Nhap ID doc gia: ");
                        String ID = sc.nextLine();
                        boolean check = true;
                        for (Person p : dsnd.getlistofperson()) {
                        	if (p.getid().equals(ID)) {
                        		check = false;
                        		System.out.println("ID nay da duoc dung");
                        		break;
                        	}
                        }
                        if (check == true) {
                        	docGia.setid(ID);
                        	docGia.nhap();
                            dsnd.them(docGia);
                        }
                        
                        
                    } else {
                        Person p = new Person();
                        p.nhap();
                        dsnd.them(p);
                    }
                    break;

                case 2:
                    System.out.print("Nhap ID nhan su can xoa: ");
                    dsnd.xoa(sc.nextLine());
                    break;

                case 3:
                    System.out.print("Nhap ID nhan su can sua: ");
                    dsnd.sua(sc.nextLine());
                    break;

                case 4:
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Chon kieu tim kiem:");
                    System.out.println("1. Tim theo ten");
                    System.out.println("2. Tim theo ID");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.print("Lua chon cua ban: ");
                    int searchChoice = sc.nextInt();
                    sc.nextLine();

                    switch (searchChoice) {
                        case 1:
                            System.out.print("Nhap ten nhan su: ");
                            String searchName = sc.nextLine();
                            dsnd.searchbyname(searchName);
                            break;
                        case 2:
                            System.out.print("Nhap ID nhan su: ");
                            String searchId = sc.nextLine();
                            dsnd.searchbyid(searchId);
                            break;
                        default:
                            System.out.println("Lua chon khong hop le!");
                    }
                    break;
                
                case 5:/*
                	System.out.print("Nhap ID nguoi muon: ");
                    String IDmuon = sc.nextLine();
                    Person reader = dsnd.searchbyid(IDmuon);
                    if (reader != null) {
                        System.out.print("Nhap ID cua tai lieu can muon: ");
                        String IDtailieumuon = sc.nextLine();
                        for (Document doc : dstl.getDSTL()) {
                        	if (IDtailieumuon.equals(doc.getId())) {
                        		if (doc != null && doc.getSoluong() > 0) {
                                    reader.muonTaiLieu(doc);
                                    doc.setSoluong(doc.getSoluong() - 1);
                                    System.out.println("Da muon tai lieu thanh cong!");
                                } else {
                                    System.out.println("Tai lieu khong ton tai hoac da het.");
                                }
                            }
                        }
                    } else {
                        System.out.println("Khong tim thay nguoi muon voi ID da nhap.");
                    }
                    break;*/
                case 6:
                    dsnd.xuatDanhSachNhanSu();
                    break;
                
                case 7:
                    System.out.print("Nhap ID nguoi muon: ");
                    String ID = sc.nextLine();
                    Person personToCheck = dsnd.searchbyid(ID);

                    if (personToCheck != null) {
                        Person readerToCheck = personToCheck;
                        readerToCheck.hienThiDanhSachMuon();
                    } else {
                        System.out.println("Khong tim thay nguoi voi ID da nhap.");
                    }
                    break;
                    
                case 8:
                    try {
                        dsnd.docTuFile("input_NS.txt");
                    } catch (IOException e) {
                        System.out.println("Loi khi doc file: " + e.getMessage());
                    }
                    break;
                case 9:
    				dsnd.ghiVaoFile("output_NV.txt", "output_DG.txt"); // thay output_nhanvien.txt và output_docgia.txt bằng đường dẫn dến file để ghi thông tin nhân viên và đọc giả
                    break;
                case 10:
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (subChoice != 10);
}


    private static void quanLyTaiLieu() {
        danhSachTaiLieu dstl = new danhSachTaiLieu();
        Scanner sc = new Scanner(System.in);
        int subChoice;

        do {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("=== QUAN LY TAI LIEU ===");
            System.out.println("1. Them tai lieu");
            System.out.println("2. Xoa tai lieu");
            System.out.println("3. Sua tai lieu");
            System.out.println("4. Tim kiem tai lieu");
            System.out.println("5. Hien thi danh sach tai lieu");
            System.out.println("6. Doc danh sach tu file txt");
            System.out.println("7. Ghi danh sach tu file txt");
            System.out.println("8. Quay lai menu chinh");
            System.out.println("---------------------------------------------------------------------");
            System.out.print("Lua chon cua ban la: ");
            subChoice = sc.nextInt();
            sc.nextLine();

            switch (subChoice) {
                case 1:
                    System.out.println("Nhap loai tai lieu (1. Sach, 2. Tap chi, 3. Dia, 4. Lua chon khac): ");
                    int typeChoice = sc.nextInt();
                    sc.nextLine(); 
                    System.out.println("---------------------------------------------------------------------");

                    if (typeChoice == 1) {
                        Book book = new Book();
                        book.nhap();
                        dstl.them(book);
                    } else if(typeChoice == 2){
                        Magazine tapChi = new Magazine();
                        tapChi.nhap();
                        dstl.them(tapChi);
                    } else if(typeChoice == 3){
                        Dia dia = new Dia();
                        dia.nhap();
                        dstl.them(dia);
                    } else {
                        Document doc = new Document();
                        doc.nhap();
                        dstl.them(doc);
                    }
                    break;

                case 2:
                    System.out.print("Nhap ID tai lieu can xoa: ");
                    String tenXoa = sc.nextLine();
                    dstl.xoa(tenXoa);
                    break;

                case 3:
                    System.out.print("Nhap ID tai lieu can sua: ");
                    String tenSua = sc.nextLine();
                    dstl.sua(tenSua);
                    break;

                case 4:
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Chon kieu tim kiem:");
                    System.out.println("1. Tim theo ten");
                    System.out.println("2. Tim theo ID");
                    System.out.println("3. Tim theo nam xuat ban");
                    System.out.println("4. Tim theo tac gia");
                    System.out.println("5. Tim theo the loai");
                    System.out.println("6. Tim theo ma (Sach)");
                    System.out.println("7. Tim theo so phat hanh(Tap Chi)");
                    System.out.println("8. Tim theo ma (Dia)");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.print("Lua chon cua ban: ");
                    int searchChoice = sc.nextInt();
                    sc.nextLine();

                    switch (searchChoice) {
                        case 1:
                            System.out.print("Nhap ten tai lieu: ");
                            String searchName = sc.nextLine();
                            dstl.searchbyName(searchName);
                            break;
                        case 2:
                            System.out.print("Nhap ID tai lieu: ");
                            String searchId = sc.nextLine();
                            dstl.searchbyID(searchId);
                            break;
                        case 3:
                            System.out.print("Nhap nam xuat ban: ");
                            int searchYear = sc.nextInt();
                            dstl.searchbyYear(searchYear);
                            break;
                        case 4:
                            System.out.print("Nhap ten tac gia: ");
                            String searchAuthor = sc.nextLine();
                            dstl.searchbyAuthor(searchAuthor);
                            break;
                        case 5:
                            System.out.print("Nhap the loai sach: ");
                            String searchType = sc.nextLine();
                            dstl.searchbyType(searchType);
                            break;
                        case 6:
                            System.out.print("Nhap ma so Sach: ");
                            String searchBookId = sc.nextLine();
                            dstl.searchbyBookId(searchBookId);
                            break;
                        case 7:
                            System.out.print("Nhap so phat hanh Tap Chi: ");
                            int searchSoPhatHanh = sc.nextInt();
                            dstl.searchbySoPhatHanh(searchSoPhatHanh);;
                            break;
                        case 8:
                            System.out.print("Nhap ma so Dia: ");
                            String searchDiaid = sc.nextLine();
                            dstl.searchbyDiaId(searchDiaid);;
                            break;
                        default:
                            System.out.println("Lua chon khong hop le!");
                    }
                    break;

                case 5:
                    dstl.xuatDanhSach();
                    break;
                case 6:
                    try {
                        dstl.docTuFile("input_TL.txt");
                    } catch (IOException e) {
                        System.out.println("Loi khi doc file: " + e.getMessage());
                    }
                    break;
                case 7:
                try {
                    dstl.ghiVaoFile("output_TL.txt");
                } catch (IOException e) {
                    System.out.println("Loi khi ghi file: " + e.getMessage());
                }
                case 8:
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (subChoice != 8);
    }
}






