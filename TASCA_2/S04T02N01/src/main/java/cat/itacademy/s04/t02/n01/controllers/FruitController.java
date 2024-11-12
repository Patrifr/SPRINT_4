package cat.itacademy.s04.t02.n01.controllers;

import cat.itacademy.s04.t02.n01.model.Fruit;
import cat.itacademy.s04.t02.n01.services.Impl.FruitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruit")

public class FruitController {
    @Autowired
    private FruitServiceImpl fruitServiceImpl;

    @PostMapping("/add")
    public ResponseEntity<Fruit> addFruit(@RequestBody Fruit fruit){
        Fruit newFruit = fruitServiceImpl.addFruit(fruit);
        return new ResponseEntity<>(newFruit, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Fruit> updateFruit(@RequestBody Fruit fruit){
        Fruit fruitToUpdate = fruitServiceImpl.updateFruit(fruit);
        return ResponseEntity.ok(fruitToUpdate);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFruit(@PathVariable int id){
        fruitServiceImpl.deleteFruit(id);
        return new ResponseEntity<>("Fruit successfully deleted.",HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruit> getOneFruit(@PathVariable int id){
        return ResponseEntity.ok(fruitServiceImpl.getOneFruit(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruit>> getAllFruits(){
        List<Fruit> fruitList = fruitServiceImpl.getAllFruits();
        return ResponseEntity.ok(fruitList);
    }
}
