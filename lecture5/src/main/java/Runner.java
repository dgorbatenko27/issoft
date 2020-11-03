import entity.carriage.CarriageFactory;
import entity.carriage.CarriageTypes;
import entity.carriage.Locomotive;
import entity.carriage.PassengerCarriage;

import static util.CarriageUtil.doTrain;
import static util.CarriageUtil.printTrainInfo;

public class Runner {

    public static void main(String[] args) {

        // do train
        Locomotive loc = (Locomotive) CarriageFactory.create(CarriageTypes.LOCOMOTIVE);

        PassengerCarriage ps1 = (PassengerCarriage) CarriageFactory.create(CarriageTypes.PASSENGER_CARRIAGE);
        PassengerCarriage ps2 = (PassengerCarriage) CarriageFactory.create(CarriageTypes.PASSENGER_CARRIAGE);
        PassengerCarriage ps3 = (PassengerCarriage) CarriageFactory.create(CarriageTypes.PASSENGER_CARRIAGE);
        PassengerCarriage ps4 = (PassengerCarriage) CarriageFactory.create(CarriageTypes.PASSENGER_CARRIAGE);

//        doTrain(loc, ps1, ps2, ps3, ps4);

        loc.addNext(ps1);
        ps1.addNext(ps2);
        ps2.addNext(ps3);
        ps3.addNext(ps4);

        printTrainInfo(ps3);
    }

}
