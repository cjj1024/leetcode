/**
 * @author CuiJunJie
 * @create 2021/3/19-9:50
 */
public class ParkingSystem {
    private int[] parks;

    public ParkingSystem(int big, int medium, int small) {
        parks = new int[3];
        parks[0] = big;
        parks[1] = medium;
        parks[2] = small;
    }

    public boolean addCar(int carType) {
        if (parks[carType - 1] > 0) {
            parks[carType - 1]--;
            return true;
        } else {
            return false;
        }
    }
}
