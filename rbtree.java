class Node{
    int data;
    int color;
    Node left;
    Node right;
    Node parent;
}
public class rbtree {
    Node TNULL;
    Node root;
    
    public rbtree(){
        TNULL = new Node();
        TNULL.color = 0;
        TNULL.left = null;
        TNULL.right = null;
        TNULL.parent = null;
        root = TNULL;
    }

    public void leftrotation(Node x)
    {
        Node y = x.right;
        x.right = y.left;
        if(y.left!=TNULL){
            y.left.parent = x;
        }
        y.parent = x.parent;
        if(x.parent == null){
            this.root = y;
        } else if(x == x.parent.left){
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    public void rightrotation(Node x)
    {
        Node y = x.left;
        x.left = y.right;
        if(y.right!=TNULL){
            y.right.parent = x;
        }
        y.parent = x.parent;
        if(x.parent == null){
            this.root = y;
        } else if (x == x.parent.right){
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    public void fixInsert(Node node)
    {
        System.out.println(node.data);
        Node uncle;
        while(node.parent.color == 1){
            if(node.parent==node.parent.parent.right){
                uncle = node.parent.parent.right;
                if(uncle.color==1){
                    uncle.color = 0;
                    node.parent.color = 0;
                    node.parent.parent.color = 1;
                    node = node.parent.parent;
                }
                else{
                    if(node == node.parent.left){
                        node = node.parent;
                        rightrotation(node);
                    }
                    node.parent.color = 0;
                    node.parent.parent.color = 1;
                    leftrotation(node.parent.parent);
                }
            }
            else{
                uncle = node.parent.parent.left;
                if(uncle.color==1){
                    uncle.color = 0;
                    node.parent.color = 0;
                    node.parent.parent.color = 1;
                    node = node.parent.parent;
                }
                else{
                    if(node == node.parent.right){
                        node = node.parent;
                        leftrotation(node);
                    }
                    node.parent.color = 0;
                    node.parent.parent.color = 1;
                    rightrotation(node.parent.parent);
                }
            }
            if(node==root){
                break;
            }
        }
        root.color=0;
    }

    public void insertion(int key){
        Node node = new Node();
        node.data = key;
        node.color = 1;
        node.left = TNULL;
        node.right = TNULL;
        node.parent = TNULL;

        Node y = null;
        Node x = this.root;

        while(x!=TNULL){
            y=x;
            if(node.data<x.data){
                x=x.left;
            }
            else{
                x=x.right;
            }
        }
        node.parent = y;
        if(y==null){
            root=node;
        }
        else if(node.data<y.data){
            y.left = node;
        } else {
            y.right = node;
        }

        if(node.parent == null){
            node.color = 0;
            return;
        }
        if(node.parent.parent == null){
            return;
        }
        fixInsert(node);
    }
    private void printHelper(Node root, String indent, boolean last) {
        if (root != TNULL) {
          System.out.print(indent);
          if (last) {
            System.out.print("R----");
            indent += "   ";
          } else {
            System.out.print("L----");
            indent += "|  ";
          }
    
          String sColor = root.color == 1 ? "RED" : "BLACK";
          System.out.println(root.data + "(" + sColor + ")");
          printHelper(root.left, indent, false);
          printHelper(root.right, indent, true);
        }
    }

    public void printTree() {
        printHelper(this.root, "", true);
    }

    public static void main(String args[]){
        rbtree r = new rbtree();
        r.insertion(10);
        r.insertion(18);
        r.insertion(7);
        r.insertion(15);
        r.insertion(16);
        r.printTree();
    }

}
