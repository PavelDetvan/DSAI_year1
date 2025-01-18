/*
 * The Complexity is O(n)
 */

import java.util.ArrayList;

public class BinaryTreeUtils {

    static ArrayList<Integer> inOrder = new ArrayList<>();

    /**
     * Checks if the binary tree passed as argument is an AVL
     * @param tree the binary tree to check.
     * @return true if the binary tree in input is an AVL tree, false otherwise
     */
    public static <E extends Comparable<E>> boolean isAVLTree(BinaryTree<E> tree){
        // implement your method here
        if(tree == null){
            return false; 
        }
        if(tree.hasRoot() == false){
            return false;
        }
        if(!tree.getRoot().hasLeftChild() && !tree.getRoot().hasRightChild()){
            return true;
        }
        if(isBST(inOrder) && balanced(tree.getRoot())){
            return true;
        }        
        return false;   
    }

    /**
     * method which check if the tree is balanced
     * Complexity: O(n) for a balanced binary tree where n is number of nodes in the tree 
     * @param <E>
     * @param node node of the tree
     * @return true if the tree is balanced, false otherwise
     */
    public static <E extends Comparable<E>> boolean balanced(BinaryTreeNode<E> node){
        int leftHeight;
        int righHeight;

            inOrderListFill(node);
            if(node == null){
                return true;
            }

            leftHeight = height(node.getLeftChild());
            righHeight = height(node.getRightChild());

            if(Math.abs(leftHeight-righHeight) <= 1 && balanced(node.getLeftChild()) && balanced(node.getRightChild())){
                return true;
            }

            return false;
    }

    /**
     * method to fill the list in order as we go through the tree
     * Complexity: O(n) where n is the number of nodes in the tree
     * @param <E>
     * @param node node of the tree
     */
    public static <E extends Comparable<E>> void inOrderListFill(BinaryTreeNode<E> node){
        if(node == null){
            return;
        }
        inOrderListFill(node.getLeftChild());
        inOrder.add((Integer) node.getElement());
        inOrderListFill(node.getRightChild());
    }

    /**
     * method to check if the tree is binary search tree, checks if the tree is in order/sorted
     * Complexity: O(n) where n is the number of elements in inOrder array list
     * @param <E>
     * @param inOrder the list of all the nodes in order with thier values
     * @return true if tree is in order/BST, false otherwise
     */
    public static <E extends Comparable<E>> boolean isBST(ArrayList<Integer> inOrder){
        for (int i = 0; i < inOrder.size(); i++) {
            if(inOrder.get(i)>inOrder.get(i+1)){
                return false;
            }
        }
        return true;
    }

    /**
     * method to get the height of the tree
     * Complexity: worst case O(n) where n is the number of nodes of the tree
     * @param <E>
     * @param node node of the tree
     * @return height of the tree (integer number)
     */
    public static <E extends Comparable<E>> int height(BinaryTreeNode<E> node){
        if(node == null){
            return 0;
        }
        return 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }

//----------------------------------------------------------------------------------------------------------------------------------------------------------------

    //first I implemeted this methods to check if a tree is BST, but I found out the complexity in this case is O(n^2) because of the reccursion used


    // public <E extends Comparable<E>> boolean isBST(BinaryTreeNode<E> node){
    //     if(node == null){
    //         return true;
    //     }
    //     if(node.getLeftChild() != null && maxValue(node.getLeftChild()) > (int) node.getElement()){
    //         return false;
    //     }
    //     if(node.getRightChild() != null && minValue(node.getRightChild()) < (int) node.getElement()){
    //         return false;
    //     }
    //     if(isBST(node.getLeftChild()) != false || isBST(node.getRightChild()) != false){
    //         return true;
    //     }
    //     return true;
    // }

    // public <E extends Comparable<E>> int maxValue(BinaryTreeNode<E> node)
    // {
    // if (node == null) {
    //   return Integer.MIN_VALUE;
    // }
    // int value = (int) node.getElement();
    // int leftMax = maxValue(node.getLeftChild());
    // int rightMax = maxValue(node.getRightChild());
 
    // return Math.max(value, Math.max(leftMax, rightMax));
    // }
 
    // public <E extends Comparable<E>> int minValue(BinaryTreeNode<E> node)
    // {
    //     if (node == null) {
    //     return Integer.MAX_VALUE;
    //     }
    //     int value = (int) node.getElement();
    //     int leftMax = minValue(node.getLeftChild());
    //     int rightMax = minValue(node.getRightChild());
    
    //     return Math.min(value, Math.min(leftMax, rightMax));
    // }
}
