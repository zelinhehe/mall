package com.example.mall;

//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MallApplicationTests {

    // 随便加一个测试方法，避免maven打包时报下面的错误
    // [ERROR] Errors:
    // [ERROR]   MallApplicationTests.initializationError »  No runnable methods
    @Test
    public void a() {

    }
}
