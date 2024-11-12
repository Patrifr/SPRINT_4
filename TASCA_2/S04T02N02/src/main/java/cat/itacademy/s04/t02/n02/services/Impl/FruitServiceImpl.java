package cat.itacademy.s04.t02.n02.services.Impl;


import cat.itacademy.s04.t02.n02.exception.CustomExceptions.FruitExistsException;
import cat.itacademy.s04.t02.n02.exception.CustomExceptions.FruitNotFoundException;
import cat.itacademy.s04.t02.n02.model.Fruit;
import cat.itacademy.s04.t02.n02.repository.FruitRepository;
import cat.itacademy.s04.t02.n02.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FruitServiceImpl implements FruitService {
    @Autowired
    private FruitRepository fruitRepository;

    @Override
    public Fruit addFruit(Fruit fruit){
        fruitRepository.findByName(fruit.getName()).ifPresent(dupFruit ->{
            throw new FruitExistsException("Error. " + fruit.getName() + " already exists.");
        });
        return fruitRepository.save(fruit);
    }

    @Override
    public Fruit updateFruit(Fruit fruit){
        Fruit fruitToUpdate = fruitRepository.findById(fruit.getId()).orElseThrow(() ->
                new FruitNotFoundException("Error while updating. Fruit with id " + fruit.getId() +
                        " not found."));

        fruitToUpdate.setName(fruit.getName());
        fruitToUpdate.setQuantityKg(fruit.getQuantityKg());

        return fruitRepository.save(fruitToUpdate);
    }

    @Override
    public void deleteFruit(int id){
        findFruitById(id);
        fruitRepository.deleteById(id);
    }

    @Override
    public Fruit getOneFruit(int id) {
        return findFruitById(id);
    }

    @Override
    public List<Fruit> getAllFruits(){
        return  fruitRepository.findAll();
    }

    private Fruit findFruitById(int id) {
        return fruitRepository.findById(id)
                .orElseThrow(() -> new FruitNotFoundException("Fruit with id " + id + " not found."));
    }
}
