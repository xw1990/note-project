package lru;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * Description:
 *
 * @author liuwuchao
 * @date 2020/4/22-5:14 PM
 */
public class LRUCache {
    private Integer count;
    private Integer capacity;
    private Hashtable<String,LNode> cache = new Hashtable<>();
    private LNode head,tail;

    public LRUCache(Integer capacity) {
        this.capacity = capacity;
        this.count = 0;
        //初始头
        this.head = new LNode();
        head.pre = null;
        //初始尾
        this.tail = new LNode();
        tail.next = null;

        head.next = tail;
        tail.pre = head;
    }


    public void set(String key,String val){
        LNode node = cache.get(key);
        if (node == null){
            LNode newNode = new LNode();
            newNode.value = val;
            newNode.key = key;
            cache.put(key,newNode);
            this.addNode(newNode);
            ++count;
            if (count > capacity){
                LNode tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
            }
        }else {
            node.value = val;
            this.moveNodeToHead(node);
        }
    }

    public String get(String key){
        LNode node = cache.get(key);
        if (node == null){
            return null;
        }
        this.moveNodeToHead(node);
        return node.value;
    }

    private void addNode(LNode node){
        node.pre = head;
        node.next = head.next;

        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(LNode node){
        LNode next = node.next;
        LNode pre = node.pre;


        next.pre = pre;
        pre.next = next;
    }

    private void moveNodeToHead(LNode node){
        this.removeNode(node);
        this.addNode(node);
    }

    private LNode popTail(){
        LNode node = tail.pre;
        this.removeNode(node);
        return node;
    }

    @Override
    public String toString() {
        LNode tmp = head.next;
        String str = "LRUCache{";
        while (tmp.next != null){
            str += tmp.key + "=" + tmp.value + ",";
            tmp = tmp.next;
        }
        return str.substring(0,str.length() -1) + "}";
    }
}
