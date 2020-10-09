public class Field {

    private final Point[][] field = new Point[10][10];

    private void initializeStartedField(){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
               field[i][j] = new Point();
            }
        }
    }

    public void setStartedField(){
        initializeStartedField();
        for (int i = 0; i<10; i++){
            for (int j = 0; j < 10; j++){
                field[i][j].setX(i);
                field[i][j].setY(j);
                field[i][j].setEmpty(true);
                field[i][j].setDrawField("[ ]");
            }
        }
   }

    public void showField() {
        for (int i = 0; i<10; i++){
            for (int j = 0; j < 10; j++){
                System.out.print(field[j][i].getDrawField());
            }
            System.out.println();
        }
    }

    private boolean isEmptyPoint(Point point) {
        return point.isEmpty;
    }

    public boolean isNearestPointsEmpty(Point point){
       int coordX = point.getX();
       int coordY = point.getY();

       if(!point.isEmpty){
           return false;
       }

       if(coordX == 0){
           if (coordY == 0) {
               return (isEmptyPoint(field[0][1]) || isEmptyPoint(field[1][0]) || isEmptyPoint(field[1][1]));
           }

           if (coordY == 9) {
               return (isEmptyPoint(field[0][8]) || isEmptyPoint(field[1][8]) || isEmptyPoint(field[1][9]));
           }

           for (int i = 0; i < 2; i++) {
               for (int j = 0; j < 3; j++ ){
                   if (!(field[coordX][coordY-1].isEmpty)){
                       return false;
                   }
                   coordY++;
               }
               coordY = point.getY();
               coordX++;
           }

           return true;
       }

       if(coordX == 9){
           if (coordY == 0) {
               return (isEmptyPoint(field[8][0]) || isEmptyPoint(field[8][1]) || isEmptyPoint(field[9][1]));
           }

           if (coordY == 9) {
               return (isEmptyPoint(field[8][9]) || isEmptyPoint(field[8][8]) || isEmptyPoint(field[9][8]));
           }

           for (int i = 0; i < 2; i++) {
               for (int j = 0; j < 3; j++ ){
                   if (!(field[coordX-1][coordY-1].isEmpty)){
                       return false;
                   }
                   coordY++;
               }
               coordY = point.getY();
               coordX++;
           }

           return true;
       }

       if (coordY == 0){
           for (int i = 0; i < 2; i++) {
               for (int j = 0; j < 3; j++ ){
                   if (!(field[coordX - 1][coordY].isEmpty)){
                       return false;
                   }
                   coordX++;
               }
               coordX = point.getX();
               coordY++;
           }

           return true;
       }

       if (coordY == 9){
           for (int i = 0; i < 2; i++) {
               for (int j = 0; j < 3; j++ ){
                   if (!(field[coordX-1][coordY-1].isEmpty)){
                       return false;
                   }
                   coordX++;
               }
               coordX = point.getX();
               coordY++;
           }
           return true;
       }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++ ){
                if (!(field[coordX - 1][coordY - 1].isEmpty)){
                    return false;
                }
                coordY++;
            }
            coordY = point.getY();
            coordX++;
        }
        return true;
    }

    public Point[][] getPoint() {
        return field;
    }

    public boolean placeOneLengthShip(Point point){

        OneLengthShip ship = new OneLengthShip();

       if (isNearestPointsEmpty(point)){
           point.setEmpty(false);
           point.setDrawField("[X]");
           ship.setShip(point);
           return true;
       }
       return false;
    }

    public boolean placeTwoLengthShip(Point point, Orientation orientation){
        int coordX = point.getX();
        int coordY = point.getY();

        Ship ship = new TwoLengthShip();
            if (orientation == Orientation.Horizontal && !(point.getX() == 9)){
                for (int j = 0; j<2; j++){
                    coordX++;
                    if(!(isNearestPointsEmpty(field[coordX-1][coordY]))){
                        return false;
                    }

                }
                ship.setShip(setFieldAfterPlaceShip(point, 2, orientation));
                return true;
            }

            else if(orientation == Orientation.Vertical && !(point.getY() == 9)){
                for (int j = 0; j<2; j++){
                    coordY++;
                    if(!(isNearestPointsEmpty(field[coordX][coordY-1]))){
                        return false;
                    }

                }
                ship.setShip(setFieldAfterPlaceShip(point, 2, orientation));
                return true;
            }
       return false;
    }

    public boolean placeThreeLengthShip(Point point, Orientation orientation){
        int coordX = point.getX();
        int coordY = point.getY();
        Ship ship = new ThreeLengthShip();

        if (orientation == Orientation.Horizontal && !(point.getX() >= 8)){
            for (int j = 0; j<3; j++){
                coordX++;
                if(!(isNearestPointsEmpty(field[coordX-1][coordY]))){
                    return false;
                }

            }
            ship.setShip(setFieldAfterPlaceShip(point, 3, orientation));
            return true;
        }

        else if(orientation == Orientation.Vertical && !(point.getY() >= 8)){
            for (int j = 0; j<3; j++){
                coordY++;
                if(!(isNearestPointsEmpty(field[coordX][coordY-1]))){
                    return false;
                }

            }
            ship.setShip(setFieldAfterPlaceShip(point, 3, orientation));
            return true;
        }
        return false;
    }

    public boolean placeFourLengthShip(Point point, Orientation orientation){
        int coordX = point.getX();
        int coordY = point.getY();
        Ship ship = new FourLengthShip();

        if (orientation == Orientation.Horizontal && !(point.getX() >= 7)){

            for (int j = 0; j<4; j++){
                coordX++;
                if(!(isNearestPointsEmpty(field[coordX - 1][coordY]))){
                    return false;
                }

            }
            ship.setShip(setFieldAfterPlaceShip(point, 4, orientation));
            return true;
        }

        else if(orientation == Orientation.Vertical && !(point.getY() >= 7)){
            for (int j = 0; j<4; j++){
                coordY++;
                if(!(isNearestPointsEmpty(field[coordX][coordY-1]))){
                    return false;
                }

            }
            ship.setShip(setFieldAfterPlaceShip(point, 4, orientation));
            return true;
        }
        return false;
    }

    public void setRandomField(){
        int oneLengthCounter = 0;
        int twoLengthCounter = 0;
        int threeLengthCounter = 0;
        int fourLengthCounter = 0;
        Orientation[] orientations = Orientation.values();

        while (oneLengthCounter != 4){
            if(placeOneLengthShip(field[(int) (Math.random()*10)][(int) (Math.random()*10)])){
                oneLengthCounter++;
            }
        }

        while (twoLengthCounter != 3){
            if(placeTwoLengthShip(field[(int) (Math.random()*10)][(int) (Math.random()*10)], orientations[(int) (Math.random()*2)])){
                twoLengthCounter++;
            }
        }

        while (threeLengthCounter != 2){
            if(placeThreeLengthShip(field[(int) (Math.random()*10)][(int) (Math.random()*10)], orientations[(int) (Math.random()*2)])){
                threeLengthCounter++;
            }
        }

        while (fourLengthCounter != 1){
            if(placeFourLengthShip(field[(int) (Math.random()*10)][(int) (Math.random()*10)], orientations[(int) (Math.random()*2)])){
                fourLengthCounter++;
            }
        }
    }

    private Point[] setFieldAfterPlaceShip(Point point, int length, Orientation orientation){
        int coordX = point.getX();
        int coordY = point.getY();
        Point[] array = new Point[length];

        if (orientation == Orientation.Horizontal) {
            for (int i = 0; i<length; i++) {
                field[coordX][coordY].setEmpty(false);
                field[coordX][coordY].setDrawField("[X]");
                array[i] = field[coordX][coordY];
                coordX++;
            }
        }

        if (orientation == Orientation.Vertical) {
            for (int i = 0; i<length; i++) {
                field[coordX][coordY].setEmpty(false);
                field[coordX][coordY].setDrawField("[X]");
                array[i] = field[coordX][coordY];
                coordY++;
            }
        }


        return array;
    }
}
