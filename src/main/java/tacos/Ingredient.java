package tacos;

import lombok.*;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor(access= AccessLevel.PROTECTED, force = true)
@Document(collection="ingredients")
public class Ingredient {
    @Id
    private String id;
    private String name;
    private Type type;

    public static enum Type{
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
    public Type getType() {return type;}
    public Ingredient(String id, String name, Type type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }
}
