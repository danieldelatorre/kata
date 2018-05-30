package com.project.kata.airport;

import java.util.ArrayList;

public class Airport {

    private final String ALPHABET ="ABCDEFGHIJKLMNOPQRSTUVWXYZ ?!@#&()|<>.:=-+*/0123456789";

    public String[] calculateLines(String[] lines, ArrayList<int[]> rotors) throws Exception{

        String[] result=new String[lines.length];

        for(int i=0 ;i<lines.length;i++) {

            result[i] = "";

            String line = lines[i];

            if(!line.isEmpty()) {

                for (int f = 0; f < rotors.get(i).length; f++) {

                    int flap = rotors.get(i)[f];

                    if(flap>0) {
                        if (result[i].length() == line.length()) {

                            line = result[i];
                            result[i] = result[i].substring(0, f);
                        }

                        for (int l = f; l < line.toCharArray().length; l++) {

                            int first_apparition = ALPHABET.indexOf(line.toCharArray()[l]);

                            char[] partial_alphabet = null;

                            if (ALPHABET.length() >= first_apparition * 2 + flap + 1) {
                                partial_alphabet = ALPHABET.substring(first_apparition, first_apparition + flap + 1).toCharArray();
                            } else {
                                int position = flap - (ALPHABET.length() - first_apparition);
                                partial_alphabet = ALPHABET.substring(0, position + 1).toCharArray();
                            }

                            result[i] += Character.toString(partial_alphabet[partial_alphabet.length - 1]);
                        }
                    }else{
                        throw new Exception("the rotors contain a negative value");
                    }
                }
            }
            else{
                throw new Exception("the line format is incorrect");
            }


        }

        return result;
    }

}
