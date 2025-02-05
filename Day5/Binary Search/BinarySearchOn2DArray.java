class Coordinates<P> {
    // Attributes 
    public P x;
    public P y;

    // Constructor 
    public Coordinates(P x, P y) {
        this.x = x;
        this.y = y;
    }
}

public class BinarySearchOn2DArray {
    public static Coordinates<Integer> search2DArray(int array[][], int target) {
        int x = 0;
        int y = array[0].length-1;
        while (y >= 0 && x <= array.length ) {
            if (array[x][y] == target) {
                return new Coordinates<Integer>(x, y);
            }
            else if (array[x][y] < target) {
                x++;
            }
            else {
                y--;
            }
        }
        
        return new Coordinates<Integer>(-1, -1);
    }
    public static void main(String[] args){
        // Defining a sample sorted 2D array & sample target 
        int sample2DArray[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 15}};
        int targetElement = 11;

        // Calling the search2DArray function 
        Coordinates<Integer> coordinates = search2DArray(sample2DArray, targetElement);

        // Output 
        System.out.println("The Coordinates of the target are " + coordinates.x + ", " + coordinates.y);
    }
}
