package com.project.kata.airport;

import java.util.ArrayList;

public class Airport {

    private final String ALPHABET ="ABCDEFGHIJKLMNOPQRSTUVWXYZ ?!@#&()|<>.:=-+*/0123456789";

    public String[] calculateLines(String[] lines, ArrayList<int[]> rotors) throws Exception{

        String[] result=new String[lines.length];

        for(int i=0 ;i<lines.length;i++) {

            result[i] = "";

            String line = lines[i];

            result[i] = calculateLine(rotors.get(i), line);

        }

        return result;
    }

    private String calculateLine(int[] rotor, String line) throws Exception {

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

            result=calculateNextLineValue(line,numberOfflaps,rotorIndex);

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

    private String calculateNextLineValue(String line, int numberOfFlaps, int rotorIndex){

        StringBuffer stepLine = new StringBuffer();
        stepLine.append(line);

        for (int position = rotorIndex; position < line.toCharArray().length; position++) {

            char characterToModify = line.toCharArray()[position];

            Character nextCharacter = extractNextCharacter(characterToModify, numberOfFlaps);

            stepLine.setCharAt(position,nextCharacter);
        }

        return stepLine.toString();

    }

    //-------------------------------------------------------------------------------------------------------------------

    public ArrayList<int[]> calculateLinesMoves(String[] before,String[] after) throws Exception{

        ArrayList<int[]> listRotors = new ArrayList<int[]>();

        for(int postionLine=0;postionLine<before.length;postionLine++){

            int[] rotormoves =calculateLineMove(before[postionLine],after[postionLine]);
            listRotors.add(rotormoves);
        }
        return listRotors;

    }

    private int[] calculateLineMove(String before,String after) throws Exception {

        if(before==null || before.length()==0){
            throw new Exception("the line is empty");
        }

        if(after==null || after.length()==0){
            throw new Exception("the result line is empty");
        }

        int[] rotor=new int[before.length()];

        for(int step=0; step<after.toCharArray().length;step++){

            int flap = calculateStepFlap(step,before,after,rotor);
            rotor[step] = flap;
        }

        return  rotor;
    }

    private int calculateStepFlap(int step,String before,String after,int[] previousNumberOfFlaps){

        Character oldChar = before.charAt(step);
        Character newChar = after.charAt(step);

        int numberOfFlaps = getNewCharNumberOfFlaps(oldChar,newChar,previousNumberOfFlaps);

        return numberOfFlaps;
    }

    private int getNewCharNumberOfFlaps(Character oldChar,Character newChar,int[] previousNumberOfFlaps){

        int index=ALPHABET.indexOf(oldChar);

        index = index +sumPreviousFlaps(previousNumberOfFlaps);

        if(index > ALPHABET.length()){
            index= (index +sumPreviousFlaps(previousNumberOfFlaps)) -ALPHABET.length();
        }

        int newIndex=ALPHABET.indexOf(newChar);

        int numberOfFlaps=0;

        if(newIndex<index){
            numberOfFlaps = (ALPHABET.length() - index) + newIndex;
        }
        else {
            if (newIndex > index) {
                numberOfFlaps = newIndex - index;
            }
        }


        return numberOfFlaps;

    }

    private int sumPreviousFlaps(int[] previousNumberOfFlaps){

        int previousFlaps=0;

        for(int previousFlap : previousNumberOfFlaps) {
            previousFlaps +=previousFlap;
        }
        return previousFlaps;
    }
}
