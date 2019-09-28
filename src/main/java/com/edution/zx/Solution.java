package com.edution.zx;

/**
 * @program: springinaction4
 * @description:
 * @author: soulx
 * @create: 2019-09-27 19:58
 **/
class Solution {
    public static int calculateMinimumHP(int[][] dungeon) {
        int rows = dungeon.length;
        int li = dungeon[0].length;
        int result = 1;
        int[][] a = new int[rows][li];
        for (int i = 1; i < rows; i++) {
            dungeon[i][0] = dungeon[i - 1][0] + dungeon[i][0];
        }
        for (int j = 1; j < li; j++) {
            dungeon[0][j] = dungeon[0][j - 1] + dungeon[0][j];
        }
        for (int k1 = 1; k1 < rows; k1++) {
            for (int k2 = 1; k2 < li; k2++) {
                a[k1][k2] = Math.min(dungeon[k1 - 1][k2], dungeon[k1][k2 - 1]) + dungeon[k1][k2];
                dungeon[k1][k2] = Math.max(dungeon[k1 - 1][k2], dungeon[k1][k2 - 1]) + dungeon[k1][k2];
            }
        }

        for (int k1 = rows - 1; k1 >= 0; k1--) {
            for (int k2 = li - 1; k2 >= 0; k2--) {
                if (dungeon[k1][k2] <= 0) {
                    return  -(dungeon[k1][k2] -1);
                } else {
                    if( a[k1][k2]<0 ){
                        return -( a[k1][k2]-1);
                    }
                }
            }
        }
return result;
    }

    public static void main(String[] args) {
        int [][]a = {
                {-200}
        };
        int [][]a2 ={{-2,-3,3},{-5,-10,1},{10,30,-5}};
        System.out.println(calculateMinimumHP(a2));
    }
}


