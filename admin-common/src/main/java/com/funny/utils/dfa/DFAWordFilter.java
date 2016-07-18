package com.funny.utils.dfa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Maps;

/**
 * DFA算法过滤
 * 
 * @author funny
 *
 */
public class DFAWordFilter {
    private static Map<String, String> map = Maps.newHashMap();

    private Node rootNode = null;

    public DFAWordFilter(Node node) {
        this.rootNode = node;
    }

    private String content = null;
    /* 存在的敏感词 */
    private List<String> word = new ArrayList<String>();
    private int i = 0;

    private boolean searchWord(char[] chars) {
        Node node = rootNode;
        while (i < chars.length) {
            node = findNode(node, chars[i]);
            if (node == null) {
                node = rootNode;
                i = i - word.size();
                word.clear();
            } else if (node.flag == 1) {
                word.add(String.valueOf(chars[i]));
                StringBuffer sb = new StringBuffer();
                for (String str : word) {
                    sb.append(str);
                }
                word.clear();
                return true;
            } else {
                word.add(String.valueOf(chars[i]));
            }
            i++;
        }
        return false;
    }

    /**
     * 过滤敏感词，并对正则表达式语法处理
     * 
     * @param str
     * @param replacement
     * @return
     */
    private String filterKeyWord$Script(String str, String key, String replacement) {
        this.content = str;
        if (isExistsKey(str, key)) {
            if (replacement == null) {
                replacement = "*";
            }
            this.content = RegexScriptUtils.script(this.content);
            str = this.content.replaceAll(key, replacement);
        }
        content = null;
        return str;
    }

    /**
     * 是否存在敏感词
     * 
     * @param content
     * @param key
     * @return
     */
    private boolean isExistsKey(String content, String key) {
        return searchWord(content.toCharArray());
    }

    private Node findNode(Node node, char c) {
        List<Node> nodes = node.nodes;
        Node rn = null;
        for (Node n : nodes) {
            if (n.c == c) {
                rn = n;
                break;
            }
        }
        return rn;
    }

    /**
     * 
     * @param str
     * @return
     */
    public static String filter(String str) {
        for (Entry<String, String> entry : map.entrySet()) {
            Node node = NodeTree.getNoteTree(new String[] { entry.getKey() });
            str = new DFAWordFilter(node).filterKeyWord$Script(str, entry.getKey(), entry.getValue());
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(filter("习近平123"));
    }
}
