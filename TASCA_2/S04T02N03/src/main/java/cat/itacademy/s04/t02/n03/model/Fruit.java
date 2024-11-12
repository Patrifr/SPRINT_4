package cat.itacademy.s04.t02.n03.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "fruits")
public class Fruit {
    @Id
    private String id;
    @Field(name = "fruit_name")
    private String name;
    @Field(name = "Kg_Quantity")
    private int quantityKg;

    Fruit(){}

    Fruit(String name, int quantityKg){
        this.name = name;
        this.quantityKg = quantityKg;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getQuantityKg() {
        return quantityKg;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setQuantityKg(int quantityKg) {
        this.quantityKg = quantityKg;
    }

    @Override
    public String toString() {
        return "Fruit{" + "id:" + this.id + "\nname: " + this.name + "\nquantity: " + this.quantityKg + " Kg" + '}';
    }
}
