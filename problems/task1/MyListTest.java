package com.undo.task1;

import org.junit.Assert;
import org.junit.Test;

public class MyListTest {
    private static final int TEST_SIZE = 1000;

    @Test
    public void testList(){
        test(new MyArrayList());
        test(new MyLinkedList());
    }

    private void test(MyList myList){
        Assert.assertTrue(myList.isEmpty());
        Assert.assertEquals(myList.size(), 0);

        for(int i = 0; i < TEST_SIZE; i++){
            myList.add(Integer.valueOf(i));
        }

        Assert.assertEquals(myList.size(), TEST_SIZE);
        Assert.assertFalse(myList.isEmpty());

        for(int i = 0; i < TEST_SIZE; i++){
            Assert.assertEquals(myList.get(i), Integer.valueOf(i));
        }

        for(int i = 0; i < TEST_SIZE; i++){
            Assert.assertEquals(myList.set(i, Integer.valueOf(i + 1)), Integer.valueOf(i));
        }

        for(int i = 0; i < TEST_SIZE; i++){
            Assert.assertEquals(myList.get(i), Integer.valueOf(i + 1));
        }

        for(int i = TEST_SIZE - 1; i >= 0; i--) {
            Assert.assertEquals(myList.remove(i), Integer.valueOf(i + 1));
        }

        Assert.assertTrue(myList.isEmpty());
        Assert.assertEquals(myList.size(), 0);

        for(int i = 0; i < TEST_SIZE; i++){
            myList.add(Integer.valueOf(i));
        }

        myList.clear();

        Assert.assertTrue(myList.isEmpty());
        Assert.assertEquals(myList.size(), 0);
    }

}
