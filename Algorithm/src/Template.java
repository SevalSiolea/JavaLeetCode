/**
 * Template of LeetCode data structure problems.
 *
 * <p>
 * Difficulty : official difficulty + actual difficulty<br>
 * official difficulty : Easy(E), Medium(M), Hard(H)<br>
 * actual difficulty : easy, medium, hard compared to official difficulty<br>
 * actual difficulty : accurate difficulty of official difficulty<br>
 *
 * <p>
 * Feature : describe features which make this problem valuable<br>
 *
 * <p>
 * Solution : solution list of solutions which is valuable<br>
 * solution : every solution and its description follows<br>
 *
 * <p>
 * Date : date of this problem<br>
 */
public class Template {

    private enum Strategy { STRATEGY1, STRATEGY2, STRATEGY3 }

    public static void main( String[] args ) {

        java.util.Scanner scanner = new java.util.Scanner( System.in );
        Strategy strategy = Strategy.STRATEGY1;

        int arrLength = scanner.nextInt();
        int[] arr = new int[ arrLength ];
        for( int i=0; i < arrLength; i++ )
            arr[ i ] = scanner.nextInt();
        int result = solution( strategy, arr );
        System.out.println( result );
    }

    private static int solution( Strategy strategy, int[] arr ) {
        switch( strategy ) {
            case STRATEGY1:
                return solution1( arr );
            case STRATEGY2:
                return solution2( arr );
            case STRATEGY3:
                return solution3( arr );
            default:
                return -1;
        }
    }

    /**
     * Description : brief description of this solution<br>
     * Complexity : time complexity with percentage<br>
     * Complexity : space complexity without arr with percentage<br>
     * Feature : valuable highlights of this solution<br>
     * Hint : key point of this solution<br>
     * Idea : thought of how to analyse and solve this problem<br>
     * Steps : detailed steps of this solution<br>
     *
     * @param arr param list
     * @return result
     */
    private static int solution1( int[] arr ) { return 0; }

    private static int solution2( int[] arr ) { return 0; }

    private static int solution3( int[] arr ) { return 0; }

}