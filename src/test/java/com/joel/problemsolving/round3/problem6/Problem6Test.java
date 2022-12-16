package com.joel.problemsolving.round3.problem6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem6Test {

    private Problem6 sut;

    @BeforeEach
    void setUp() {
        sut = new Problem6();
    }

    @Test
    void isEqualTree_모든_노드의_데이터가_같으면_true를_리턴한다() {
        TreeNode firstTree = buildTestTree();
        TreeNode sameTree = buildTestTree();


        assertTrue(sut.isEqualTree(firstTree, sameTree));
    }

    @Test
    void isEqualTree_데이터가_하나라도_다르면_false를_리턴한다() {
        TreeNode firstTree = buildTestTree();
        TreeNode sameTree = buildTestTree();
        sameTree.getLeft().setData(9);


        assertFalse(sut.isEqualTree(firstTree, sameTree));
    }

    @Test
    void isSubTree_small이_하위트리이면_true를_리턴한다() {
        TreeNode firstTree = buildTestTree();
        TreeNode sameTree = buildTestTree();


        assertTrue(sut.isSubTree(firstTree, sameTree.getRight()), "오른쪽 노드의 하위트리 판별이 잘못되었습니다.");
        assertTrue(sut.isSubTree(firstTree, sameTree.getLeft()), "왼쪽 노드의 하위트리 판별이 잘못되었습니다.");
    }

    @Test
    void isSubTree_leaf노드가_주어지면_true를_리턴한다() {
        TreeNode tree = buildTestTree();


        assertTrue(sut.isSubTree(tree, new TreeNode(6)), "오른쪽 노드의 하위트리 판별이 잘못되었습니다.");
    }

    @Test
    void isSubTree_큰_트리에_없는_값의_노드가_주어지면_false를_리턴한다() {
        TreeNode tree = buildTestTree();


        assertFalse(sut.isSubTree(tree, new TreeNode(9)), "오른쪽 노드의 하위트리 판별이 잘못되었습니다.");
    }

    @Test
    void isSubTree_big이_null이면_false를_리턴한다() {
        TreeNode small = buildTestTree();


        assertFalse(sut.isSubTree(null, small));
    }

    @Test
    void isSubTree_small이_null이면_true를_리턴한다() {
        TreeNode big = buildTestTree();


        assertTrue(sut.isSubTree(big, null));
    }

    private TreeNode buildTestTree() {
        TreeNode root  = new TreeNode(1);
        TreeNode treeNode1  = new TreeNode(2);
        TreeNode treeNode2  = new TreeNode(3);
        TreeNode treeNode3  = new TreeNode(4);
        TreeNode treeNode4  = new TreeNode(5);
        TreeNode treeNode5  = new TreeNode(6);

        root.setLeft(treeNode1);
        root.setRight(treeNode2);
        treeNode1.setLeft(treeNode3);
        treeNode1.setRight(treeNode4);
        treeNode2.setLeft(treeNode5);

        return root;
    }
}