package hw9;

public class MyArraySizeException extends IllegalArgumentException {
    private int len;

    public MyArraySizeException(String s, int len) {
        super(s);
        this.len = len;
    }

    public int getLen() {
        return len;
    }

}
