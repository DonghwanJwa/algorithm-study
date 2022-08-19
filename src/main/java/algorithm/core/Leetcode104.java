package algorithm.core;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

class Treenode {
    int val;
    Treenode left;
    Treenode right;

    Treenode() {
    }

    Treenode(int val) {
        this.val = val;
    }

    Treenode(int val, Treenode left, Treenode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Leetcode104 {
    public static void main(String[] args) throws IOException {


        Treenode a = new Treenode(15);
        Treenode b = new Treenode(7);
        Treenode c = new Treenode(20, a, b);
        Treenode d = new Treenode(9);
        Treenode e = new Treenode(3, d, c);

        System.out.println(maxDepth(e));

    }

    static int maxDepth(Treenode root) {

        int result = 0;
        Map<Integer, Vector<Treenode>> tree = new HashMap<>();
        if(root != null) {
            result++;
            Vector<Treenode> def = new Vector<>();
            def.add(root);
            tree.put(result,def);
            while (true) {
                boolean leaf = true;
                Vector<Treenode> vecBinary = new Vector<>();
                for(Treenode tmp : tree.get(result)){
                    if(tmp.left != null) {
                        vecBinary.add(tmp.left);
                        leaf = false;
                    }
                    if(tmp.right != null) {
                        vecBinary.add(tmp.right);
                        leaf = false;
                    }
                }

                if(leaf) {
                    break;
                }else{
                    result++;
                    tree.put(result, vecBinary);
                }
            }
        }

        return result;
    }
}
