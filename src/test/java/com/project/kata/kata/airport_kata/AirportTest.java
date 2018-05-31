package com.project.kata.kata.airport_kata;

import com.project.kata.airport.Airport;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;

public class AirportTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void given_board_with_3_rotors_and_2_lines_when_the_rotors_flaps_then_return_the_correct_result() throws Exception {


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

            throw  e;
        }

    }

    @Test
    public void given_board_with_3_rotors_and_1_incorrect_line_when_the_rotors_flaps_then_return_the_exception() throws Exception {

        try {
            Airport airport = new Airport();

            String[] lines = {""};

            ArrayList<int[]> rotors = new ArrayList<int[]>();

            rotors.add(new int[]{1, 13, 27});

            String[] expected_result = {"DOG"};

            String[] result = airport.calculateLines(lines, rotors);

            thrown.expect(Exception.class);
            thrown.expectMessage("the line format is incorrect");

        }catch (Exception e){
            Assert.assertEquals("the line format is incorrect", e.getMessage());

        }

    }

    @Test
    public void given_board_with_3_rotors_and_1_line_with_negative_value_when_the_rotors_flaps_then_return_exception(){

        try {
            Airport airport = new Airport();

            String[] lines = {"CAT"};

            ArrayList<int[]> rotors = new ArrayList<int[]>();

            rotors.add(new int[]{-1, 13, 27});

            String[] expected_result = {"DOG"};

            String[] result = airport.calculateLines(lines, rotors);

            thrown.expect(Exception.class);
            thrown.expectMessage("the rotors contain a negative value");

        }catch (Exception e){
            Assert.assertEquals("the rotors contain a negative value",e.getMessage());
        }

    }
}
