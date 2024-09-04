package Recursion;

/**
 * Difficulty : M-medium<br>
 * Algorithm : simulate, calculate<br>
 * Date : 2024.9.4<br>
 */
public class M1545 {

    private enum Strategy { STRATEGY1, STRATEGY2, STRATEGY3  }

    public static void main( String[] args ) {

        java.util.Scanner scanner = new java.util.Scanner( System.in );
        Strategy strategy = Strategy.STRATEGY3;

        int loop = scanner.nextInt();
        int idx = scanner.nextInt();
        char result = solution( strategy, loop, idx );
        System.out.println( result );
    }

    private static char solution( Strategy strategy, int loop, int idx ) {
        switch( strategy ) {
            case STRATEGY1:
                return solution1( loop, idx );
            case STRATEGY2:
                return solution2( loop, idx );
            case STRATEGY3:
                return solution3( loop, idx );
            default:
                return 0;
        }
    }

    /**
     * Description : simple solution, simulate solution<br>
     * Complexity : time O( 2^N ), per( 6 )<br>
     * Complexity : space O( 2^N ), per( 26 )<br>
     * Complexity : N - loop times<br>
     *
     * @param loop loop times
     * @param idx idx of result
     * @return result
     */
    private static char solution1( int loop, int idx ) {
        StringBuilder result = new StringBuilder();
        result.append( "0" );
        return solution1( result, loop, idx );
    }

    private static char solution1( StringBuilder result, int loop, int idx ) {
        if( loop == 1 ) return result.charAt( idx - 1 );

        int length = result.length();
        result.append( "1" );
        for( int i = length - 1; i >= 0; i-- )
            result.append( result.charAt( i ) == '0' ? '1' : '0' );

        return solution1( result, loop - 1, idx );
    }

    /**
     * Description : simple solution, simulate solution<br>
     * Complexity : time O( 2^N ), per( 6 )<br>
     * Complexity : space O( 2^N ), per( 16 )<br>
     * Complexity : N - loop times<br>
     * Feature : translate nail recursion in solution1 to circle<br>
     *
     * @param loop loop times
     * @param idx idx of result
     * @return result
     */
    private static char solution2( int loop, int idx ) {
        StringBuilder result = new StringBuilder();
        result.append( "0" );

        for( int i=0; i < loop; i++ ) {
            int length = result.length();
            result.append( "1" );
            for( int j = length - 1; j >= 0; j-- )
                result.append( result.charAt( j ) == '0' ? '1' : '0' );
        }

        return result.charAt( idx - 1 );
    }

    /**
     * Description : simple solution, calculate solution<br>
     * Complexity : time O( N ), per( 100 )<br>
     * Complexity : space O( N ), per( 33 )<br>
     * Complexity : N - loop times<br>
     *
     * @param loop loop times
     * @param idx idx of result
     * @return result
     */
    private static char solution3( int loop, int idx ) {
        if( loop == 1 ) return '0';

        if( idx > ( 1 << ( loop - 1 ) ) )
            return solution3( loop - 1, ( 1 << loop ) - idx ) == '1' ? '0' : '1';
        else if( idx < ( 1 << ( loop - 1 ) ) )
            return solution3( loop - 1, idx );
        else
            return '1';
    }

}