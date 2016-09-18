import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Sunsea on 16/9/18.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int P = scanner.nextInt();
            int[][] arr = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }
            System.out.println(pathInfo(arr, P, n, m));
        }
        scanner.close();
    }

    private static String pathInfo(int[][] matrix, int P, int n, int m) {
        int[][] vis = new int[m][n];
        //记录路径
        LinkedList<int[]> res = new LinkedList<>();
        //判断是否存在
        boolean flag = false;
        int max = Integer.MIN_VALUE;
        LinkedList<int[]> temp= new LinkedList<>();
        dfs(0,0,P,matrix,n,m,flag,vis,res,temp,max);

        if (flag) {
            StringBuilder tmp = new StringBuilder();

            for (int i = 0; i < res.size(); i++) {
                int[] a = res.get(i);
                tmp.append("["+a[0]+","+a[1]+ "]" + ",");
            }
            String b = tmp.toString();
            return b.substring(0, b.length() - 1);
        }
        else {
            return "Can not escape!";
        }
    }
    private static void dfs(int i, int j,int P, int[][] matrix, int n, int m, boolean flag, int[][] vis, LinkedList<int[]> res,LinkedList<int[]> temp, int max){
            int x,y;
            //到达了终点
            if(i==0&&j==m-1){
                flag=true;
                if(P> max){
                    res=temp;
                    max =P;
                }
            }
            //向右走
            x=i+1;
            y=j;
            if(x<n&&y<m&&x>=0&&y>=0&&vis[x][y]==0&&matrix[x][y]!=0){
                vis[x][y]=1;
                temp.addLast(new int[]{x,y});
                if(P-1>=0){
                    P-=1;
                    dfs(x,y,P,matrix,n,m,flag,vis,res,temp,max);
                    P+=1;
                }
                vis[x][y]=0;
                temp.removeLast();
            }
            //向左走
            x=i-1;
            y=j;
            if(x<n&&y<m&&x>=0&&y>=0&&vis[x][y]==0&&matrix[x][y]!=0){
                vis[x][y]=1;
                temp.addLast(new int[]{x,y});
                if(P-1>=0){
                    P-=1;
                    dfs(x,y,P,matrix,n,m,flag,vis,res,temp,max);
                    P+=1;
                }
                vis[x][y]=0;
                temp.removeLast();
            }
            //向上走
            x=i;
            y=j+1;
            if(x<n&&y<m&&x>=0&&y>=0&&vis[x][y]==0&&matrix[x][y]!=0){
                vis[x][y]=1;
                temp.addLast(new int[]{x,y});
                if(P-3>=0){
                    P-=3;
                    dfs(x,y,P,matrix,n,m,flag,vis,res,temp,max);
                    P+=3;
                }
                vis[x][y]=0;
                temp.removeLast();
            }
            //向下走
            x=i;
            y=j-1;
            if(x<n&&y<m&&x>=0&&y>=0&&vis[x][y]==0&&matrix[x][y]!=0){
                vis[x][y]=1;
                temp.addLast(new int[]{x,y});
                dfs(x,y,P,matrix,n,m,flag,vis,res,temp,max);
                vis[x][y]=0;
                temp.removeLast();
            }
        }
}


