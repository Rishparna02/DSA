//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class InorderPostorderToTree {
    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        InorderPostorderToTree ip = new InorderPostorderToTree();
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int inorder[] = new int[n];
            int postorder[] = new int[n];
            for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++) postorder[i] = sc.nextInt();
            GfG g = new GfG();
            Node root = g.buildTree(inorder, postorder, n);
            ip.preOrder(root);
            System.out.println();

            T--;
        }
    }
}

// } Driver Code Ends


/* Tree node structure
class Node
{
    int data;
    Node left;
    Node right;

        Node(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}*/


class GfG
{
    private static Node solve(int[] in, int[] post, int[] postindex, int instart, int inend, int n){
        if (postindex[0]<0 || instart>inend){
            return null;
        }
        int x=post[postindex[0]--];
        Node root = new Node(x);
        int position = pos(in,instart,inend,x);
        root.right=solve(in,post,postindex,position+1, inend, n);
        root.left=solve(in, post, postindex,instart,position-1,n);
        return root;
    }
    private static int pos(int[] in, int instart, int inend, int x){
        for (int i =instart; i<= inend; i++){
            if (in[i]==x){
                return i;
            }
        }
        return -1;
    }
    //Function to return a tree created from postorder and inoreder traversals.
    Node buildTree(int in[], int post[], int n) {
        int[] postindex= new int[]{n-1};
        return solve(in,post,postindex,0,n-1,n);
    }
}
