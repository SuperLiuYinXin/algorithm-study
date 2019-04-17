package com.liuyinxin.tree;

/**
 * @author: liuyinxin-896400010@qq.com
 * @date: 2019-04-17
 * @time: 20:01
 * do the best
 */
public class 相同的树_100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p != null && q != null && q.val == p.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }
}
