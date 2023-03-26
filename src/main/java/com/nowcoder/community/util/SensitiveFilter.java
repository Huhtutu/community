package com.nowcoder.community.util;

import org.apache.ibatis.javassist.bytecode.stackmap.BasicBlock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Component
public class SensitiveFilter {

    private static final Logger logger = LoggerFactory.getLogger(SensitiveFilter.class);

    //替换符
    private static final String REPLACEMENT = "***";

    //根节点
    private TrieNode rootnode = new TrieNode();

    @PostConstruct
    public void init(){
        try(
                InputStream is = this.getClass().getClassLoader().getResourceAsStream("sensitive-words.txt");
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                ){

        }catch (IOException e){
            logger.error("加载敏感词文件失败!"+e.getMessage());
            e.printStackTrace();
        }


    }
    //前缀树
    private class TrieNode{

        //关键字结束标识
        private boolean isKeywordEnd = false;

        //子节点(key下级字符,value是下级节点)
        private Map<Character,TrieNode> subNodes = new HashMap<>();
        public boolean isKeywordEnd() {
            return isKeywordEnd;
        }

        public void setKeywordEnd(boolean keywordEnd) {
            isKeywordEnd = keywordEnd;
        }

        //添加子节点
        public void addSubNode(Character c, TrieNode node){
            subNodes.put(c,node);
        }

        //获取子节点
        public  TrieNode getSubNode(Character c){
            return subNodes.get(c);
        }
    }
}
