package package5;

public class SpiralArrayCell {
    private int num;
    private boolean isEmpty;

    public SpiralArrayCell() {}

    public SpiralArrayCell(int num) {
        this.num = num;
    }

    public SpiralArrayCell(int num, boolean isEmpty) {
        this.num = num;
        this.isEmpty = isEmpty;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public void switchIsEmpty(){
        if(this.isEmpty){
            this.isEmpty = false;
        } else {
            this.isEmpty = true;
        }
    }
}
