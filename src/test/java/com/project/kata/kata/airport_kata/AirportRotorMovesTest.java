package com.project.kata.kata.airport_kata;

import com.project.kata.airport.Airport;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

public class AirportRotorMovesTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void given_the_before_and_after_result_then_return_the_rotor_moves() throws Exception {
        String[] before = {"CAT"};
        String[] after = {"DOG"};

        Airport airport = new Airport();

        try {
            ArrayList<int[]> listRotors = airport.calculateLinesMoves(before, after);

            Assert.assertArrayEquals(listRotors.get(0), new int[]{1, 13, 27});

        }catch (Exception e){
            throw  e;
        }
    }

    @Test
    public void given_the_empty_before_and_after_result_then_return_the_rotor_moves() throws Exception {
        String[] before = {""};
        String[] after = {"DOG"};

        Airport airport = new Airport();

        try {
            ArrayList<int[]> listRotors = airport.calculateLinesMoves(before, after);

            Assert.assertArrayEquals(listRotors.get(0), new int[]{1, 13, 27});

        }catch (Exception e){
            Assert.assertEquals(e.getMessage(),"the line is empty");
        }
    }

}
