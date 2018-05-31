package com.project.kata.kata.airport_kata;

import com.project.kata.airport.Airport;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class AirportTest {

    @Test
    public void given_board_with_3_rotors_and_2_lines_when_the_rotors_flaps_then_return_the_correct_result(){

        try {
            Airport airport = new Airport();

            String[] lines = {"CAT", "ABC"};
            ArrayList<int[]> rotors = new ArrayList<int[]>();
            rotors.add(new int[]{1, 13, 27});
            rotors.add(new int[]{2, 25, 27});
            String[] expected_result = {"DOG", "C!C"};
            String[] result = airport.calculateLines(lines, rotors);
            Assert.assertEquals(expected_result[0], result[0]);
            Assert.assertEquals(expected_result[1], result[1]);

        }catch (Exception e){
            Assert.assertEquals("the line format is incorrect", e.getMessage());
        }

    }

    @Test
    public void given_board_with_3_rotors_and_2_line_with_negative_value_when_the_rotors_flaps_then_return_exception(){

        try {
            Airport airport = new Airport();

            String[] lines = {"CAT", "ABC"};
            ArrayList<int[]> rotors = new ArrayList<int[]>();
            rotors.add(new int[]{-1, 13, 27});
            String[] expected_result = {"DOG", "C!C"};
            String[] result = airport.calculateLines(lines, rotors);
            Assert.assertEquals(expected_result[0], result[0]);

        }catch (Exception e){
            Assert.assertEquals("the rotors contain a negative value",e.getMessage());
        }

    }
}
