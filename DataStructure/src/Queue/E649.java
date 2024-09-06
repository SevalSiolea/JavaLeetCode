package Queue;

/**
 * Difficulty : E-medium<br>
 * Date : 2024.9.6<br>
 */
public class E649 {

    private enum Strategy { STRATEGY1 }

    public static void main( String[] args ) {

        java.util.Scanner scanner = new java.util.Scanner( System.in );
        Strategy strategy = Strategy.STRATEGY1;

        String result = solution( strategy, scanner.next() );
        System.out.println( result );
    }

    private static String solution( Strategy strategy, String senate ) {
        switch( strategy ) {
            case STRATEGY1:
                return solution1( senate );
            default:
                return "";
        }
    }

    /**
     * Description : simple solution<br>
     * Complexity : time O( N ), per( 88 )<br>
     * Complexity : space O( N ), per( 88 )<br>
     * Complexity : N - length of senate<br>
     *
     * @param senate senate
     * @return result
     */
    private static String solution1( String senate ) {
        char[] senateArray = senate.toCharArray();

        int radiantAmount = 0;
        int direAmount = 0;
        for ( char senator : senateArray )
            if ( senator == 'R' )
                radiantAmount++;
            else if( senator == 'D' )
                direAmount++;
        if( radiantAmount == 0 ) return "Dire";
        if( direAmount == 0 ) return "Radiant";

        int head = 0;
        int current = -1;
        while( true ) {
            if( ++current == senateArray.length ) current = 0;
            if( senateArray[ head ] + senateArray[ current ] != 'R' + 'D' ) continue;

            if ( senateArray[ current ] == 'R' ) {
                if (--radiantAmount == 0) return "Dire";
            } else if ( senateArray[ current ] == 'D' )
                if ( --direAmount == 0 ) return "Radiant";

            senateArray[ current ] = 0;
            do {
                if ( ++head == senateArray.length ) head = 0;
            } while ( senateArray[ head ] == 0 );
        }
    }

}