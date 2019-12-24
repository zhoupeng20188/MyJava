package jvm.finalize;

/**
 * @Author zp
 * @create 2019/12/24 14:58
 */
public class GcSaveTest {

    public static void main(String[] args) throws InterruptedException {
        FinalizeEscapeGC.SAVE_HOOK = new FinalizeEscapeGC();
//        FinalizeEscapeGC finalizeEscapeGC = new FinalizeEscapeGC();
//        FinalizeEscapeGC2 finalizeEscapeGC2 = new FinalizeEscapeGC2();

        // 第一次执行
//        FinalizeEscapeGC.SAVE_HOOK = null;
//        finalizeEscapeGC = null;
        System.gc();
        // 因为finalize优先级很低，0.5秒等待
        Thread.sleep(500);
        if(FinalizeEscapeGC.SAVE_HOOK != null){
//        if(finalizeEscapeGC != null){
            System.out.println("i am alive");
        } else {
            System.out.println("i am dead");
        }

//        // 第二次执行
//        FinalizeEscapeGC.SAVE_HOOK = null;
//        System.gc();
//        // 因为finalize优先级很低，0.5秒等待
//        Thread.sleep(500);
//        if(FinalizeEscapeGC.SAVE_HOOK != null){
//            System.out.println("i am alive");
//        } else {
//            System.out.println("i am dead");
//        }
    }
}
