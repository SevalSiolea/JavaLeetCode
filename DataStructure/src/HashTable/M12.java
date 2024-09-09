package HashTable;

import java.util.HashMap;

/**
 * Difficulty : M-easy<br>
 * Algorithm : enumerate<br>
 * Date : 2024.9.9<br>
 */
public class M12 {

    private enum Strategy { STRATEGY1 }

    public static void main( String[] args ) {

        java.util.Scanner scanner = new java.util.Scanner( System.in );
        Strategy strategy = Strategy.STRATEGY1;

        String result = solution( strategy, scanner.nextInt() );
        System.out.println( result );
    }

    private static String solution( Strategy strategy, int num) {
        switch( strategy ) {
            case STRATEGY1:
                return solution1( num );
            default:
                return "";
        }
    }

    /**
     * Description : simple solution<br>
     * Complexity : time O( 1 ), per( 11 )<br>
     * Complexity : space O( 1 ), per( 60 )<br>
     *
     * @param num given num
     * @return result
     */
    private static String solution1( int num ) {
        HashMap<Integer, String> intToRoman = new HashMap<>();
        intToRoman.put( 1, "I" );
        intToRoman.put( 5, "V" );
        intToRoman.put( 10, "X" );
        intToRoman.put( 50, "L" );
        intToRoman.put( 100, "C" );
        intToRoman.put( 500, "D" );
        intToRoman.put( 1000, "M" );

        intToRoman.put( 4, "IV" );
        intToRoman.put( 9, "IX" );
        intToRoman.put( 40, "XL" );
        intToRoman.put( 90, "XC" );
        intToRoman.put( 400, "CD" );
        intToRoman.put( 900, "CM" );

        StringBuilder result = new StringBuilder();
        Integer[] numArray = intToRoman.keySet().toArray( new Integer[ 0 ] );
        java.util.Arrays.sort( numArray );

        for( int i = numArray.length - 1; i >= 0; i-- ) {
            while( num >= numArray[ i ] ) {
                result.append( intToRoman.get( numArray[ i ] ) );
                num -= numArray[ i ];
            }
        }

        return result.toString();
    }

}