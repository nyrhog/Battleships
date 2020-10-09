public class Point {

    int x;
    int y;
    boolean isEmpty;
    boolean isHit;
    String drawField;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public String getDrawField(){
        return drawField;
    }

    public void setDrawField(String field) {
        this.drawField = field;
    }
}
