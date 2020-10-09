public class TwoLengthShip extends Ship {

    public Point[] ship;
    int countOfHits;

    public Point[] getShip() {
        return ship;
    }

    public void setShip(Point[] ship) {
        this.ship = ship;
    }

    public int getCountOfHits() {
        return countOfHits;
    }

    public void setCountOfHits(int countOfHits) {
        this.countOfHits = countOfHits;
    }
}
