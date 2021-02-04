/*
 * CS2050 - Computer Science II - Spring 2020
 * Instructor: Thyago Mota
 * Description: Prg03 - BinNode class
 * Name(s): ADAM WOJDYLA (No Partner)
 */

public class BinNode<T> {

    private T data;
    private BinNode<T> left, right;

    public BinNode() {
        data = null;
        left = right = null;
    }

    public BinNode(T data) {
        this.data = data;
        left = right = null;
    }

    public T getData() {

        return data;
    }

    public void setData(T data) {

        this.data = data;
    }

    public BinNode<T> getLeft() {

        return left;
    }

    public void setLeft(BinNode<T> left) {

        this.left = left;
    }

    public BinNode<T> getRight() {

        return right;
    }

    public void setRight(BinNode<T> right) {

        this.right = right;
    }

    // Added clear method implementation to be used in the Binary tree class
    public void clearBin() {
        // Save left and right subtrees
        BinNode<T> left = this.getLeft();
        BinNode<T> right = this.getRight();

        // Detach the root node from the left and right subtree
        this.setLeft(null);
        this.setRight(null);

        // Recurse on subtrees that were detached to detach some more
        if (left != null)
            left.clearBin();
        if (right != null)
            right.clearBin();
    }

    @Override
    public String toString() {

        return data.toString();
    }
}