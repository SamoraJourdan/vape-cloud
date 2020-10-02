package juices;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import juices.Ingredient.Type;
import juices.data.IngredientRepository;
import juices.data.UserRepository;

@Profile("!prod")
@Configuration
public class DevelopmentConfig {

  @Bean
  public CommandLineRunner dataLoader(IngredientRepository repo,
        UserRepository userRepo, PasswordEncoder encoder) { // user repo for ease of testing with a built-in user
    return new CommandLineRunner() {
      @Override
      public void run(String... args) throws Exception {
        repo.save(new Ingredient("VEGL", "Vegetable Glycerine", Type.BASE));
        repo.save(new Ingredient("POGL", "Propane Glycol", Type.BASE));
        repo.save(new Ingredient("STBE", "Strawberry", Type.FRUIT));
        repo.save(new Ingredient("MANG", "Mango", Type.FRUIT));
        repo.save(new Ingredient("CHRY", "Cherry", Type.FRUIT));
        repo.save(new Ingredient("LIME", "Lime", Type.FRUIT));
        repo.save(new Ingredient("CRAM", "Cream", Type.DESSERT));
        repo.save(new Ingredient("CARA", "Caramel", Type.DESSERT));
        repo.save(new Ingredient("CUST", "Custard", Type.DESSERT));
        repo.save(new Ingredient("TOFF", "Toffee", Type.DESSERT));
        repo.save(new Ingredient("CLAS", "Classic", Type.TOBACCO));
        repo.save(new Ingredient("AMRE", "American Red", Type.TOBACCO));
        repo.save(new Ingredient("KODA", "Koolada", Type.OTHER));
        repo.save(new Ingredient("CACT", "Cactus", Type.OTHER));
        userRepo.save(new User("habuma", encoder.encode("password"), 
            "Craig Walls", "123 North Street", "Cross Roads", "TX", 
            "76227", "123-123-1234"));
      }
    };
  }
  
}
