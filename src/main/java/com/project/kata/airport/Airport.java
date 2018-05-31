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

            int numberOfflaps = rotor[rotorIndex];

            boolean isRotorValid = numberOfflaps > 0;

            if (!isRotorValid) {

                throw new Exception("the rotors contain a negative value");

            }

            result=calculateNextStep(line,numberOfflaps,rotorIndex);

            line=result;
        }


        return result;
    }

    private Character extractNextCharacter(char characterTorotate, int flap) {

        int first_apparition = ALPHABET.indexOf(characterTorotate);

        char[] partial_alphabet = null;

        if (ALPHABET.length() >= first_apparition * 2 + flap + 1) {
            partial_alphabet = ALPHABET.substring(first_apparition, first_apparition + flap + 1).toCharArray();
        } else {
            int position = flap - (ALPHABET.length() - first_apparition);
            partial_alphabet = ALPHABET.substring(0, position + 1).toCharArray();
        }

        return partial_alphabet[partial_alphabet.length - 1];
    }

    private String calculateNextStep(String line, int numberOfFlaps, int rotorIndex){

        StringBuffer stepLine = new StringBuffer();
        stepLine.append(line);

        for (int position = rotorIndex; position < line.toCharArray().length; position++) {

            char characterToModify = line.toCharArray()[position];

            Character nextCharacter = extractNextCharacter(characterToModify, numberOfFlaps);

            stepLine.setCharAt(position,nextCharacter);
        }

        return stepLine.toString();

    }

}
