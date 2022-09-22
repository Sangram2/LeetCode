class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        String[] arr = s.split(" ");
        for(int i = 0;i<arr.length;i++){
            StringBuilder part = new StringBuilder(arr[i]);
            part = part.reverse();
            ans.append(part);
            ans.append(" ");
        }
        String a = ans.substring(0,ans.length()-1);
        return a;
    }
}