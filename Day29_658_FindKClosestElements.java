package leetcodeSep2022;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Sir Darey
 * 
 * LeetCode Daily Challenge: September 2022, Day 29
 * Problem 658: Find K Closest Elements
 */

class Day29_658_FindKClosestElements {
    
    int [] arr;
    int k, x, n;
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        this.arr = arr;
        this.x = x;
        this.k = k;
        n = arr.length;
        
        if (x < arr[0])
            return find(0);
        
        else if(x > arr[n-1])
            return find (n-1);
        
        else {
            int index = getIndex(n);
            if (arr[index] < x)
                return find(index+1);
            else
                return find(index);                
        }
    }
    
    int getIndex(int n) {
        int left = 0, right = n-1, mid=0;
        
        while (left <= right) {
            mid = left + (right-left)/2;
            
            if (arr[mid] == x)
                break;
            
            else if (arr[mid] < x)
                left = mid+1;
            else 
                right = mid-1;
        }
        return mid;
    } 
    
    List<Integer> find(int index) {
        List<Integer> result = new ArrayList<>();
        int left = index-1, right = index;
        int size = 0;
        while (size < k && left>=0 && right<n) {
            int leftDiff = Math.abs(x - arr[left]);
            int rightDiff = Math.abs(x - arr[right]);
            
            if (leftDiff < rightDiff) 
                left--;
            else if (leftDiff > rightDiff) 
                right++;
            else {
                if (arr[left] <= arr[right])
                    left--;
                else 
                    right++;           
            }
            size++;
        }
        
        if (left < 0) {
            while (result.size() < k) 
                result.add(arr[++left]);
        } else {
            int i = left - (k-size);
            while (i < right && result.size() < k) 
                result.add(arr[++i]);
        }
        
        return result;
    }
}