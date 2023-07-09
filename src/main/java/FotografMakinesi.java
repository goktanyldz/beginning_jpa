import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Scanner;
@Entity
@DiscriminatorValue("FotografMakinesi")
public class FotografMakinesi extends Urun {

    private int dijitalZoom;

    private int optikZoom;


    public void setDijitalZoom(int dijitalZoom) {
        this.dijitalZoom = dijitalZoom;
    }

    public void setOptikZoom(int optikZoom) {
        this.optikZoom = optikZoom;
    }

    public int getDijitalZoom() {
        return dijitalZoom;
    }

    public int getOptikZoom() {
        return optikZoom;
    }





    @Override
    public void urunGir(Urun urun) {

        if (urun instanceof FotografMakinesi ){
            Scanner scanner = new Scanner(System.in);
            FotografMakinesi fotografMakinesi = (FotografMakinesi) urun;
            Settings settings = new Settings();
            fotografMakinesi.setTur("Fotoğraf Makinesi");
            System.out.println("Lütfen fotoğraf makinesinin markasını giriniz:");
            fotografMakinesi.setMarka(scanner.next());
            System.out.println("Lütfen fotoğraf makinesinin dijital zoom değerini giriniz :");
            fotografMakinesi.setDijitalZoom(scanner.nextInt());
            System.out.println("Lütfen fotoğraf makinesinin optik zoom değerini giriniz :");
            fotografMakinesi.setOptikZoom(scanner.nextInt());

            System.out.println("Lütfen fotoğraf makinesinin stok adedini giriniz:");
            fotografMakinesi.setAdet(scanner.nextInt());
            System.out.println("Lütfen fotoğraf makinesinin fiyatını giriniz(TL):");
            fotografMakinesi.setFiyat(scanner.nextDouble());
            settings.add_(fotografMakinesi);


        }
        else {
            System.out.println("Yanlış tür girdiniz!");
        }

    }

    @Override
    public String toString() {
        return "\nFotoğraf Makinesi markası: " +getMarka()+
                "\nDijital zoom değeri: " + dijitalZoom +
                "\nOptik Zoom değeri: " + optikZoom +"\nFiyatı: "+getFiyat()+
                "\nStok adedi:"+getAdet()+"\nÜrün Id'si: "+getUrunId();
    }
}
