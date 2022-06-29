package com.example.academiaapi.enums;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MetodoDeTreinoTest {

    @Test
    void values() {
        List<MetodoDeTreino> l = Arrays.stream(MetodoDeTreino.values()).toList();


        Assertions.assertEquals(Arrays.stream(MetodoDeTreino.values()).toList(), l);

    }

    @Test
    void valueOfShouldReturnEnum() {
        Assertions.assertEquals(MetodoDeTreino.valueOf("DIA"),MetodoDeTreino.DIA);
    }
}