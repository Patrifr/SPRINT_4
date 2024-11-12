package cat.itacademy.s04.t02.n01.model;

import jakarta.persistence.*;

@Entity
@Table(name = "fruits")
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "fruit_name", unique = true)
    private String name;
    @Column(name = "Kg_Quantity")
    private int quantityKg;

    Fruit(){}

    Fruit(String name, int quantityKg){
        this.name = name;
        this.quantityKg = quantityKg;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getQuantityKg() {
        return quantityKg;
    }

    public void setId(int id) {
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
