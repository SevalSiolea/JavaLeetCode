package Queue;

/**
 * Difficulty : E-medium<br>
 * Date : 2024.9.6<br>
 */
public class E1700 {

    private enum Strategy { STRATEGY1 }

    public static void main( String[] args ) {

        java.util.Scanner scanner = new java.util.Scanner( System.in );
        Strategy strategy = Strategy.STRATEGY1;

        int studentAmount = scanner.nextInt();
        int sandwichAmount = scanner.nextInt();
        int[] students = new int[ studentAmount ];
        for( int i=0; i < studentAmount; i++ )
            students[ i ] = scanner.nextInt();
        int[] sandwiches = new int[ sandwichAmount ];
        for( int i=0; i < sandwichAmount; i++ )
            sandwiches[ i ] = scanner.nextInt();

        int result = solution( strategy, students, sandwiches );
        System.out.println( result );
    }

    private static int solution( Strategy strategy, int[] students, int[] sandwiches ) {
        switch( strategy ) {
            case STRATEGY1:
                return solution1( students, sandwiches );
            default:
                return -1;
        }
    }

    /**
     * Description : simple solution<br>
     * Complexity : time O( N ), per( 100 )<br>
     * Complexity : space O( 1 ), per( 50 )<br>
     * Complexity : N - amount of students<br>
     *
     * @param students students
     * @param sandwiches sandwiches
     * @return result
     */
    private static int solution1( int[] students, int[] sandwiches ) {
        int topOfStack = 0;
        int length = -1;
        int current = 0;
        int result = students.length;

        while( length != students.length && topOfStack != sandwiches.length ) {
            if( students[ current ] == sandwiches[ topOfStack ] ) {
                topOfStack++;
                length = -1;
                students[ current ] = -1;
                result--;
            }
            current++;
            if( current == students.length ) current = 0;
            length++;
        }

        return result;
    }

}
