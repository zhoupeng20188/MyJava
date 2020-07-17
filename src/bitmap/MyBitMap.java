package bitmap;

public class MyBitMap {
    private long[] tag;
    private int size;

    public MyBitMap(int size) {
        this.size = size;
        this.tag = new long[getTagIndex(size - 1) + 1];
    }

    /**
     * 获取tag的long型数组中的下标
     * @param bitIndex
     * @return
     */
    private int getTagIndex(int bitIndex) {
        // 右移2^6,相当于除以64
        return bitIndex >> 6;
    }

    /**
     * 设定tag中的某一位
     *
     * @param bitIndex
     */
    public void setBit(int bitIndex) {
        // 用数组下标的值与2的bitIndex次方进行或操作
        // 得到的结果再设定到数组下标中
        tag[getTagIndex(bitIndex)] |= (1L << bitIndex);
    }

    /**
     * 获取某一位上是否有值
     * @param bitIndex
     * @return
     */
    public boolean getBit(int bitIndex) {
        // 不能直接取数据下标的值
        // 因为多个setBit操作可能是对同一个下标操作，值会覆盖前一个
        // 不过是位操作，值覆盖前一个也不要紧，国为每次都和2的bitIndex次方进行了或操作
        // 现在取出时，也对2的bitIndex进行与操作，如果不为0则说明有值
        return (tag[getTagIndex(bitIndex)] & (1L << bitIndex)) != 0;
    }


}
