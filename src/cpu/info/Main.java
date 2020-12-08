package cpu.info;

/**
 * @Author zp
 * @create 2020/12/8 15:05
 */
public class Main {
    /**
     * 测试方法.
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Cpu c = new Cpu();
        System.out.println("cpu占有率1=" + c.getCpuRatio());
        System.out.println("cpu占有率2=" + c.getCpuRatioForWindows());
        MonitorInfoBean monitorInfo = c.getMonitorInfoBean();
        System.out.println("cpu占有率=" + monitorInfo.getCpuRatio());

        System.out.println("可使用内存=" + monitorInfo.getTotalMemory());
        System.out.println("剩余内存=" + monitorInfo.getFreeMemory());
        System.out.println("最大可使用内存=" + monitorInfo.getMaxMemory());

        System.out.println("操作系统=" + monitorInfo.getOsName());
        System.out.println("总的物理内存=" + monitorInfo.getTotalMemorySize()  + "kb");
        System.out.println("剩余的物理内存=" + monitorInfo.getFreeMemory() + "kb");
        System.out.println("已使用的物理内存=" + monitorInfo.getUsedMemory() + "kb");
        System.out.println("线程总数=" + monitorInfo.getTotalThread() + "kb");
    }

}
