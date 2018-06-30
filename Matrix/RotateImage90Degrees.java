package shuati.Matrix;

/**
 *
 You are given an n x n 2D matrix representing an image.

 Rotate the image by 90 degrees (clockwise).

 Note:

 You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 DO NOT allocate another 2D matrix and do the rotation.
 */
public class RotateImage90Degrees {
  public void rotate(int[][] matrix) {
    int len = matrix.length;
    rotateD(matrix, len);
    rotateV(matrix, len);
  }

  private void rotateD(int[][] matrix, int len) {
    for (int i=0; i<len; i++) {
      for (int j=0; j<i; j++) {
        // swap(matrix[i][j], matrix[j][i]);
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = tmp;
      }
    }
  }

  private void rotateV(int[][] matrix, int len) {
    for (int i=0; i<len; i++) {
      for (int j=0; j<len/2; j++) {
        // swap(matrix[i][j], matrix[i][len-j-1]);
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[i][len-1-j];
        matrix[i][len-1-j] = tmp;
      }
    }
  }
}



class Solution {

  // O-O-O----------------------O

  int numNodesLeft;
  int numNodesRight;

  public static void main(String[] args) {
    // TODO

    MySolution my = new MySolution();
    // find initial leftest rightest
    while (my.hasLeft()) {

    }

    // for each node,
    System.out.println("num nodes: " + (numLeftNodes + numRightNodes));
    my.toleft(new Message(0));
    my.toRight(new Message(0));
  }

  // public void findTotal(

  public void fromLeft(Message m) {
    // TODO

    if (hasRight()) {
      toRight(new Message(m, m.count+1));
    }
    numNodesLeft = m.count;

  }

  public void fromRight(Message m) {
    // TODO
    if (hasLeft()) {
      toLeft(new Message(m, m.count+1));
    }
    numNodesRight = m.count;
  }

  public void toLeft(Message m);
  public void toRight(Message m);
  public boolean hasLeft();
  public boolean hasRight();

  public class Message() {
    public String message;
    public int count;

    public Message(String m) {
      message = m;
    }

    public Message(int num) {
      // implementation
    }

  }
}
