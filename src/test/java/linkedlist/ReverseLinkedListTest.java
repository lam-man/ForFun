package linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.ListNode;

import static org.junit.jupiter.api.Assertions.*;

class ReverseLinkedListTest {

    ListNode head;
    ListNode second;
    ListNode third;
    ListNode fourth;

    ReverseLinkedList reverseLinkedList;

    @BeforeEach
    public void setUp() {
        head = new ListNode(1);
        second = new ListNode(2);
        third = new ListNode(3);
        fourth = new ListNode(4);
        head.next = second;
        second.next = third;
        third.next = fourth;
        reverseLinkedList = new ReverseLinkedList();
    }

    @Test
    public void testHead_AndReturnFourth() {
        ListNode result = reverseLinkedList.reverse(head);
        assertEquals(result.val, fourth.val);
    }

}