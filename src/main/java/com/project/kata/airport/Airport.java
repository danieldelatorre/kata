package com.project.kata.airport;

import java.util.ArrayList;

public class Airport {

    private final String ALPHABET ="ABCDEFGHIJKLMNOPQRSTUVWXYZ ?!@#&()|<>.:=-+*/0123456789";

    public String[] calculateLines(String[] lines, ArrayList<int[]> rotors) throws Exception{

        String[] result=new String[lines.length];

        for(int i=0 ;i<lines.length;i++) {

            result[i] = "";

            String line = lines[i];

            result[i] = calculateline(rotors.get(i), line);

        }

        return result;
    }


    private String calculateline(int[] rotor, String line) throws Exception {

        String result = "";

        if (line.isEmpty()) {

            throw new Exception("the line format is incorrect");

        }
        for (int rotorIndex = 0; rotorIndex < rotor.length; rotorIndex++) {

            int flap = rotor[rotorIndex];

            boolean isRotorValid = flap > 0;

            if (!isRotorValid) {

                throw new Exception("the rotors contain a negative value");

            }

            if (result.length() == line.length()) {

                line = result;
                result = result.substring(0, rotorIndex);
            }

            for (int l = rotorIndex; l < line.toCharArray().length; l++) {

                char currentCharacter = line.toCharArray()[l];

                String nextCharacter = extractNextCharacter(currentCharacter, flap);

                result += nextCharacter;

            }
        }


        return result;
    }

    private String extractNextCharacter(char characterTorotate, int flap) {

        int first_apparition = ALPHABET.indexOf(characterTorotate);

        char[] partial_alphabet = null;

        if (ALPHABET.length() >= first_apparition * 2 + flap + 1) {
            partial_alphabet = ALPHABET.substring(first_apparition, first_apparition + flap + 1).toCharArray();
        } else {
            int position = flap - (ALPHABET.length() - first_apparition);
            partial_alphabet = ALPHABET.substring(0, position + 1).toCharArray();
        }

        return Character.toString(partial_alphabet[partial_alphabet.length - 1]);
    }

}
