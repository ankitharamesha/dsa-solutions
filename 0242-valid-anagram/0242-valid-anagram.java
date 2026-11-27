class Solution {
    public boolean isAnagram(String s, String t) {
     char[] sArr = s.toCharArray();
     char[] tArr = t.toCharArray();

     if(s.length()!= t.length()){
       
    
    
      return false;
 }
  Arrays.sort(sArr);
     Arrays.sort(tArr);
 return Arrays.equals(sArr, tArr);
    }
}