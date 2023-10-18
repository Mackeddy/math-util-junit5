package com.pd.mathutil.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static com.pd.mathutil.core.MathUtil.*; //import cho các ham static
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilTest {
    @Test
    public void testFactorialGivenRightArgumentReturnWell(){
        assertEquals(120, getFactorial(5));
    }

    //Bắt ngoại lệ khi đưa data sai!!!
    //functional interface - 1 hàm duy nhất ko có code tên excutable()
//    @Test
//    public void testGetFactorialGivenWrongArgThrowException(){
//        Executable exObject = new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                getFactorial(-5);
//            }
//        };
//
//        //Executable exObject = () -> getFactorial(-5);
//        assertThrows(IllegalArgumentException.class, () -> getFactorial(-5));
//    }

    //Dùng DDT
    //chuẩn bị data
    public static Object [][] initData() {
        return new Integer[][] {
                {1, 1},
                {2, 2},
                {5, 120},
                {6, 120}
        };
    }
    @ParameterizedTest
    @MethodSource(value = "initData") //Tên hàm cung cấp data, ngầm định thứ tự của mảng
                                     // và map vào tham số hàm
    public void testGetFactorialGivenWrongArgThrowException(int input, long expected){
        assertEquals(expected, getFactorial(input));
    }
}
