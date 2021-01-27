package eu.lengarski.nlpostcode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class DistanceTest {


    @Before
    public void setup() {
        System.out.println("Before Hello world !");
    }

    @Test
    public void test() {
        System.out.println("Hello world !");
    }

    @After
    public void clean() {
        System.out.println("After Hello world !");
    }

}
