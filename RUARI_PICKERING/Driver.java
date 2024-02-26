import java.util.Random;

public class Driver {
    public static void main(String[] args) {
        GameArena arena = new GameArena(2000, 800);
        Car gCar = new Car(0, 100, 40, 20, "YELLOW", arena);
        Car rCar = new Car(0, 200, 10, 20, "RED", arena);
        Car bCar = new Car(0, 300, 20, 20, "BLUE", arena);
        Car wCar = new Car(0, 400, 15, 20, "WHITE", arena);
        Car cCar = new Car(0, 500, 25, 20, "CYAN", arena);
        Car dCar = new Car(0, 600, 21, 20, "DARKGREY", arena);

        Car[] raceCars = { gCar, rCar, bCar, wCar, cCar, dCar };

        while (true) {
            Car PlayersCar = gCar;
            CarControls(PlayersCar, raceCars, arena);
            for (int i = 0; i < 6; i++) {
                Collisions(raceCars[i], raceCars);
                if (raceCars[i] != PlayersCar && !Collisions(raceCars[i], raceCars)) {
                    raceCars[i].Move(arena);
                }
                else if (raceCars[i] != PlayersCar) {
                    Random rand = new Random();
                    int upOrDown = rand.nextInt(2) + 1;
                    if (upOrDown == 1)
                    {
                        int dy = raceCars[i].GetY() + 10;
                        if (dy < 600) {
                            raceCars[i].SetY(dy);
                        }
                    }
                    if (upOrDown == 2)
                    {
                        int dy = raceCars[i].GetY() - 10;
                        if (dy > 0) {
                            raceCars[i].SetY(dy);
                        }
                    }
                    raceCars[i].NewCar(arena);
                }
                else {
                    raceCars[i].NewCar(arena);
                }
                raceCars[i].CheckLap();
            }
            arena.pause();
            arena.clearGameArena();
        }
    }

    public static boolean Collisions(Car c1, Car[] raceCars) {
        for (int c = 0; c < 6; c++) {
            if (c1 != raceCars[c]) {
                if ((c1.getX() <= raceCars[c].getX() + 200 && c1.getX() >= raceCars[c].getX() - 200)
                        && (c1.GetY() >= raceCars[c].GetY() - 50 && c1.GetY() <= raceCars[c].GetY() + 50)) {
                    c1.SetSpeed(0);
                    return true;
                }
            }
        }
        return false;
    }

    public static void CarControls(Car PlayersCar, Car[] raceCars, GameArena arena) {
        if (arena.downPressed()) {
            int dy = PlayersCar.GetY() + 10;
            if (dy < 600) {
                PlayersCar.SetY(dy);
            }
        }

        if (arena.upPressed()) {
            int dy = PlayersCar.GetY() - 10;
            if (dy > 100) {
                PlayersCar.SetY(dy);
            }
        }

        if (arena.rightPressed() && !Collisions(PlayersCar, raceCars)) {
            PlayersCar.Move(arena);
        } else {
            int dspeed = PlayersCar.GetSpeed() / 2 - 1;
            if (dspeed >= 0) {
                PlayersCar.SetSpeed(dspeed);
            }
        }

    }
}