package tree._1804;

import java.util.LinkedList;
import java.util.List;

public class Trie {
    TrieMap<Integer> map = new TrieMap<>();
    public void insert(String word) {
        if (!map.containsKey(word)) {
            map.put(word, 1);
        }
        else {
            map.put(word, map.get(word) + 1);
        }
    }
    public int countWordsEqualTo(String word) {
        if (!map.containsKey(word)) {
            return 0;
        }
        return map.get(word);
    }
    public int countWordsStartingWith(String prefix) {
        int res = 0;
        for (String key : map.keysWithPrefix(prefix)) {
            res += map.get(key);
        }
        return res;
    }
    public void erase(String word) {
        int freq = map.get(word);
        if (freq - 1 == 0) {
            map.remove(word);
        }
        else {
            map.put(word, freq - 1);
        }
    }
}
class TrieSet {
    private final TrieMap<Object> map = new TrieMap<>();
    public void add(String key) {
        map.put(key, new Object());
    }
    public void remove(String key) {
        map.remove(key);
    }
    public boolean contains(String key) {
        return map.containsKey(key);
    }
    public String shortestPrefixOf(String query) {
        return map.shortestPrefixOf(query);
    }
    public String longestPrefixOf(String query) {
        return map.longestPrefixOf(query);
    }
    public List<String> keysWithPrefix(String prefix) {
        return map.keysWithPrefix(prefix);
    }
    public boolean hasKeyWithPrefix(String prefix) {
        return map.hasKeyWithPrefix(prefix);
    }
    public List<String> keysWithPattern(String pattern) {
        return map.keysWithPattern(pattern);
    }
    public boolean hasKeyWithPattern(String pattern) {
        return map.hasKeyWithPattern(pattern);
    }
    public int size() {
        return map.size();
    }
}
class TrieMap<V>{
    private static final int R = 256;
    private int size = 0;
    private TrieMap.TrieNode<V> root = null;
    private static class TrieNode<V> {
        V val = null;
        TrieMap.TrieNode<V>[] children = new TrieMap.TrieNode[R];
    }
    public void put(String key, V val){
        if (!containsKey(key))
            size++;
        root = put(root, key, val, 0);
    }
    private TrieMap.TrieNode<V> put(TrieMap.TrieNode<V> node, String key, V val, int i) {
        if (node == null) {
            node = new TrieMap.TrieNode<>();
        }
        if (i == key.length()) {
            node.val = val;
            return node;
        }
        char c = key.charAt(i);
        node.children[c] = put(node.children[c], key, val, i + 1);
        return node;
    }
    public void remove(String key) {
        if (!containsKey(key)) {
            return;
        }
        root = remove(root, key, 0);
        size--;
    }
    private TrieMap.TrieNode<V> remove(TrieMap.TrieNode<V> node, String key, int i) {
        if (node == null) {
            return null;
        }
        if (i == key.length()) {
            node.val = null;
        } else {
            char c = key.charAt(i);
            node.children[c] = remove(node.children[c], key, i + 1);
        }
        if (node.val != null) {
            return node;
        }
        for (int c = 0; c < R; c++) {
            if (node.children[c] != null) {
                return node;
            }
        }
        return null;
    }
    public V get(String key) {
        TrieMap.TrieNode<V> x = getNode(root, key);
        if (x == null || x.val == null) {
            return null;
        }
        return x.val;
    }
    public boolean containsKey(String key) {
        return get(key) != null;
    }
    public boolean hasKeyWithPrefix(String prefix) {
        return getNode(root, prefix) != null;
    }
    public String shortestPrefixOf(String query) {
        TrieMap.TrieNode<V> p = root;
        for (int i = 0; i < query.length(); i++) {
            if (p == null) {
                return "";
            }
            if (p.val != null) {
                return query.substring(0, i);
            }
            char c = query.charAt(i);
            p = p.children[c];
        }
        if (p != null && p.val != null) {
            return query;
        }
        return "";
    }
    public String longestPrefixOf(String query) {
        TrieMap.TrieNode<V> p = root;
        int max_len = 0;
        for (int i = 0; i < query.length(); i++) {
            if (p == null) {
                break;
            }
            if (p.val != null) {
                max_len = i;
            }
            char c = query.charAt(i);
            p = p.children[c];
        }
        if (p != null && p.val != null) {
            return query;
        }
        return query.substring(0, max_len);
    }
    public List<String> keysWithPrefix(String prefix) {
        List<String> res = new LinkedList<>();
        TrieMap.TrieNode<V> x = getNode(root, prefix);
        if (x == null) {
            return res;
        }
        traverse(x, new StringBuilder(prefix), res);
        return res;
    }
    private void traverse(TrieMap.TrieNode<V> node, StringBuilder path, List<String> res) {
        if (node == null) {
            return;
        }
        if (node.val != null) {
            res.add(path.toString());
        }
        for (char c = 0; c < R; c++) {
            path.append(c);
            traverse(node.children[c], path, res);
            path.deleteCharAt(path.length() - 1);
        }
    }
    public List<String> keysWithPattern(String pattern) {
        List<String> res = new LinkedList<>();
        traverse(root, new StringBuilder(), pattern, 0, res);
        return res;
    }
    private void traverse(TrieMap.TrieNode<V> node, StringBuilder path, String pattern, int i, List<String> res) {
        if (node == null) {
            return;
        }
        if (i == pattern.length()) {
            if (node.val != null) {
                res.add(path.toString());
            }
            return;
        }
        char c = pattern.charAt(i);
        if (c == '.') {
            for (char j = 0; j < R; j++) {
                path.append(j);
                traverse(node.children[j], path, pattern, i + 1, res);
                path.deleteCharAt(path.length() - 1);
            }
        } else {
            path.append(c);
            traverse(node.children[c], path, pattern, i + 1, res);
            path.deleteCharAt(path.length() - 1);
        }
    }
    public boolean hasKeyWithPattern(String pattern) {
        return hasKeyWithPattern(root, pattern, 0);
    }
    private boolean hasKeyWithPattern(TrieMap.TrieNode<V> node, String pattern, int i) {
        if (node == null) {
            return false;
        }
        if (i == pattern.length()) {
            return node.val != null;
        }
        char c = pattern.charAt(i);
        if (c != '.') {
            return hasKeyWithPattern(node.children[c], pattern, i + 1);
        }
        for (int j = 0; j < R; j++) {
            if (hasKeyWithPattern(node.children[j], pattern, i + 1)) {
                return true;
            }
        }
        return false;
    }
    private TrieMap.TrieNode<V> getNode(TrieMap.TrieNode<V> node, String key) {
        TrieMap.TrieNode<V> p = node;
        for (int i = 0; i < key.length(); i++) {
            if (p == null) {
                return null;
            }
            char c = key.charAt(i);
            p = p.children[c];
        }
        return p;
    }
    public int size() {
        return size;
    }
}
class TrieNode<V>{
    V val;
    TrieNode<V>[] children = new TrieNode[256];
}