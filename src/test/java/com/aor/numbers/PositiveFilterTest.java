package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class PositiveFilterTest {


    Integer number1, number2;
    Boolean result1, result2;

    @BeforeEach
    public void numeros(){
        number1 = 5;
        number2 = -5;

    }

    @Test
    public void accept() {
        PositiveFilter psf = new PositiveFilter();
        result1 = psf.accept(number1);
        result2 = psf.accept(number2);

        Assertions.assertEquals(true, result1);
        Assertions.assertEquals(false, result2);
    }


}
