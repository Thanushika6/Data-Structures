
class Node{
    int data;
    Node right, left;
    
    public Node(int data){
        this.data = data;
        right=left=null;
    }
} //class and constructor 

class BinarySearchTree{
    Node root;
    
    //insertion
    public Node insert(Node root, int data){
        if(root== null){
            return new Node(data);
        }
        if(data<root.data){
            root.left = insert(root.left,data);
        }
        else if(data>root.data)
        {
            root.right=insert(root.right,data);
            
        }
        return root;
        
    }
    
    //deletion
    
    public Node delete(Node root, int key){
        if(root == null){
            return root;
        }
        
        if(key<root.data){
            root.left=delete(root.left, key);
        }
        else if(key>root.data){
            root.right = delete(root.right, key);
        }
        else{
            //no child
            if(root.right == null && root.left == null){
                return null;
            }
            //one child
            if(root.right==null){
                return root.left;
            }
            if(root.left==null){
                return root.right;
            }
            //two child
            Node min = findMin(root.right);//finding the min value on right
            root.data = min.data; // the min value will be replaced in the root node
            root.right=delete(root.right,min.data);//deleting the right node
        }
        return root;
    }
        //finding the minimum
        public Node findMin(Node root){
            while(root.left!=null){
                root = root.left;
            }
            return root;
        }
    
        
        //inorder traversal
        
        public void inorder(Node root){
            if(root!=null){
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
            }
        }
        
        //preorder traversal
        
        public void preorder(Node root){
            if(root!=null){
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
            }
        }
        
        //postorder traversal
        
        public void postorder(Node root){
            if(root!=null){
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
        }
}
    

public class Main{
    public static void main(String[] args){
        
        BinarySearchTree obj = new BinarySearchTree();
       obj.root = obj.insert(obj.root, 50);
       obj.insert(obj.root,45);
      obj.insert(obj.root,40);
       obj.insert(obj.root,60);
       obj.insert(obj.root,55);
       obj.insert(obj.root,65);
       obj.insert(obj.root,48);
        System.out.println("Inorder after insertion");
        obj.inorder(obj.root);
        System.out.println("\nPreorder:");
        obj.preorder(obj.root);
        System.out.println("\nPostorder:");
        obj.postorder(obj.root);
        obj.root = obj.delete(obj.root, 60);
        System.out.println("\nInorder after deleting 60:");
        obj.inorder(obj.root);
        System.out.println("\nPreorder after deleting 60:");
        obj.preorder(obj.root);
        System.out.println("\nPostorder after deleting 60:");
        obj.postorder(obj.root);
    }
}
