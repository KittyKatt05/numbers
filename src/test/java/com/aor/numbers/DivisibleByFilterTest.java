package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DivisibleByFilterTest {


    int div;
    Integer number1, number2;
    Boolean result1, result2;

    @BeforeEach
    public void numeros(){
        div = 3;
        number1 = 12;
        number2 = 10;
    }

    @Test
    public void accept(){
        DivisibleByFilter dbf = new DivisibleByFilter(div);
        result1 = dbf.accept(number1);
        result2 = dbf.accept(number2);

        Assertions.assertEquals(true, result1);
        Assertions.assertEquals(false, result2);
    }
}
