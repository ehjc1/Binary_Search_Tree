// Name: Eugene
// ID: 1351553

public class BankBST {
//    first account
    Account root;

//    create a reference to the left and right child
    BankBST leftChild;
    BankBST rightChild;

//    A method that adds an account to the BST
    public void addAccount(Account newAccount) {

//        check if the root is null OR if there is nothing in our BST
        if (root == null) {
//            if so that will be the root(first) account
            root = newAccount;
//            create a new left and right child
            leftChild = new BankBST();
            rightChild = new BankBST();
            System.out.print(root.getKey() + " ");
        }
//        otherwise check which child should we pass the data to
        else {
//            check if the new key is less than the root's key
            if(newAccount.getKey() < root.getKey() && leftChild != null) {
//                if so pass the account left child's insert function
                leftChild.addAccount(newAccount);
            }
//            check if the new key is greater than the root's key
            else if(newAccount.getKey() > root.getKey() && rightChild != null) {
//                if so pass the account on to the right child
                rightChild.addAccount(newAccount);
            }
            else {
                return;
            }
        }
    }

//    a method that finds the account and returns the data for that account
    public Account find(int key) {
        if(root != null) {
            System.out.print(root.getKey() + " ");
        }
//        if the value of the root is empty/null and the key is equal the value of the root
//        return the root value
        if(root == null || root.getKey() == key) {
            return root;
        }
//        else call the leftChild's find method
        else if (key < root.getKey() && leftChild != null) {
            return leftChild.find(key);
        }
//        else call the rightChild's find method
        else if(key > root.getKey() && rightChild != null){
            return rightChild.find(key);
        }
        else {
            return null;
        }

    }

//    a method that remove a node from the BST
    public void removeAccount(int key) {

        // check if the BST is empty if so return
        if(root == null) {return; }

        // check if the root is the key
        if(root.getKey() == key) {
            // store our original left and right child
            BankBST originalLeft = leftChild;
            BankBST originalRight = rightChild;
            // if both out rightChild and leftChild is null then
            // we set out root to null
            if(rightChild.root == null && leftChild.root == null) {
                root = null;
            }
            // if we only have a leftChild we set our root
            // to our leftChild's root and set our rightChild to our
            // lefChild's rightChild and vice versa
            else if(rightChild.root == null) {
                root = leftChild.root;
                leftChild = leftChild.leftChild;
                rightChild = originalLeft.rightChild;
                return;
            }
            // if we only have a rightChild we set our root
            // to our rightChild's root and set our rightChild to our
            // rightChild's rightChild and vice versa
            else if(leftChild.root == null) {
                root = rightChild.root;
                leftChild = rightChild.leftChild;
                rightChild = originalRight.rightChild;
                return;
            }
            // case 3 where we have both leftChild and rightChild
            // so we find our predecessor
            else {
                // we set out replacement node
                BankBST replacementParent = rightChild;
                BankBST replacement = rightChild;

                // while there is still a left child
                // continue to left untill we hit rock bottom(null)
                while(replacement.leftChild.root != null) {
                    replacementParent = replacement;
                    replacement = replacement.leftChild;
                }

                // set predecessor
                if(replacement != rightChild) {
                    // set our root value to out replacement's root value
                    root = replacement.root;
                    // set our replacement's parent's left child to our replacement's rightChild
                    replacementParent.leftChild = replacement.rightChild;

                }
                // if our predecessor is our rightChild
                // set our root value to our rightChild's(replacement's) root
                // dereference our right child
                else if(replacement == rightChild) {
                    root = replacement.root;
                    rightChild = replacement.rightChild;
                    rightChild.root = null;
                }
            }
        }
        // else we check if the key is greater than us
        // if so call our rightChild's remove method
        else if(key > root.getKey()) {
            rightChild.removeAccount(key);
        }
        // else we check if the key is greater than us
        // if so call our rightChild's remove method
        else if(key < root.getKey()) {
            leftChild.removeAccount(key);
        }

    }

//    a inOrder traversal method to traverse the BST
    public void traverse() {
//        if the root of the tree is null return
        if(root == null) { return; }
//        else print its value call the left and right child's traverse method
        else {
            try {
                leftChild.traverse();
                System.out.println(root.getKey() + " " + root.getBalance());
                rightChild.traverse();
            } catch (Exception ex) {
                return;
            }

        }
    }

}
