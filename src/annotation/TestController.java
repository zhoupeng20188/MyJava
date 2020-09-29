package annotation;

/**
 * @Author zp
 * @create 2020/9/29 14:27
 */
public class TestController {
    @Autowired
    private TestService testService;

    public TestService getTestService() {
        return testService;
    }
}
