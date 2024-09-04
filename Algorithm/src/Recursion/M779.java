package Recursion;

/**
 * Difficulty : M-medium<br>
 * Algorithm : math, simulate, calculate<br>
 * Feature : 2 math solution which make algorithm easier<br>
 * Date : 2024.9.4<br>
 *
 * <p>
 * Solution : solution2, solution3<br>
 * solution1 : reuse the same array to save resource<br>
 * solution4 : translate rail recursion in solution1 to circle<br>
 */
public class M779 {

    private enum Strategy { STRATEGY1, STRATEGY2, STRATEGY3, STRATEGY4 }

    public static void main( String[] args ) {

        java.util.Scanner scanner = new java.util.Scanner( System.in );
        Strategy strategy = Strategy.STRATEGY4;

        int circle = scanner.nextInt();
        int idx = scanner.nextInt();
        int result = solution( strategy, circle, idx );
        System.out.println( result );
    }

    private static int solution( Strategy strategy, int circle, int idx ) {
        switch( strategy ) {
            case STRATEGY1:
                return solution1( circle, idx );
            case STRATEGY2:
                return solution2( circle, idx );
            case STRATEGY3:
                return solution3( circle, idx );
            case STRATEGY4:
                return solution4( circle, idx );
            default:
                return -1;
        }
    }

    /**
     * Description : simple solution, simulate solution<br>
     * Complexity : time O( N ), per( 0 )<br>
     * Complexity : space O( N ), per( 0 )<br>
     * Complexity : N - circle pow of 2, length of result arr<br>
     * Feature : reuse the same array to save resource<br>
     *
     * @param circle times of circle
     * @param idx idx of result
     * @return result
     */
    private static int solution1( int circle, int idx ) {
        int[] bitArr = new int[ (int) Math.pow( 2, circle - 1 ) ];
        bitArr[ 0 ] = 0;
        return solution1( bitArr, circle, 1, idx );
    }

    private static int solution1( int[] bitArr, int circle, int length, int idx ) {
        if( circle == 1 ) return bitArr[ idx - 1 ];

        for( int i = length - 1; i >= 0; i-- ) {
            if( bitArr[ i ] == 0 ) {
                bitArr[ i * 2 ] = 0;
                bitArr[ i * 2 + 1 ] = 1;
            } else if( bitArr[ i ] == 1 ) {
                bitArr[ i * 2 ] = 1;
                bitArr[ i * 2 + 1 ] = 0;
            }
        }

        return solution1( bitArr, circle - 1, length * 2, idx );
    }

    /**
     * Description : clever solution, math and calculate solution<br>
     * Complexity : time O( N ), per( 100 )<br>
     * Complexity : space O( N ), per( 30 )<br>
     * Complexity : N - circle pow of 2, length of result arr<br>
     *
     * <p>
     * Idea : arr[ circle ][ idx ] comes from arr[ circle - 1 ][ ( idx + 1 ) / 2 ]<br>
     * Idea : if idx is even, 0 to 0 and 1 to 1<br>
     * Idea : if idx is odd, 0 to 1 and 1 to 0<br>
     * Idea : then get the final logic expression<br>
     *
     * @param circle times of circle
     * @param idx idx of result
     * @return result
     */
    private static int solution2( int circle, int idx ) {
        if( circle == 1 ) return 0;
        return ( idx & 1 ) ^ 1 ^ solution2( circle - 1, ( idx + 1 ) / 2 );
    }

    /**
     * Description : clever solution, math and calculate solution<br>
     * Complexity : time O( N ), per( 100 )<br>
     * Complexity : space O( N ), per( 70 )<br>
     * Complexity : N - circle pow of 2, length of result arr<br>
     *
     * <p>
     * Idea : arr[ circle ] has the same first half as arr[ circle - 1 ]<br>
     * Idea : arr[ circle ] has reverse second half as arr[ circle - 1 ]<br>
     * Idea : translate idx to get the corresponding translatedIdx in the previous circle<br>
     * Idea : we can get arr[ circle ][ idx ] from arr[ circle - 1 ][ translatedIdx ]<br>
     *
     * @param circle times of circle
     * @param idx idx of result
     * @return result
     */
    private static int solution3( int circle, int idx ) {
        if( circle == 1 ) return 0;
        if( idx > ( 1 << ( circle - 2 ) ) )
            return 1 ^ solution3( circle - 1, idx - ( 1 << ( circle - 2 ) ) );
        else
            return solution3( circle - 1, idx );
    }

    /**
     * Description : simple solution, simulate solution<br>
     * Complexity : time O( N ), per( 0 )<br>
     * Complexity : space O( N ), per( 0 )<br>
     * Complexity : N - circle pow of 2, length of result arr<br>
     * Feature : translate rail recursion in solution1 to circle<br>
     *
     * @param circle times of circle
     * @param idx idx of result
     * @return result
     */
    private static int solution4( int circle, int idx ) {

        int[] bitArr = new int[ (int) Math.pow( 2, circle - 1 ) ];
        bitArr[ 0 ] = 0;
        int length = 1;

        for( int i=0; i < circle - 1; i++ ) {
            for( int j = length - 1; j >= 0; j-- ) {
                if( bitArr[ j ] == 0 ) {
                    bitArr[ j * 2 ] = 0;
                    bitArr[ j * 2 + 1 ] = 1;
                } else if( bitArr[ j ] == 1 ) {
                    bitArr[ j * 2 ] = 1;
                    bitArr[ j * 2 + 1 ] = 0;
                }
            }
            length *= 2;
        }

        return bitArr[ idx - 1 ];
    }

}