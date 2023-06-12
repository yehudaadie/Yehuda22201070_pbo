import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Jual {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        List<Mobil> arr = new ArrayList<>();
        Random random = new Random();
        int count = 10;
        Profil profil = new Profil(count, 100000000);

        String[] merek = {"Toyota", "Honda", "Suzuki", "Daihatsu", "Mitsubishi", "Nissan", "Isuzu", "Mazda", "Wuling", "KIA", "Avanza", "Civic", "Ertiga", "Terios", "Xpander", "Livina", "Elf", "CX-5", "Cortez", "Rio"};
        String[] warna = {"Putih","Hitam","Silver","Abu-abu","Merah","Biru","Hijau","Cokelat","Oranye","Kuning"};
        int[] kecepatan = {150, 200, 250, 300, 350, 400};
        String[] model = {"Supra" ,"Jazz" ,"Katana" ,"Zebra" ,"Pajero" ,"Livina" ,"R35" ,"CX-5" ,"Cortez" ,"Rio"};
        int[] harga = {710000000, 100000000, 590000000, 190000000, 680000000, 720000000, 240000000, 860000000, 300000000, 880000000, 840000000, 480000000, 210000000, 840000000, 430000000, 910000000, 770000000, 970000000, 190000000, 670000000};
        String[] status = {"Baru", "Bekas"};

        // Interaksi        
        while (true) {
            System.out.println("\n 1. Daftar Mobil\n 2. Jual Mobil\n 3. Lihat Profil\n 4. Berhenti\n");
            System.out.print("Pilih menu 1/2/3/4: ");
            int user = scn.nextInt();

            // int asset = 0;
            if (user == 1){
                for (int i = 0; i < count; i++) {
                    if (arr.size() < 10){
                        arr.add(new Mobil(merek[random.nextInt(merek.length)], warna[random.nextInt(warna.length)], kecepatan[random.nextInt(kecepatan.length)], model[random.nextInt(model.length)], harga[random.nextInt(harga.length)], status[random.nextInt(status.length)]));
                    }
                    System.out.println("Nomor              : " + (i + 1));
                    Mobil cars = arr.get(i);
                    cars.read();
                    System.out.println("============================================");
                    
                }
            } else if(user == 2){
                System.out.println("\n============================================");
                System.out.println("                 Jual mobil");
                System.out.println("============================================");
                
                System.out.print("Pilih mobil 1/2/3/dll..: ");
                int beli = scn.nextInt() - 1;
                
                try {
                    Mobil car = (Mobil) arr.get(beli);
                    car.read();
                    System.out.print(" 1. Yes\n 2. No\nKonfirmasi: ");
                    int confirm = scn.nextInt();

                    if (confirm == 1){
                        profil.Jual(1, car.get_harga());
                        profil.show();
                        arr.remove(beli);
                        count -= 1;
                    }

                } catch (Exception e) {
                    System.err.println("Mobil tidak tersedia!");
                }
            } else if (user == 3) {
                System.out.println("\n============================================");
                System.out.println("             Profil Anda");
                System.out.println("============================================");
                
                profil.show();
            } else if (user == 4) {
                break;
            } else {
                System.out.println("\n============================================");
                System.out.println("             Menu tidak tersedia");
                System.out.println("============================================");
            }
        }
    }
}