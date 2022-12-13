package com.joel.problemsolving.round1.problem1;

import com.joel.problemsolving.common.Node;

/**
 * (정의)
 * slow = 한 번에 1
 * fast = 한 번에 2
 * loop 시작점까지의 거리 = k
 * loop 길이 = ls
 * => slow가 k만큼 전진했을때, fast는 2k만큼 전진.
 * => 즉, fast는 루프 안에서 2k-k=k 만큼 전진해 있다.
 * => 그런데 k가 루프의 길이 ls보다 길 수 있으므로, 실제로 전진한 거리는 k % ls = p라고 하자.
 *
 * 1. slow가 루프의 시작점에 있다.
 * 2. fast는 p만큼 루프 안에 있다.
 * 3. slow는 p만큼 fast에서 뒤쳐져 있다.
 * 4. fast는 (ls-p)만큼 slow에 뒤쳐져 있다.
 * 5. fast는 단위 시간당 1의 속도로 slow를 추격한다. 따라서 (ls-p) 단계 뒤에 두 노드가 충돌하게 된다
 * 7. 이 시점에는 slow가 루프 시작지점에서 (ls-p)만큼 전진했으므로, 루프 시작지점까지 p만큼 남았다고 볼 수 있다.
 *  => 충돌지점은 루프 시작지점까지 p만큼 남은 지점이다.
 *  => p = k % ls 이므로, k = ls * M + p인 M이 존재하고, 따라서 그냥 루프 시작지점으로부터 k만큼 남은 지점이라고 봐도 된다.
 *  => 이 시점에서 slow를 리스트 시작지점으로 옮긴다.
 *  => 그러면 slow는 루프 바깥의 관점에서 루프 시작지점으로부터 k만큼 이전에 있고,
 *  => fast는 루프 안쪽의 관점에서 루프 시작지점으로부터 k만큼 이전에 있다.
 *  => 이 상태에서 slow와 fast를 둘 다 1씩 이동시키면 k번째에 다시 충돌하게 되고 이것이 루프 시작지점이다.
 */
public class Problem1Book {
    public Node findBeginning(Node root) {
        if(root == null) return null;
        Node slow = root;
        Node fast = root;

        while(fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if(slow == fast) {
                break;
            }
        }

        if(fast == null || fast.getNext() == null) {
            return null;
        }

        slow = root;
        while(slow != fast) {
            slow = slow.getNext();
            fast = fast.getNext();
        }

        return fast;
    }
}
