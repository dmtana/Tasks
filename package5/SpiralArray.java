package package5;

public class SpiralArray {

    private SpiralArrayCell[][] spiralArrayCells;
    private int lengthSpiralArray;

    SpiralArray(){ }

    SpiralArray(int lengthSpiralArray){
        this.lengthSpiralArray = lengthSpiralArray;
        this.spiralArrayCells = new SpiralArrayCell[lengthSpiralArray][lengthSpiralArray];
        for (int i = 0; i < spiralArrayCells.length; i++) {
            for (int j = 0; j < spiralArrayCells[i].length; j++) {
                spiralArrayCells[i][j] = new SpiralArrayCell(0, true);
            }
        }
    }

    public void display(){
        initializationArray(Position.RIGHT,
                1, lengthSpiralArray*lengthSpiralArray, 0,0);

        for (int i = 0; i < spiralArrayCells.length; i++) {
            for (int j = 0; j < spiralArrayCells[i].length; j++) {
                System.out.print("[ "+spiralArrayCells[i][j].getNum()+" ] \t\t");
            }
            System.out.println("\n");
        }
    }

    public void initializationArray(Position position, int num, int length, int rows, int cols) {
        if (length == 0) return;
        try {
            if (spiralArrayCells[cols][rows].isEmpty()) {
                spiralArrayCells[cols][rows] = new SpiralArrayCell(num++, false);
            } else {
                try {
                    if (position == Position.RIGHT) rows--;
                    if (position == Position.DOWN) cols--;
                    if (position == Position.LEFT) rows++;
                    if (position == Position.UP) cols++;
                    length++;
                    position = rotate(position);
                } catch (Exception e1) {
                    //System.out.println(e1);
                    if (position == Position.RIGHT & rows > 0) rows--;
                    if (position == Position.DOWN & cols > 0) cols--;
                    if (position == Position.LEFT & rows < length / 2) rows++;
                    if (position == Position.UP & cols < length / 2) cols++;
                    length++;
                    position = rotate(position);
                }
            }

        } catch (Exception e) {
            //System.out.println(e);
            try {
                if (position == Position.RIGHT) rows--;
                if (position == Position.DOWN) cols--;
                if (position == Position.LEFT) rows++;
                if (position == Position.UP) cols++;
                length++;
                position = rotate(position);
            } catch (Exception e1) {
                //System.out.println(e1);
                if (position == Position.RIGHT & rows > 0) rows--;
                if (position == Position.DOWN & cols > 0) cols--;
                if (position == Position.LEFT & rows < length / 2) rows++;
                if (position == Position.UP & cols < length / 2) cols++;
                length++;
                position = rotate(position);
            }
        }

        try {
            if (position == Position.RIGHT) rows++;
            if (position == Position.DOWN) cols++;
            if (position == Position.LEFT) rows--;
            if (position == Position.UP) cols--;
        } catch (Exception e) {
            if (position == Position.RIGHT) rows--;
            if (position == Position.DOWN) cols--;
            if (position == Position.LEFT) rows++;
            if (position == Position.UP) cols++;
            length++;
            position = rotate(position);
        }

        initializationArray(position, num, --length, rows, cols);
    }

    Position rotate(Position position) {
        if (position == Position.RIGHT) {
            return Position.DOWN;
        }
        if (position == Position.DOWN) {
            return Position.LEFT;
        }
        if (position == Position.LEFT) {
            return Position.UP;
        } else {
            return Position.RIGHT;
        }
    }

    enum Position {
        RIGHT, DOWN, LEFT, UP;
    }
}
