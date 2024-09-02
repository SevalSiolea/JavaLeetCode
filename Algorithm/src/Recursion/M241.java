package Recursion;

/**
 * Difficulty : M-medium<br>
 * Feature : use 2 algorithms of simulate and calculate<br>
 * Date : 2024.9.2<br>
 */
public class M241 {

    private enum Strategy { STRATEGY1, STRATEGY2 }

    public static void main( String[] args ) {

        java.util.Scanner scanner = new java.util.Scanner( System.in );
        Strategy strategy = Strategy.STRATEGY2;

        int result = solution( strategy, scanner.nextInt() );
        System.out.println( result );
    }

    private static int solution( Strategy strategy, int length ) {
        switch( strategy ) {
            case STRATEGY1:
                return solution1( length );
            case STRATEGY2:
                return solution2( length );
            default:
                return -1;
        }
    }

    /**
     * Description : simple solution, simulate solution<br>
     * Complexity : time O( N ), per( 0 )<br>
     * Complexity : space O( N + logN ), per( 0 )<br>
     * Complexity : N - length of original arr<br>
     * Feature : reuse the same arr to save memory<br>
     *
     * @param length length of original arr
     * @return result
     */
    private static int solution1( int length ) {
        int[] arr = new int[ length ];
        for( int i=1; i <= length; i++ )
            arr[ i-1 ] = i;
        return solution1( arr, length, true );
    }

    private static int solution1( int[] arr, int length, boolean sequence ) {
        if( length == 1 )
            return arr[ 0 ];

        int idx = ( length % 2 == 0 && !sequence ) ? 0 : 1;
        while( idx < arr.length ) {
            arr[ idx / 2 ] = arr[ idx ];
            idx += 2;
        }

        return solution1( arr, length / 2, !sequence );

    }

    /**
     * Description : simple solution, calculate solution<br>
     * Complexity : time O( logN ), per( 22 )<br>
     * Complexity : space O( 1 + logN ), per( 60 )<br>
     * Complexity : N - length of original arr<br>
     * Hint1 : use properties of arithmetic sequence to calculate to save time and memory<br>
     * Hint2 : reverse arr to make every step the same<br>
     *
     * @param length length of original arr
     * @return result
     */
    private static int solution2( int length ) {
        return solution2( 1, length, 1, length );
    }

    private static int solution2( int start, int end, int diff, int length ) {
        if( length == 1 ) return start;

        start += diff;
        end -= length % 2 == 0 ? 0 : diff;
        diff *= -2;
        length /= 2;
        return solution2( end, start, diff, length );
    }

}