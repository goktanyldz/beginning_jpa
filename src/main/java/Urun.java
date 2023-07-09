
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "URUN")
public abstract class Urun {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = false)
    private int urunId;

    private String marka;
    private String tur;
    private int adet;
    private double fiyat;
    public abstract void urunGir(Urun urun);




    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }
    public void setAdet(int adet) {
        this.adet = adet;
    }
    public void setTur(String tur) {
        this.tur = tur;
    }
    public void setMarka(String marka) {
        this.marka = marka;
    }
    public void setUrunId(int urunId) {
        this.urunId = urunId;
    }

    public String getTur() {
        return tur;
    }

    public String getMarka() {
        return marka;
    }

    public int getUrunId() {
        return urunId;
    }

    public int getAdet() {
        return adet;
    }

    public double getFiyat() {
        return fiyat;
    }
}
