package my.editslog;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EditsLog {

    /**
     * editslog的全局txid
     */
    private long txid;

    /**
     * 内存双缓冲类
     */
    private DoubleBuffer buffer = new DoubleBuffer();

    private volatile boolean isSyncRunning = false;

    private volatile boolean isWaitSync = false;

    private volatile long maxTxid = 0L;

    private ThreadLocal<Long> localTxid = new ThreadLocal<>();

    /**
     * 写磁盘
     */
    public void writeToDisk(String s) {

        // 第一次分段加锁
        synchronized (this) {
            long logTxid = txid++;
            localTxid.set(logTxid);
            Log log = new Log(logTxid, s);

            writeToBuffer(log);
        }

        sync();

    }

    /**
     * 写入缓冲区
     *
     * @param log
     */
    public void writeToBuffer(Log log) {
        buffer.currentBuffer.add(log);
    }

    /**
     * 交换缓冲区
     */
    public void changeBuffer() {
        LinkedList<Log> tmpBuffer = buffer.currentBuffer;
        buffer.currentBuffer = buffer.bakBuffer;
        buffer.bakBuffer = tmpBuffer;
    }

    /**
     * 刷盘
     */
    public void sync() {
        // 第二次分段加锁
        synchronized (this) {
            if (isSyncRunning) {
                Long txid = localTxid.get();
                if (txid <= maxTxid) {
                    return;
                }

                if (isWaitSync) {
                    // 保证同一时间只有一个线程在等待
                    return;
                }

                isWaitSync = true;

                while(isSyncRunning) {
                    try {
                        // 此时wait 2s并释放锁
                        wait(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                isWaitSync = false;

            }
            changeBuffer();

            maxTxid = getMaxTxidFromBuffer();

            isSyncRunning = true;

        }
        // 写磁盘，此时已经释放锁
        flush();
    }

    /**
     * 刷盘
     */
    public void flush() {
        buffer.flush();
        // 第三次分段加锁
        synchronized (this) {
            isSyncRunning = false;
            notifyAll();
        }
    }

    /**
     * 获取当前缓冲区最大的txid
     *
     * @return
     */
    public long getMaxTxidFromBuffer() {
        return buffer.currentBuffer.getLast().txid;
    }


    private class Log {
        private long txid;
        private String content;

        public Log(long txid, String content) {
            this.txid = txid;
            this.content = content;
        }
    }


    /**
     * 内存双缓冲类
     */
    private class DoubleBuffer {
        /**
         * 当前buffer
         */
        private LinkedList<Log> currentBuffer = new LinkedList<>();
        /**
         * 备用buffer
         */
        private LinkedList<Log> bakBuffer = new LinkedList<>();

        private void flush() {

        }
    }
}
