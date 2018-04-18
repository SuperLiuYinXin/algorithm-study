# 两个排序数组的中位数

给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。

请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。


示例 1:

```python
nums1 = [1, 3]
nums2 = [2]
```
中位数是 2.0

示例 2:

```python
nums1 = [1, 2]
nums2 = [3, 4]
```
中位数是 (2 + 3)/2 = 2.5


## 大神的思路
[教程地址](https://blog.csdn.net/hk2291976/article/details/51107778)
膜拜大佬
## 个人笔记

1. 对于一长一短的数组，可以通过交换一下返回结果，将不确定的长度变成确定的
```java
public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    if (nums1.length > nums2.length){
        return findMedianSortedArrays(nums2, nums1);
    }
    ...some code
}
```
2. 对Manacher 算法思想的引入，通过联想一个联想成一个虚拟数组，将奇偶性不确定的数组变成确定的数组。
3. 求一个数的TOP k  思想  
找到一个数字，有k的比它小就好。两个数组的话就是两个数组各自出一部分


