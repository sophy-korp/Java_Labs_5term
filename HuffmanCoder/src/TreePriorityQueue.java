import java.util.*;
class TreePriorityQueue {
    PriorityQueue<Node> priorityQueue;

    public TreePriorityQueue() {
        priorityQueue = new PriorityQueue<>();
    }

    public void addNode(Node node) {
        priorityQueue.add(node);
    }

    public Node poll() {
        return priorityQueue.poll();
    }

    public boolean isEmpty() {
        return priorityQueue.isEmpty();
    }
}