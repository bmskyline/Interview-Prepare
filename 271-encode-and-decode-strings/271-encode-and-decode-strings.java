public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for(String s : strs) {
            res.append(s).append((char) 258);
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        String d = Character.toString((char)258);
        String[] arr = s.split(d, -1);
        return Arrays.asList(arr);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));