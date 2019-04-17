// Homework 8, problem #6
// Give a linear time algorithm to determine whether some
// string T is a cyclic rotation of another string T' 
public class CyclicRotation {
    
    static boolean isRotation(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        
        int SIZE = b.length();
        
        // concatenate
        String s = a + b;
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.substring(i, i + SIZE).equals(b)) {
                return true;
            }
        }
        return false;
    }
	
    public static void main(String[] args) {
	    System.out.println(isRotation("rat", "tar"));
    }
}
