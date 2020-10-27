package algorithm.task.fail.fast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * 一个任务中有几个子任务，当其中一个任务执行失败时所有任务取消
 * CompletableFuture加interrupt实现
 * @Author zp
 * @create 2020/10/27 9:29
 */
public class TaskFailFast {
    static class MyTask{
        private String name;
        private int time;
        private boolean isSuccess;
        private Thread currentThread;

        public MyTask(String name, int time, boolean isSuccess) {
            this.name = name;
            this.time = time;
            this.isSuccess = isSuccess;
        }

        public boolean runTask(){
            int step = 100;
            int sum = 100;
            currentThread = Thread.currentThread();
            System.out.println("now thread is " + currentThread + ", isInterrupted:"+currentThread.isInterrupted());
            while (sum <= time){
                if(!currentThread.isInterrupted()){
                    try {
                        Thread.sleep(step);
                    } catch (InterruptedException e) {
//                        e.printStackTrace();
                        System.out.println("进入interrupte异常");
                        return isSuccess;
                    }
                    sum = sum + step;
                } else {
                    System.out.println(name + "is breaking");
                    break;
                }
            }
            System.out.println(name + " end..");
            return isSuccess;
        }

        public Thread getCurrentThread(){
            return currentThread;
        }
    }

    static List<MyTask> tasks = new ArrayList<>();
    public static void main(String[] args) {
        MyTask task1 = new MyTask("task1", 9000, true);
        MyTask task2 = new MyTask("task2", 8000, true);
        MyTask task3 = new MyTask("task3", 1000, false);

        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);

        for (MyTask task : tasks) {
            CompletableFuture.supplyAsync(()->task.runTask())
                    .thenAccept((result)->callBack(task, result));
        }

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void callBack(MyTask task, boolean result){
        System.out.println(task.name + " callBack in..");
        if(!result){
            // 失败的场合，取消其它的任务
            for (MyTask myTask : tasks) {
                String name = myTask.name;
                if(!task.name.equals(name)){
                    Thread currentThread = myTask.getCurrentThread();
                    System.out.println(name + " " + currentThread + " 开始取消。。");
                    currentThread.interrupt();
                }
            }
        }

    }
}
