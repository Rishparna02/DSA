/*
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
} */
class Solution {
    public int sumOfLongRootToLeafPath(Node root) {
        // code here
        Queue<Node> que=new LinkedList<>();
       que.add(root);
       int max=0;
       while(que.size()>0){
           
           int size=que.size();
           max=0;
           while(size>0){
               
              Node temp=que.poll();
              if(temp.data>max) max=temp.data;
              if(temp.left!=null){
                  temp.left.data+=temp.data;
                  que.add(temp.left);
              }
              if(temp.right!=null){
                  temp.right.data+=temp.data;
                  que.add(temp.right);
              }
              size--;
           }
       }
       return max;
    }
}