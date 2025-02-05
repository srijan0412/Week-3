public class SearchWordInSentences {
    // Method to find a word in an array of sentences 
    public static boolean findWordInSentences(String[] sentences, String word){
        for (int i = 0; i < sentences.length; i++) {
            String sentence[] = sentences[i].split(" ");
            for (int j = 0; j < sentence.length; j++) { 
                if (word.equals(sentence[j])) {
                    return true;
                }
            }
        }
        return false; // word not found case 
    }

    public static void main(String[] args) {
        // Defining a sample array of sentences for testing 
        String sentences[] = {"This is sentence1", "This is sentence2", "This is sentence3"};
        String keyWord = "sentence2";

        // Calling the findWordInSentences() function 
        boolean result = findWordInSentences(sentences, keyWord);

        // Output 
        if (result) {
            System.out.println("The word exists in the sentences");
        }
        else {
            System.out.println("The word does not exist in the sentences.");
        }
    }
}
