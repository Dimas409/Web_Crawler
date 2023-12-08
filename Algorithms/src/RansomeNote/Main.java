package RansomeNote;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "aab"));


    }
    /**
     * 383. Ransom Note
     * Given two strings ransomNote and magazine, return true if ransomNote can
     * be constructed by using the letters from magazine and false otherwise.
     *
     * Each letter in magazine can only be used once in ransomNote.
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        // For each character, c,  in the ransom note.
        for (char c : ransomNote.toCharArray()) {
            // Find the index of the first occurrence of c in the magazine.
            int index = magazine.indexOf(c);
            // If there are none of c left in the String, return False.
            if (index == -1) {
                return false;
            }
            // Use substring to make a new string with the characters
            // before "index" (but not including), and the characters
            // after "index".
            magazine = magazine.substring(0, index) + magazine.substring(index + 1);
        }
        // If we got this far, we can successfully build the note.
        return true;
        // Time complexity O(m*n)
        // Space complexity O(m)
    }
}
class Solution {

    // Takes a String, and returns a HashMap with counts of
    // each character.
    private Map<Character, Integer> makeCountsMap(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            int currentCount = counts.getOrDefault(c, 0);
            counts.put(c, currentCount + 1);
        }
        return counts;
    }


    public boolean canConstruct(String ransomNote, String magazine) {

        // Check for obvious fail case.
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        // Make the count maps.
        Map<Character, Integer> ransomNoteCounts = makeCountsMap(ransomNote);
        Map<Character, Integer> magazineCounts = makeCountsMap(magazine);

        // For each unique character, c, in the ransom note:
        for (char c : ransomNoteCounts.keySet()) {
            // Check that the count of char in the magazine is equal
            // or higher than the count in the ransom note.
            int countInMagazine = magazineCounts.getOrDefault(c, 0);
            int countInRansomNote = ransomNoteCounts.get(c);
            if (countInMagazine < countInRansomNote) {
                return false;
            }
        }

        // If we got this far, we can successfully build the note.
        return true;
    }
    public boolean canConstruct2(String ransomNote, String magazine) {
        // Check for obvious fail case.
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        // Make a counts map for the magazine.
        Map<Character, Integer> magazineCounts = makeCountsMap(magazine);

        // For each character in the ransom note:
        for (char c : ransomNote.toCharArray()) {
            // Get the current count for c in the magazine.
            int countInMagazine = magazineCounts.getOrDefault(c, 0);
            // If there are none of c left, return false.
            if (countInMagazine == 0) {
                return false;
            }
            // Put the updated count for c back into magazineCounts.
            magazineCounts.put(c, countInMagazine - 1);
        }

        // If we got this far, we can successfully build the note.
        return true;
    }
}
