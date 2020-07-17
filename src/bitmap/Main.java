package bitmap;

public class Main {
    public static void main(String[] args) {
        MyBitMap myBitMap = new MyBitMap(32);
        myBitMap.setBit(1);
        System.out.println(myBitMap.getBit(10));
        myBitMap.setBit(2);
        System.out.println(myBitMap.getBit(1));
        System.out.println(myBitMap.getBit(11));
    }
}
