public class Occurences {
    
    /**
     * Count occurrences of a word within a given text
     * @param needle The word to search for
     * @param haystack The text within which to search
     * @param wordSeparators An array of Strings that we should consider as acceptable separators between words, such as {" ", "\n", "\t", ",", ".", "?", "!", etc}
     * @return The number of occurrences of the word within the text.
     */
    public static int findOccurrences(String needle, String haystack, String[] wordSeparators) {
        int occurrences = 0;

        int fromIndex = 0; // the index position within the corpus string from which to start searching
        int matchIndex = haystack.indexOf(needle, fromIndex);
        while (matchIndex != -1) {
            // make sure what comes next is either the separator or the end of the text
            boolean isFalsePositive = true;
            // check whether we have reached the end of the string, so this word is the last thing in the string
            if (matchIndex + needle.length() == haystack.length()) {
                isFalsePositive = false;
            }
            // check whether the next text in the string is a separator
            for (String sep : wordSeparators) {
                if (haystack.indexOf(sep, matchIndex + needle.length()) == matchIndex + needle.length()) {
                    isFalsePositive = false; // it's a good find!
                    break; // quit the loop
                }
            }
            
            if (!isFalsePositive) occurrences++; // we found an occurrences of the search term followed by one of the separators
            fromIndex = matchIndex + needle.length(); // next time, start looking later in string from where we just found it
            matchIndex = haystack.indexOf(needle, fromIndex);
        }

        return occurrences;

    }

    public static void main(String[] args) {
        String[] separators = {" ", "\n", "\t", ".", ".", "?", "!"}; // some standard punctuation that separates words
        String text = "green,fucshia , purple ? green.orange blue green greengreen grass green"; // our test text
        String searchTerm = "blue green"; // the word we are searching for
        int count = findOccurrences(searchTerm, text, separators); // find out how many occurrences there are
        
        System.out.println(String.format("The word, '%s' occurs %d times within the text.", searchTerm, count));
    }    
}
