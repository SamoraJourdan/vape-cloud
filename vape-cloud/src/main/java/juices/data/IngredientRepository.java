package juices.data;

import org.springframework.data.repository.CrudRepository;

import juices.Ingredient;

public interface IngredientRepository 
         extends CrudRepository<Ingredient, String> {

}
