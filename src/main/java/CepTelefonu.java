import javax.persistence.*;
import java.util.Scanner;
@Entity
@DiscriminatorValue("CepTelefonu")
public class CepTelefonu extends Urun{




    private int kameraCozunurlugu;
    private int ekranYenilemeHizi;
    private int bellekKapasitesi;



    public void setBellekKapasitesi(int bellekKapasitesi) {
        this.bellekKapasitesi = bellekKapasitesi;
    }

    public void setEkranYenilemeHizi(int ekranYenilemeHizi) {
        this.ekranYenilemeHizi = ekranYenilemeHizi;
    }

    public void setKameraCozunurlugu(int kameraCozunurlugu) {
        this.kameraCozunurlugu = kameraCozunurlugu;
    }

    public int getEkranYenilemeHizi() {
        return ekranYenilemeHizi;
    }

    public int getBellekKapasitesi() {
        return bellekKapasitesi;
    }

    public int getKameraCozunurlugu() {
        return kameraCozunurlugu;
    }

    @Override
    public void urunGir(Urun urun) {
        if (urun instanceof CepTelefonu ){
            Scanner scanner = new Scanner(System.in);
            CepTelefonu cepTelefonu = (CepTelefonu) urun;
            Settings settings = new Settings();

            cepTelefonu.setTur("Cep Telefonu");
            System.out.println("Lütfen cep telefonunun markasını giriniz:");
            cepTelefonu.setMarka(scanner.next());
            System.out.println("Lütfen cep telefonunun bellek kapasitesini giriniz(GB):");
            cepTelefonu.setBellekKapasitesi(scanner.nextInt());
            System.out.println("Lütfen cep telefonunun kamera çözünürlüğünü giriniz(MP):");
            cepTelefonu.setKameraCozunurlugu(scanner.nextInt());
            System.out.println("Lütfen cep telefonunun ekran yenileme hızını giriniz(Hz):");
            cepTelefonu.setEkranYenilemeHizi(scanner.nextInt());
            System.out.println("Lütfen cep telefonunun stok adedini giriniz:");
            cepTelefonu.setAdet(scanner.nextInt());
            System.out.println("Lütfen cep telefonunun fiyatını giriniz(TL):");
            cepTelefonu.setFiyat(scanner.nextDouble());
            settings.add_(cepTelefonu);


        }
        else {
            System.out.println("Yanlış tür girdiniz!");
        }
    }








    @Override
    public String toString() {
        return "------------" +"\nCep telefonu markası= "+getMarka()+
                "\n Kamera Çözünürlüğü= " + kameraCozunurlugu +
                "\n Ekran Yenileme Hızı= " + ekranYenilemeHizi +
                "\n Bellek Kapasitesi= " + bellekKapasitesi +
                "\n Fiyatı"+getFiyat()+"\n Stok adedi= "+getAdet()+"\nÜrün Id'si: "+getUrunId();
    }


}
