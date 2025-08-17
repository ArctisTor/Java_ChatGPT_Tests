package org.fearless.cipher;

public class CipherProblem {

    public static void main(String[] args){;
    }

    public static String cipherText(String cipherText, String originalWord) {
        String response = "Invalid Text";
        int shiftDifference = -1;

        if (!cipherText.isEmpty()) {

            String[] cipherWords = cipherText.split("\\s+"); //break it apart by words
            for (String cipherWord: cipherWords) {
                //share the same length. Might be the original word
                if (cipherWord.length() == originalWord.length()) {
                    for (int i = 0; i < cipherWord.length(); i++) {
                        char c = cipherWord.charAt(i);
                        char o = originalWord.charAt(i);
                        int tempShift = 0;

                        //we only care about letters
                        if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                            if (Character.isUpperCase(c) && Character.isUpperCase(o)) {
                                tempShift = (c - o + 26) % 26;
                            } else if (Character.isLowerCase(c) && Character.isLowerCase(o)) {
                                tempShift = (c - o + 26) % 26;
                            }

                            if (shiftDifference == -1) {
                                shiftDifference = tempShift;
                            } else if (shiftDifference != tempShift) {
                                shiftDifference = -1; //reset the value and break the loop. This is not the same word
                                break;
                            }
                        }
                    }
                }
            }

            if (shiftDifference >= 0) {
                StringBuilder originalText = new StringBuilder();
                for (int w = 0; w < cipherWords.length; w++) {
                    String cipherWord = cipherWords[w];
                    for (int i = 0; i < cipherWord.length(); i++) {
                        char c = cipherWord.charAt(i);
                        char originalChar = c;

                        //we only care about letters
                        if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                            if (Character.isUpperCase(c)) {
                                int offset = c - 'A';
                                int newOffset = (offset - shiftDifference + 26) % 26;
                                originalChar =  (char) ('A' + newOffset);
                            } else if (Character.isLowerCase(c)) {
                                int offset = c - 'a';
                                int newOffset = (offset - shiftDifference + 26) % 26;
                                originalChar =  (char) ('a' + newOffset);
                            }
                        }

                        // else leave it unchanged (punctuation, digits, etc.)
                        originalText.append(originalChar);
                    }

                    if (w < cipherWords.length - 1) {
                        originalText.append(" ");
                    }
                }

                return originalText.toString(); //This should be the original text.
            }
        }


        return response;
    }
}
