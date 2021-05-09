package kakao;
import java.util.*;
class Node implements Comparable<Node>{
    int end, weight;

    public Node(int end, int weight){
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}

class Solution4 {
    static List<Node>[] list;
    static int[] dist;
    static int v,e,k;
    public int solution(int n, int start, int end, int[][] roads, int[] traps) {
        int answer = 0;
        return answer;
    }
    private static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] check = new boolean[3000 + 1];
        queue.add(new Node(start, 0));
        dist[start] = 0;
        list = new ArrayList[3000 + 1];
        dist = new int[3000 + 1];

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            int cur = curNode.end;

            if (check[cur] == true) continue;
            check[cur] = true;

            for (Node node : list[cur]) {
                if (dist[node.end] > dist[cur] + node.weight) {
                    dist[node.end] = dist[cur] + node.weight;
                    queue.add(new Node(node.end, dist[node.end]));
                }
            }
        }
    }
}
