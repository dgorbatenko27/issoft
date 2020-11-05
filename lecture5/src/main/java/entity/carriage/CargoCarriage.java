package entity.carriage;

import entity.Cargo;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class CargoCarriage extends Carriage {

    @Getter
    private final int carryingCapacity;
    private final List<Cargo> cargos;

    private CargoCarriage(int carryingCapacity) {
        super();
        this.carryingCapacity = carryingCapacity;
        cargos = new ArrayList<>();
        log.debug("CargoCarriage created: {}", this);
    }

    public List<Cargo> getCargos() {
        return List.copyOf(cargos);
    }

    public void load(Cargo cargo) {
        if (canAddCargo(cargo)) {
            cargos.add(cargo);
        } else {
            throw new IllegalArgumentException("no place for cargo");
        }
    }

    public void unload(Cargo cargo) {
        cargos.remove(cargo);
    }

    public static CargoCarriage of(int carryingCapacity) {
        return new CargoCarriage(carryingCapacity);
    }

    public int getTotalCargosWeight() {

        return cargos.stream()
                .map(Cargo::getWeight)
                .reduce(0, Integer::sum);

    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CargoCarriage{");
        sb.append("id=").append(getId());
        sb.append(", carryingCapacity=").append(carryingCapacity);
        sb.append('}');
        return sb.toString();
    }

    private boolean canAddCargo(Cargo cargo) {
        return getTotalCargosWeight() + cargo.getWeight() <= carryingCapacity;
    }
}
