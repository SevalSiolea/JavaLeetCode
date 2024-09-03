package Recursion;

import java.util.List;
import java.util.ArrayList;

/**
 * Difficulty : M-hard<br>
 * Feature1 : programming is difficult<br>
 * Feature2 : use stack to match bracket<br>
 * Date : 2024.9.3<br>
 */
public class M394 {

    private enum Strategy { STRATEGY1 }

    public static void main( String[] args ) {

        java.util.Scanner scanner = new java.util.Scanner( System.in );
        Strategy strategy = Strategy.STRATEGY1;

        String result = solution( strategy, scanner.next() );
        System.out.println( result );
    }

    private static String solution( Strategy strategy, String str ) {
        switch( strategy ) {
            case STRATEGY1:
                return solution1( str );
            default:
                return "";
        }
    }

    /**
     * Description : simple solution<br>
     * Complexity : time O( N ), per( 20 )<br>
     * Complexity : space O( N ), per( 15 )<br>
     * Complexity : N - length of str<br>
     * Feature1 : programming is difficult<br>
     * Feature2 : use stack to match bracket<br>
     *
     * @param str given str
     * @return result
     */
    private static String solution1( String str ) {

        StringBuilder result = new StringBuilder();
        List<String> bracketStack = new ArrayList<String>();
        StringBuilder current = new StringBuilder();
        int idx = -1;

        while( ++idx < str.length() && !String.valueOf( str.charAt( idx ) ).matches( "\\d" ) )
            result.append( str.charAt( idx ) );
        if( --idx == str.length() - 1 ) return result.toString();

        while( ++idx < str.length() && str.charAt( idx ) != '[' )
            current.append( str.charAt( idx ) );
        int repeat = Integer.parseInt( current.toString() );
        current.setLength( 0 );

        bracketStack.add( "[" );
        while( bracketStack.size() != 0 ) {
            if( ++idx >= str.length() ) break;
            if( str.charAt( idx ) == '[' )
                bracketStack.add( "[" );
            else if( str.charAt( idx ) == ']' )
                bracketStack.remove( bracketStack.size() - 1 );
            current.append( str.charAt( idx ) );
        }
        current.deleteCharAt( current.length() - 1 );
        String repeatStr = solution1( current.toString() );

        for( int i=0; i < repeat; i++ )
            result.append( repeatStr );
        if( idx != str.length() - 1 )
            result.append( solution1( str.substring( idx + 1 ) ) );
        return result.toString();
    }

}