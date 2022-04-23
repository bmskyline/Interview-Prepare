class Codec() {
    var map : HashMap<String, String>
    init {
        map = HashMap<String, String>()
    }
    // Encodes a URL to a shortened URL.
    fun encode(longUrl: String): String {
        val key = longUrl.hashCode().toString()
        map.put(key, longUrl)
        return key
    }

    // Decodes a shortened URL to its original URL.
    fun decode(shortUrl: String): String {
        return map.`get`(shortUrl) ?: ""
    }
}

/**
 * Your Codec object will be instantiated and called as such:
 * var obj = Codec()
 * var url = obj.encode(longUrl)
 * var ans = obj.decode(url)
 */