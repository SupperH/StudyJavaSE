package 二叉搜索树;

public  class BSTNode<k,V>{
    public k key;
    public V value;
    public BSTNode<k,V> left;
    public BSTNode<k,V> right;


    public BSTNode(k key){
        this.key=key;
    }
    public BSTNode(k key , V value){
        this.key=key;
        this.value=value;
    }
    public BSTNode(k key, V value, BSTNode<k,V> left, BSTNode<k,V> right){
        this.key=key;
        this.value=value;
        this.left=left;
        this.right=right;
    }
}
