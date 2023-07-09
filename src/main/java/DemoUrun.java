import java.util.*;

public class DemoUrun {

      static List<Urun> urunList = new ArrayList<>() ;






    static void baslikYazdir(){
        System.out.println("*********************************************\n*** STOK ÜRÜN GİRİŞ VE SORGULAMA PROGRAMI ***\n*********************************************");
    }

    static void menuYazdir(){
        System.out.println("\nMENÜ:\n(1) Ürün gir\n(2) Ürün sorgula\n(3) Ürün sil \n(4) Programı sonlandır");
    }

    static void menuUrunSec(){
        System.out.println("\n(1) Cep telefonu \n(2) Fotoğraf makinesi");

    }

    void urunListesiSıfırla(){
        Settings settings = new Settings();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lütfen silinmesinisi istediğiniz ürünün id'sini giriniz.");
        int urunSil = scanner.nextInt();
        settings.remove_(urunSil);
        System.out.println("Ürün silindi!");



    }
    public static void main(String[] args) {
        baslikYazdir();
        Scanner scanner = new Scanner(System.in);
       Settings settings = new Settings();
       CepTelefonu cepTelefonu = new CepTelefonu();
       FotografMakinesi fotografMakinesi = new FotografMakinesi();

        boolean dongu =true;
        DemoUrun demoUrun = new DemoUrun();


        while(dongu == true) {
            menuYazdir();
            System.out.print("İşlem seçiniz:");
            int secimSayisi = scanner.nextInt();
            System.out.println("----------------");
            if (secimSayisi > 0 && secimSayisi < 4) {
                if (secimSayisi == 1) {

                        System.out.println("Ürün gir");
                        menuUrunSec();
                        System.out.println("Ürün seçiniz:");
                        int urunSecenek = scanner.nextInt();
                        if (urunSecenek == 1) {

                            cepTelefonu.urunGir(cepTelefonu);

                        } else if (urunSecenek == 2) {

                            fotografMakinesi.urunGir(fotografMakinesi);

                        }
                        else {
                            System.out.println("Ürün seçimi için 1 ya da 2 değerini giriniz!.");
                        }


                } else if (secimSayisi == 2) {
                    System.out.println("----------------");
                    System.out.println("Ürün sorgulama");
                    menuUrunSec();
                    System.out.println("Ürün seçiniz.");

                    int urunSecenek = scanner.nextInt();
                    if (urunSecenek == 1) {
                        urunList.addAll(settings.findByUrunTuru(cepTelefonu));
                        boolean cepTelefonuBulundu = false;
                        for (Urun urun : urunList){
                            if (urun instanceof CepTelefonu){
                                cepTelefonuBulundu = true;
                                break;
                            }
                        }

                        if (cepTelefonuBulundu){
                            System.out.println("----------------");
                            for(Urun urun : urunList){
                                if (urun instanceof CepTelefonu){
                                    System.out.println(urun.toString());
                                }
                            }
                            urunList.removeAll(urunList);
                        }
                        else {
                            System.out.println("Cep telefonu bulunamadı!");
                        }






                    } else if (urunSecenek == 2) {
                        boolean fotografMakinesiBulundu = false;
                        urunList.addAll(settings.findByUrunTuru(fotografMakinesi));



                        for (Urun urun :  urunList) {
                            if (urun instanceof FotografMakinesi) {
                                fotografMakinesiBulundu = true;
                                break;
                            }
                        }
                        if (fotografMakinesiBulundu) {
                            System.out.println("----------------");
                            for (Urun urun :  urunList) {
                                if (urun instanceof FotografMakinesi) {
                                    System.out.println(urun.toString());
                                    System.out.println("----------------");
                                }
                            }
                            urunList.removeAll(urunList);
                        } else {
                            System.out.println("Fotoğraf makinesi bulunamadı!");
                        }
                    } else {
                        System.out.println("Ürün seçimi için 1 ya da 2 değerini giriniz!");
                    }
                } else if (secimSayisi == 3) {
                    System.out.println("----------------");
                    demoUrun.urunListesiSıfırla();
                }
            } else if (secimSayisi == 4) {
                dongu = false;
                System.out.println("Program sonlandırıldı!");
            }
            else {
                System.out.println("UYARI: İşlem yapabilmek için 1 ile 4 arasında bir sayı seçilmelidir!");
                System.out.println("Devam etmek için bir tuşa ve sonrasında ENTER tuşuna basınız:");
                String tus = scanner.next();

            }
        }
    }
}
