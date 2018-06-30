package shuati.Design;

import java.util.ArrayList;
import java.util.List;


/**
 * TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it
 * returns a short URL such as http://tinyurl.com/4e9iAk.

 Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode
 algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.


 */
public class TinyUrl {
  private List<String> _urls = new ArrayList<>();

  // Encodes a URL to a shortened URL.
  public String encode(String longUrl) {
    _urls.add(longUrl);
    return String.valueOf(_urls.size() - 1);
  }

  // Decodes a shortened URL to its original URL.
  public String decode(String shortUrl) {
    int ind = Integer.valueOf(shortUrl);
    return ind < _urls.size() ? _urls.get(ind) : "";
  }
}
