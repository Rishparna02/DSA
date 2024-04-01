//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.charAt(0) == 'N') return null;

        // Creating array of Strings from input
        // String after spliting by space
        String ip[] = str.split(" ");

        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));

        // Push the root to the queue
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // Starting from the second element
        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static Node inputTree(BufferedReader br) throws IOException {
        return buildTree(br.readLine().trim());
    }

    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            Node root = Node.inputTree(br);

            Solution obj = new Solution();
            int res = obj.pairsViolatingBST(n, root);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    static int ans =0;
    static void merge (int arr[], int low, int mid, int high){
    int a = mid-low+1;
    int b = high-mid;
    int arr1[] = new int[a];
    int arr2[] = new int[b];
    for (int i=0; i<a; i++) arr1[i]=arr[low+i];
    for (int i= 0; i<b; i++) arr2[i]=arr[mid+i+1];
    int i=0, k=low, j=0;
    while(i<a && j<b){
        if (arr1[i]<=arr2[j]){
            arr[k]=arr1[i];
            i++;
        }
        else {
            ans += a-i;
            arr[k]=arr2[j];
            j++;
        }
        k++;
    }
    while (i<a){
        arr[k++]=arr1[i++];
    }
    while(j<b){
        arr[k++]=arr2[j++];
    }
}
static void mergeSort(int arr[], int low, int high){
    if (low>=high) return;
    int mid = (low+high)/2;
    mergeSort(arr,low,mid);
    mergeSort(arr,mid+1,high);
    merge(arr,low,mid,high);
}
static void help(Node root, ArrayList<Integer> nodes){
    if (root == null) return;
    help(root.left,nodes);
    nodes.add(root.data);
    help(root.right,nodes);
}
    public static int pairsViolatingBST(int n, Node root) {
        ans =0;
        ArrayList<Integer> nodes = new ArrayList<>();
        help(root,nodes);
        int arr[] = new int[nodes.size()];
        for (int i=0; i<nodes.size(); i++) arr[i]= nodes.get(i);
        mergeSort(arr,0,n-1);
        return ans;
    }
}
