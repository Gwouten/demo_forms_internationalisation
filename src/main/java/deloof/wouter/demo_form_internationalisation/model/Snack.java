package deloof.wouter.demo_form_internationalisation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
public class Snack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "Je moet een naam ingeven")
    @NotBlank(message = "Je naam mag niet blanco zijn")
    @Size(min = 2, max = 40, message = "Je moet een naam ingeven")
    private String name;
    @NotNull(message = "Je moet een prijs ingeven")
    @DecimalMin(value = "0.50")
    private BigDecimal price;

    public Snack() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
