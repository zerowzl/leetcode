package dbsf.numberOfProvinces;

/* *****************************************************************************

547. 省份数量

*******************************************************************************/

/**
 * @author Dave Wang
 * @since 1.0.0
 */
public class NumberOfProvinces {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int ans = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, n, i);
                ans++;
            }
        }
        return ans;
    }

    private void dfs(int[][] isConnected, boolean[] path, int n, int i) {
        for (int j = 0; j < n; j++) {
            if (isConnected[i][j] == 1 && !path[j]) {
                path[j] = true;
                dfs(isConnected, path, n, j);
            }
        }
    }
}
