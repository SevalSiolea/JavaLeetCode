package HashTable;

import java.util.HashMap;

/**
 * Difficulty : E-medium<br>
 * Algorithm : enumerate<br>
 * Date : 2024.9.9<br>
 */
public class E13 {

    private enum Strategy { STRATEGY1 }

    public static void main( String[] args ) {

        java.util.Scanner scanner = new java.util.Scanner( System.in );
        Strategy strategy = Strategy.STRATEGY1;

        int result = solution( strategy, scanner.next() );
        System.out.println( result );
    }

    private static int solution( Strategy strategy, String roman ) {
        switch( strategy ) {
            case STRATEGY1:
                return solution1( roman );
            default:
                return -1;
        }
    }

    /**
     * Description : simple solution<br>
     * Complexity : time O( N ), per( 13 )<br>
     * Complexity : space O( 1 ), per( 5 )<br>
     * Complexity : N - length of roman<br>
     *
     * @param roman roman string
     * @return result
     */
    private static int solution1( String roman ) {
        HashMap<String, Integer> romanToInt = new HashMap<>();
        romanToInt.put( "I", 1 );
        romanToInt.put( "V", 5 );
        romanToInt.put( "X", 10 );
        romanToInt.put( "L", 50 );
        romanToInt.put( "C", 100 );
        romanToInt.put( "D", 500 );
        romanToInt.put( "M", 1000 );

        romanToInt.put( "IV", 4 );
        romanToInt.put( "IX", 9 );
        romanToInt.put( "XL", 40 );
        romanToInt.put( "XC", 90 );
        romanToInt.put( "CD", 400 );
        romanToInt.put( "CM", 900 );

        int result = 0;
        for( int i=0; i < roman.length(); i++ ) {
            if( i < roman.length() - 1 ) {
                String str = roman.substring( i, i + 2 );
                if( romanToInt.containsKey( str ) ) {
                    result += romanToInt.get( str );
                    i++;
                    continue;
                }
            }
            result += romanToInt.get( roman.substring( i, i+1 ) );
        }

        return result;
    }

}