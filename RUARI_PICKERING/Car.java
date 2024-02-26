import java.util.Random;

public class Car {
    
    private int x = 0;
    private int y = 0;
    private int speed = 0;
    private int maxSpeed = 0;
    private int size = 0;
    private String col = "WHITE";
    private String num = "0";

    public Car(int dx, int dy, int dmaxSpeed, int dsize, String dcol, GameArena arena) {
        x = dx;
        y = dy;
        maxSpeed = dmaxSpeed;
        size = dsize;
        col = dcol;
        num = Integer.toString(speed);

        Rectangle bodyRear = new Rectangle(x, y, 2*size, 2.5*size, col);
        Rectangle bodyMiddle = new Rectangle(x+2*size, y-0.5*size, 5*size, 3*size, col);
        Rectangle bodyFront = new Rectangle(x+7*size, y+0.5*size, 3*size, 2*size, col);

        Rectangle fender = new Rectangle(x-0.5*size, y-0.5*size, 0.5*size, 0.5*size, col);
        Text number = new Text(num, size, x+4.5*size, y+2*size, "WHITE");

        Ball wheelFront = new Ball(x+8*size, y+2.5*size, 1.5*size, "DARKGREY");
        Ball wheelRear = new Ball(x+2*size, y+2.5*size, 1.5*size, "DARKGREY");
        Ball wheelShadowFront = new Ball(x+8*size, y+2.5*size, 1.7*size, "BLACK");
        Ball wheelShadowRear = new Ball(x+2*size, y+2.5*size, 1.7*size, "BLACK");

        Ball windowCurve = new Ball(x+6.4*size, y+0.01*size, 0.8*size, "CYAN");
        Rectangle windowFront = new Rectangle(x+4.2*size, y, 2.6*size, 0.5*size, "CYAN");
        Rectangle windowRear = new Rectangle(x+4.2*size, y-0.4*size, 2.3*size, 0.5*size, "CYAN");


        arena.addRectangle(bodyFront);
        arena.addRectangle(bodyRear);
        arena.addRectangle(bodyMiddle);
        arena.addRectangle(fender);
        arena.addText(number);
        arena.addBall(wheelShadowRear);
        arena.addBall(wheelShadowFront);
        arena.addBall(wheelRear);
        arena.addBall(wheelFront);
        arena.addBall(windowCurve);
        arena.addRectangle(windowFront);
        arena.addRectangle(windowRear);
    }

    public void NewCar(GameArena arena) {
        num = Integer.toString(speed);

        Rectangle bodyRear = new Rectangle(x, y, 2*size, 2.5*size, col);
        Rectangle bodyMiddle = new Rectangle(x+2*size, y-0.5*size, 5*size, 3*size, col);
        Rectangle bodyFront = new Rectangle(x+7*size, y+0.5*size, 3*size, 2*size, col);

        Rectangle fender = new Rectangle(x-0.5*size, y-0.5*size, 0.5*size, 0.5*size, col);
        Text number = new Text(num, size, x+4.5*size, y+2*size, "WHITE");

        Ball wheelFront = new Ball(x+8*size, y+2.5*size, 1.5*size, "DARKGREY");
        Ball wheelRear = new Ball(x+2*size, y+2.5*size, 1.5*size, "DARKGREY");
        Ball wheelShadowFront = new Ball(x+8*size, y+2.5*size, 1.7*size, "BLACK");
        Ball wheelShadowRear = new Ball(x+2*size, y+2.5*size, 1.7*size, "BLACK");

        Ball windowCurve = new Ball(x+6.4*size, y+0.01*size, 0.8*size, "CYAN");
        Rectangle windowFront = new Rectangle(x+4.2*size, y, 2.6*size, 0.5*size, "CYAN");
        Rectangle windowRear = new Rectangle(x+4.2*size, y-0.4*size, 2.3*size, 0.5*size, "CYAN");


        arena.addRectangle(bodyFront);
        arena.addRectangle(bodyRear);
        arena.addRectangle(bodyMiddle);
        arena.addRectangle(fender);
        arena.addText(number);
        arena.addBall(wheelShadowRear);
        arena.addBall(wheelShadowFront);
        arena.addBall(wheelRear);
        arena.addBall(wheelFront);
        arena.addBall(windowCurve);
        arena.addRectangle(windowFront);
        arena.addRectangle(windowRear);
    }

    public void Move(GameArena arena) {
        int newSpeed = 2^speed + 1;
        if(newSpeed <= maxSpeed)
        {
            speed = newSpeed;
        }
        else if (speed + 1 <= maxSpeed)
        {
            speed++;
        }
        x = x + speed;

        NewCar(arena);
        Random rand = new Random();

        int max = rand.nextInt(20);
        for (int i = 1; i < max *4; i++)
        {
            int dx = x - 3 - rand.nextInt(i) - i*speed/10;
            int dy = y + size - rand.nextInt(i);
            if (dx > 5 && dy < y)
            {
                Rectangle smoke = new Rectangle(dx, dy, rand.nextInt(i), rand.nextInt(i), "LIGHTGREY");
                arena.addRectangle(smoke);
            }
        }
    }

    public void CheckLap() {
        if (x > 2000)
        {
            x = 0;
        }
    }

    public void SetY(int dy) {
        y = dy;
    }

    public int GetY() {
        return y;
    }

    public void SetSpeed(int dspeed) {
        speed = dspeed;
    }

    public int GetSpeed() {
        return speed;
    }

    public int getX() {
        return x;
    }
}