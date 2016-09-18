package application.kobrahotel.com.kobra.domain;

/**
 * Created by Avell B155 on 31/10/2015.
 */
public class Product {

    private String model;
    private String brand;
    private int photo;


    public Product(){}
    public Product(String m, String b, int p){
        model = m;
        brand = b;
        photo = p;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
