package lab4.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    static class Node {
        private int data;
        private Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public int getData() {
            return data;
        }

        public void insert(int data) {
            if (data <= this.data) {
                if (this.left == null) {
                    this.left = new Node(data);
                }
                else {
                    left.insert(data);
                }
            }
            else {
                if (this.right == null) {
                    this.right = new Node(data);
                }
                else {
                    right.insert(data);
                }
            }
        }

        public void centerPass(List<Integer> list) {
            if (this.left != null) {
                this.left.centerPass(list);
            }
            list.add(this.data);
            if (this.right != null) {
                this.right.centerPass(list);
            }
        }

        public void straightPass(List<Integer> list) {
            list.add(this.data);
            if (this.left != null) {
                this.left.straightPass(list);
            }
            if (this.right != null) {
                this.right.straightPass(list);
            }
        }

        public void reversePass(List<Integer> list) {
            if (this.left != null) {
                this.left.reversePass(list);
            }
            if (this.right != null) {
                this.right.reversePass(list);
            }
            list.add(this.data);
        }

        public int maxDepth() {
            int leftNodeHeight = 1;
            int rightNodeHeight = 1;
            if (this.left != null) {
                leftNodeHeight = this.left.maxDepth() + 1;
            }
            if (this.right != null) {
                rightNodeHeight = this.right.maxDepth() + 1;
            }
            return Math.max(leftNodeHeight, rightNodeHeight);
        }
    }

    private Node root;

    public BinaryTree() {
        root = null;
    }

    public void insert(int data) {
        if (root == null) {
            root = new Node(data);
        }
        else{
            root.insert(data);
        }
    }

    public List<Integer> centerPass() {
        if (root == null) {
            throw new NullPointerException("Root is null");
        }
        List<Integer> list = new ArrayList<Integer>();
        root.centerPass(list);
        return list;
    }

    public List<Integer> straightPass() {
        if (root == null) {
            throw new NullPointerException("Root is null");
        }
        List<Integer> list = new ArrayList<Integer>();
        root.straightPass(list);
        return list;
    }

    public List<Integer> reversePass() {
        if (root == null) {
            throw new NullPointerException("Root is null");
        }
        List<Integer> list = new ArrayList<Integer>();
        root.reversePass(list);
        return list;
    }

    public int length() {
        if (root == null) { throw new NullPointerException("Root is null"); }
        return this.centerPass().size();
    }

    public int maxDepth() {
        if (root == null) { throw new NullPointerException("Root is null"); }

        return root.maxDepth();
    }
}
