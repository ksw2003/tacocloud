package tacos;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@Document
public class TacoOrder implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private Date placedAt = new Date();

    @ManyToOne
    private User user;
    public void setUser(User user) {this.user=user;}
    public User getUser() {return this.user;}

    @NotBlank(message="Delivery name is required")
    private String deliveryName;

    @NotBlank(message="Street is required")
    private String deliveryStreet;

    @NotBlank(message="City is required")
    private String deliveryCity;

    @NotBlank(message="State is required")
    private String deliveryState;

    @NotBlank(message="Zip code is required")
    private String deliveryZip;

    @NotBlank(message="Not a valid credit card number")
    private String ccNumber;

    @Pattern(regexp="^(0[1-9]|1[0-2])(/)([1-9][0-9])$",
            message="Must be formatted MM/YY")
    private String ccExpiration;

    @Digits(integer=3, fraction= 0,message="Invalid CVV")
    private String ccCVV;

    private List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco){
        this.tacos.add(taco);
    }
}
