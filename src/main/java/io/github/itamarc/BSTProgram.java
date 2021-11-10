package io.github.itamarc;

class BSTProgram {

    public static void main(String[] args) {
        // BST root = new BST(1);
        // root.insert(2);
        // root.insert(3);
        // root.insert(4);
        // root.insert(5);
        // root.insert(6);
        // root.insert(7);
        // root.insert(8);
        // root.insert(9);
        // root.insert(10);
        // root.insert(11);
        // root.insert(12);
        // root.insert(13);
        // root.insert(14);
        // root.insert(15);
        // root.insert(16);
        // root.insert(17);
        // root.insert(18);
        // root.insert(19);
        // root.insert(20);
        BST root = new BST(10);
        root.insert(2);
        root.insert(15);
        root.insert(1);
        System.out.println(root.value);
        root.remove(2);
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;
        public BST parent;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            if (value >= this.value) {
                if (this.right == null) {
                    this.right = new BST(value);
                    this.right.parent = this;
                } else {
                    this.right.insert(value);
                }
            } else { // value < this.value
                if (this.left == null) {
                    this.left = new BST(value);
                    this.left.parent = this;
                } else {
                    this.left.insert(value);
                }
            }
            return this; // Do not edit the return statement of this method.
        }

        public boolean contains(int value) {
            if (value == this.value) {
                return true;
            } else if (value > this.value) {
                if (this.right == null) {
                    return false;
                } else {
                    return this.right.contains(value);
                }
            } else { // value < this.value
                if (this.left == null) {
                    return false;
                } else {
                    return this.left.contains(value);
                }
            }
        }

        public BST remove(int value) {
            // if the current node is the one to remove
            if (value == this.value) {
                // if there is a right children
                if (this.right != null) {
                    // search for the smaller value in right tree
                    BST min = this.right.findMinValue();
                    // bring the smaller value to the removing node
                    this.value = min.value;
                    // remove reference to smaller node
                    removeChildRef(min.parent, min.value);
                    // else if there is a left children
                } else if (this.left != null) {
                    // search for the bigger value in left tree
                    BST max = this.left.findMaxValue();
                    // bring the bigger value to the removing node
                    this.value = max.value;
                    // remove reference to bigger node
                    removeChildRef(max.parent, max.value);
                } else { // it's a leaf
                    // remove reference from parent node
                    if (this.parent != null) { // this is not the root node
                        removeChildRef(this.parent, value);
                    } else {// (how to remove a root leaf?)
                        System.err.println("Root leaf found");
                    }
                }
            } else { // value is different from current one
                // if the value to remove is bigger than current value
                if (value > this.value) {
                    // get right child as next node
                    if (this.right != null) {
                        this.right.remove(value);
                    }
                } else {
                    // get left child as next node
                    if (this.left != null) {
                        this.left.remove(value);
                    }
                }
            }
            return this; // Do not edit the return statement of this method.
        }

        private void removeChildRef(BST node, int value) {
            if (node.right != null && node.right.value == value) {
                if (node.right.left != null) {
                    node.right = node.right.left;
                    node.right.parent = node;
                } else if (node.right.right != null) {
                    node.right = node.right.right;
                    node.right.parent = node;
                } else {
                    node.right = null;
                }
            } else if (node.left != null && node.left.value == value) {
                if (node.left.left != null) {
                    node.left = node.left.left;
                    node.left.parent = node;
                } else if (node.left.right != null) {
                    node.left = node.left.right;
                    node.left.parent = node;
                } else {
                    node.left = null;
                }
            }
        }

        private BST findMinValue() {
            if (this.left == null) {
                return this;
            } else {
                return this.left.findMinValue();
            }
        }

        private BST findMaxValue() {
            if (this.right == null) {
                return this;
            } else {
                return this.right.findMaxValue();
            }
        }
    }
}
