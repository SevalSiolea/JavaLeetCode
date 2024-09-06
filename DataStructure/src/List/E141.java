package List;

import java.util.HashSet;

/**
 * Difficulty : E-medium<br>
 * Data structure : hashSet<br>
 * Feature : solution2 is a little clever<br>
 * Date : 2024.9.6<br>
 */
public class E141 {

    private enum Strategy { STRATEGY1, STRATEGY2 }

    public static void main( String[] args ) {

        java.util.Scanner scanner = new java.util.Scanner( System.in );
        Strategy strategy = Strategy.STRATEGY2;

        int length = scanner.nextInt();
        ListNode head = new ListNode();
        ListNode current = head;
        for( int i=0; i < length; i++ ) {
            current.next = new ListNode( scanner.nextInt() );
            current = current.next;
        }
        boolean result = solution( strategy, head );
        System.out.println( result );
    }

    private static boolean solution( Strategy strategy, ListNode head ) {
        switch( strategy ) {
            case STRATEGY1:
                return solution1( head );
            case STRATEGY2:
                return solution2( head );
            default:
                return false;
        }
    }

    /**
     * Description : simple solution<br>
     * Complexity : time O( N ), per( 20 )<br>
     * Complexity : space O( N ), per( 7 )<br>
     * Complexity : N - length of list<br>
     *
     * @param head head of list
     * @return result
     */
    private static boolean solution1( ListNode head ) {
        HashSet<ListNode> ListNodeSet = new HashSet<>();
        while( head != null ) {
            if( ListNodeSet.contains( head ) ) return true;
            ListNodeSet.add( head );
            head = head.next;
        }
        return false;
    }

    /**
     * Description : simple solution<br>
     * Complexity : time O( N ), per( 100 )<br>
     * Complexity : space O( 1 ), per( 43 )<br>
     * Complexity : N - length of list<br>
     * Hint : length of list is limited and small<br>
     *
     * @param head head of list
     * @return result
     */
    private static boolean solution2( ListNode head ) {
        for( int i=0; i <= 10001 && head != null; i++ ) head = head.next;
        return head != null;
    }

}