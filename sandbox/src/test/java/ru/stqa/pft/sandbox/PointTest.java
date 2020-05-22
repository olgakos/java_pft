package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

        public class PointTest {

            @Test
        public void testDistance() {
            Point p1 = new Point(0, 0);
            Point p2 = new Point(3, 4);
            Assert.assertEquals(p1.distance(p2), 5.0);
        }

        public class PointTest2 {
            @Test
            public void testDistance() {
                Point p1 = new Point(0, 0);
                Point p2 = new Point(3, 4);
                Assert.assertEquals(p1.distance(p2), Math.sqrt(5.0));
            }
        }

}// Это закрывающая } класса PointTest, не стирать ее!
