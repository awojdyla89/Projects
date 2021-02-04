/*
 * CS2050 - Computer Science II - Spring 2020
 * Instructor: Thyago Mota
 * Description: Prg03 - BinaryTree class
 * Name(s): ADAM WOJDYLA (No Partner)
 */

import java.util.Iterator;

public class BinaryTree<T extends Comparable<T>> implements Iterable<T> {

    private BinNode<T> root;

    public BinaryTree() {

        root = null;
    }

    public boolean isEmpty() {

        return root == null;

    }

    private BinNode<T> addRecursively(BinNode<T> current, final T data) {
        if (current == null)
            return new BinNode<T>(data);
        else {
            if (data.compareTo(current.getData()) <= 0)
                current.setLeft(addRecursively(current.getLeft(), data));
            else if (data.compareTo(current.getData()) > 0)
                current.setRight(addRecursively(current.getRight(), data));
            return current;
        }
    }

    public void add(final T data) {
        if (isEmpty())
            root = new BinNode<T>(data);
        else
            addRecursively(root, data);
    }


    // TODOd: implement the recursive inOrder tree traversal method
    private String inOrder(final BinNode<T> current) {
        if (current == null) {
            return "";

        } else {
            return inOrder(current.getLeft()) + current.toString() + inOrder(current.getRight());
        }
    }

    // TODOd: implement the toString method based on inOrder tree traversal
    @Override
    public String toString() {

        return inOrder(this.root);
    }

    // TODOd: implement the clear method (clearBin() method located in BinNode class)
    public void clear() {
        if (isEmpty())
            return;
        root.clearBin();
        root = null;
    }

    // TODOd: implement a binary tree iterator
    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {

            Queue<BinNode<T>> queue = new Queue<>(root);

            @Override
            public boolean hasNext() {
                return !queue.isEmpty();
            }

            @Override
            public T next() {
                BinNode<T> current = queue.pop();
                if (current.getLeft() != null)
                    queue.push(current.getLeft());
                if (current.getRight() != null)
                    queue.push(current.getRight());

                return current.getData();
            }
        };

    }
}