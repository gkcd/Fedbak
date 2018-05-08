package com.questioner.util;

public class SimilarDistance {
    public static int getStringDistance(char[] a, char[] b) {
        int[][] len = new int[a.length + 1][b.length + 1];
        for (int i = 0; i < len.length; i++) {
            len[i][0] = i;
        }
        for (int j = 0; j < len[0].length; j++) {
            len[0][j] = j;
        }
        for (int i = 1; i < len.length; i++) {
            for (int j = 1; j < len[0].length; j++) {
                if (a[i - 1] == b[j - 1]) {
                    len[i][j] = len[i - 1][j - 1];
                } else {
                    len[i][j] = Math.min(Math.min(len[i - 1][j], len[i - 1][j - 1]), len[i][j - 1]) + 1;
                }
            }
        }
        return len[len.length - 1][len[0].length - 1];
    }
}
