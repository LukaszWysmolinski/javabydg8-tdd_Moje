import org.junit.jupiter.api.*;

public class LifeCycleMethodsDemo {

    private static int testValue = 99;

    @BeforeAll
    static void beforeAll() {
        System.out.println("beforeAll: test value = " + testValue++);
    }

    @AfterAll
    static void afterAll() {
        System.out.println("afterAll: test value = " + testValue++);
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("beforeEach: test value = " + testValue++);
    }

    @AfterEach
    void afterEach() {
        System.out.println("afterEach: test value = " + testValue++);
    }

    @Test
    void test() {
        System.out.println("test: test value = " + testValue++);
    }

    @Test
    void test2() {
        System.out.println("test2: test value = " + testValue++);
    }

}
