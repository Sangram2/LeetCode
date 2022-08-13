// class Solution {
//     public List<Integer> findSubstring(String s, String[] words) {
//         HashMap<String,Integer> freq = new HashMap<>();
//         int n = words[0].length();
        
//         for(String w:words){
//             freq.put(freq.getOrDefault(w,0)+1);
//         }
        
//         HashMap<String,Integer> copy = freq;
//         int i = 0;
//         while(i<(s.length()-(n*words.length)))
        
//     }
// }
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        final Map<String, Integer> counts = new HashMap<>();
        for (final String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        final List<Integer> indexes = new ArrayList<>();
        final int n = s.length(), num = words.length, len = words[0].length();
        for (int i = 0; i < n - num * len + 1; i++) {
            final Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            while (j < num) {
                final String word = s.substring(i + j * len, i + (j + 1) * len);
                if (counts.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    if (seen.get(word) > counts.getOrDefault(word, 0)) {
                        break;
                    }
                } else {
                    break;
                }
                j++;
            }
            if (j == num) {
                indexes.add(i);
            }
        }
        return indexes;
    }
}