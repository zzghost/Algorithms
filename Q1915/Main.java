import java.util.*;

public class Main {
  static class position{
    int x, y;
    position(int x, int y){
      this.x = x;
      this.y = y;
    }
  }
  public static int solve(int n, int startX, int startY, int endX, int endY){
    if(startX == endX && endX == endY){
      return 0;
    }
    int[][] board = new int[n][n];
    for(int i = 0; i < n; i++)
      Arrays.fill(board[i], Integer.MAX_VALUE);
    board[startX][startY] = 0;
    int[] dX = {-1, -2, -2, -1, 1, 2, 2, 1};
    int[] dY= {-2, -1, 1, 2, -2, -1, 1, 2};
    Queue<position> queue = new LinkedList<position>();
    queue.offer(new position(startX, startY));
    while(!queue.isEmpty()){
      position top = queue.poll();
      if(top.x == endX && top.y == endY){
        return board[top.x][top.y];
      }
      for(int i = 0; i < dX.length; i++){
        int newX = top.x + dX[i], newY = top.y + dY[i];
        if(newX >= 0 && newX < n && newY >= 0 && newY < n){
            if(board[newX][newY] == Integer.MAX_VALUE){
              board[newX][newY] = board[top.x][top.y] + 1;
              queue.offer(new position(newX, newY));
            }
        }
      }
    }
    return -1;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner in = new Scanner(System.in);
    int cases = in.nextInt();
    while(cases != 0){
      int n = in.nextInt();
      int startX = in.nextInt(), startY = in.nextInt();
      int endX = in.nextInt(), endY = in.nextInt();
      int rst = solve(n, startX, startY, endX, endY);
      System.out.println(rst);
      cases--;
    }
  }

}
