package entity.carriage;

import entity.Cargo;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class CargoCarriage extends Carriage {

    @Getter
    private int total;
    @Getter
    private final int carryingCapacity;
    private List<Cargo> cargos;

    private CargoCarriage(int carryingCapacity) {
        super();
        this.carryingCapacity = carryingCapacity;
        cargos = new ArrayList<>();
        total = 0;
    }

    public List<Cargo> getCargos() {
        return List.copyOf(cargos);
    }

    public void load(Cargo cargo) {
        if (total + cargo.getWeight() <= carryingCapacity) {
            cargos.add(cargo);
            total += cargo.getWeight();
        } else {
            throw new IllegalArgumentException("no place for cargo");
        }
    }

    public void unload(Cargo cargo) {
        cargos.remove(cargo);
        total -= cargo.getWeight();
    }

    public static CargoCarriage of(int carryingCapacity) {
        return new CargoCarriage(carryingCapacity);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CargoCarriage{");
        sb.append("id=").append(getId());
        sb.append(", carryingCapacity=").append(carryingCapacity);
        sb.append(", total=").append(total);
        sb.append('}');
        return sb.toString();
    }
}
