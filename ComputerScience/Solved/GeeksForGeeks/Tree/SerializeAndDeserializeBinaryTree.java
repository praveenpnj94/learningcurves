//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/solution/



import java.util.*;
import java.util.LinkedList;

class Tree{
    int data;
    Tree left,right;
    Tree(int d){
        data=d;
        left=right=null;
    }
}
class GFG{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            Tree root=null;
            if(n==1){
                System.out.println(sc.nextInt());
                n--;
            }
            while(n-->0){
                int n1=sc.nextInt();
                int n2=sc.nextInt();
                char lr=sc.next().charAt(0);
                if(root==null){
                    root=new Tree(n1);
                    switch(lr){
                        case 'L':root.left=new Tree(n2);
                            break;
                        case 'R':root.right=new Tree(n2);
                            break;
                    }
                }
                else{
                    insert(n1,n2,lr,root);
                }
            }
            ArrayList<Integer> aa=new ArrayList<Integer>();
            Txt g=new Txt();
            String s=g.serialize(root,aa);
            Tree root1=g.deSerialize(s);
            inorder(root1);
            System.out.println();
        }
    }
    public static void inorder(Tree root){
        if(root==null)
            return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void insert(int n1,int n2,char lr,Tree root){
        if(root==null){
            return;
        }
        if(root.data==n1){
            switch(lr){
                case 'L':root.left=new Tree(n2);
                    break;
                case 'R':root.right=new Tree(n2);
                    break;
            }
        }
        insert(n1,n2,lr,root.left);
        insert(n1,n2,lr,root.right);
    }
}
/*This is a function problem.You only need to complete the function given below*/
/*Complete the given function
Node is as follows:
class Tree{
	int data;
	Tree left,right;
	Tree(int d){
		data=d;
		left=right=null;
	}
}*/
class Txt{
    public String serialize(Tree root,ArrayList<Integer> aa) {
        LinkedList<Tree> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            Tree h = q.poll();
            if (h == null) {
                aa.add(-999);
            } else {
                aa.add(h.data);
                q.offer(h.left);
                q.offer(h.right);
            }
        }

        String res ="";
        for(int i:aa){
            res=res+i+" ";
        }
        return res;
    }

    public Tree deSerialize(String data) {
        String[] a = data.split(" ");
        int l = a.length;
        int[] arr = new int[l];
        int j=0;
        for(String s:a){
            arr[j] = Integer.parseInt(a[j]);
            j++;
        }
        if (arr[0]==-999) {
            return null;
        }

        Tree root = new Tree(arr[0]);
        LinkedList<Tree> q = new LinkedList<>();
        q.offer(root);

        int i = 1;

        while (!q.isEmpty()) {
            Tree h = q.poll();
            if (h != null) {
                Tree left = null;
                if (arr[i]!=-999) {
                    left = new Tree(arr[i]);
                }
                h.left = left;
                q.offer(left);
                i++;

                Tree right = null;
                if (arr[i]!=-999) {
                    right = new Tree(arr[i]);
                }
                h.right = right;
                q.offer(right);
                i++;
            }
        }

        return root;
    }
}

public class Codec {
  public TreeNode rdeserialize(List<String> l) {
    // Recursive deserialization.
    if (l.get(0).equals("null")) {
      l.remove(0);
      return null;
    }

    TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
    l.remove(0);
    root.left = rdeserialize(l);
    root.right = rdeserialize(l);

    return root;
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    String[] data_array = data.split(",");
    List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
    return rdeserialize(data_list);
  }
}


// Serialization
public class Codec {
  public String rserialize(TreeNode root, String str) {
    // Recursive serialization.
    if (root == null) {
      str += "null,";
    } else {
      str += str.valueOf(root.val) + ",";
      str = rserialize(root.left, str);
      str = rserialize(root.right, str);
    }
    return str;
  }

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    return rserialize(root, "");
  }
}