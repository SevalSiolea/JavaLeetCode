package List;

import java.util.HashSet;

/**
 * Difficulty : E-medium<br>
 * Data structure : hashSet<br>
 * Solution : solution2<br>
 * Date : 2024.9.6<br>
 */
public class E160 {

    private enum Strategy { STRATEGY1, STRATEGY2 }

    public static void main( String[] args ) {

        java.util.Scanner scanner = new java.util.Scanner( System.in );
        Strategy strategy = Strategy.STRATEGY2;

        int lengthA = scanner.nextInt();
        int lengthB = scanner.nextInt();
        int skipA = scanner.nextInt();
        int skipB = scanner.nextInt();

        ListNode headA = new ListNode( 0 );
        ListNode currentA = headA;
        for( int i=0; i < skipA - 1; i++ ) {
            currentA.next = new ListNode( 0 );
            currentA = currentA.next;
        }

        ListNode headB = new ListNode( 0 );
        ListNode currentB = headB;
        for( int i=0; i < skipB - 1; i++ ) {
            currentB.next = new ListNode( 0 );
            currentB = currentB.next;
        }

        if( skipA != lengthA || skipB != lengthB ) {
            currentA.next = new ListNode( 0 );
            currentA = currentA.next;
            currentB.next = currentA;
            currentB = currentB.next;

            for( int i=0; i < lengthA - 1 - skipA; i++ ) {
                currentA.next = new ListNode( 0 );
                currentA = currentA.next;
            }
        }

        ListNode result = solution( strategy, headA, headB );
        if( skipA == lengthA && skipB == lengthB )
            System.out.println( result == null );
        else
            System.out.println( result == currentB );
    }

    private static ListNode solution( Strategy strategy, ListNode headA, ListNode headB ) {
        switch( strategy ) {
            case STRATEGY1:
                return solution1( headA, headB );
            case STRATEGY2:
                return solution2( headA, headB );
            default:
                return new ListNode();
        }
    }

    /**
     * Description : simple solution<br>
     * Complexity : time O( N + M ), per( 21 )<br>
     * Complexity : space O( N + M ), per( 89 )<br>
     * Complexity : N, M - length of list A, B<br>
     *
     * @param headA head of list A
     * @param headB head of list B
     * @return result
     */
    private static ListNode solution1( ListNode headA, ListNode headB ) {
        HashSet<ListNode> listNodeSet = new HashSet<>();

        while( headA != null ) {
            listNodeSet.add( headA );
            headA = headA.next;
        }

        while( headB != null )
            if( listNodeSet.contains( headB ) )
                return headB;
            else
                headB = headB.next;

        return null;
    }

    /**
     * Description : clever solution<br>
     * Complexity : time O( N + M ), per( 99 )<br>
     * Complexity : space O( 1 ), per( 78 )<br>
     * Complexity : N, M - length of list A, B<br>
     *
     * <p>
     * Idea : ptrA iterate over list A then list B<br>
     * Idea : ptrB iterate over list B then list A<br>
     * Idea : if list A and list B intersect, prtA == ptrB at some time and is not null<br>
     * Idea : else, list A == list B == null at the end<br>
     *
     * @param headA head of list A
     * @param headB head of list B
     * @return result
     */
    private static ListNode solution2( ListNode headA, ListNode headB ) {
        ListNode ptrA = headA;
        ListNode ptrB = headB;
        while( true ) {
            if( ptrA == ptrB ) return ptrA;
            ptrA = ptrA == null ? headB : ptrA.next;
            ptrB = ptrB == null ? headA : ptrB.next;
        }
    }


}