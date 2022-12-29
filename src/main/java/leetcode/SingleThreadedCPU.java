package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class SingleThreadedCPU {

    public static void main(String[] args) {
//        getOrder(new int[][]{{1, 2}, {2, 4}, {3, 2}, {4, 1}}); //
//        getOrder(new int[][]{{7, 10}, {7, 12}, {7, 5}, {7, 4}, {7, 2}});
//        getOrder(new int[][]{{19, 13}, {16, 9}, {21, 10}, {32, 25}, {37, 4}, {49, 24}, {2, 15}, {38, 41}, {37, 34}, {33, 6}, {45, 4}, {18, 18}, {46, 39}, {12, 24}});

//        getOrder(new int[][]{{46,9},{46,42},{30,46},{30,13},{30,24},{30,5},{30,21},{29,46},{29,41},{29,18},{29,16},{29,17},{29,5},{22,15},{22,13},{22,25},{22,49},{22,44}});
        getOrder(new int[][]{{5, 2}, {7, 2}, {9, 4}, {6, 3}, {5, 10}, {1, 1}});
    }

    public static int[] getOrder(int[][] tasks) {

        TreeMap<Integer, List<Task>> taskMap = new TreeMap<>();
        PriorityQueue<Task> queueOfTasks = new PriorityQueue<>(10, new Task());

        int[] output = new int[tasks.length];
        int outputIndex = 0;

        for (int i = 0; i < tasks.length; i++) {
            int enqueueTime = tasks[i][0];
            int processingTime = tasks[i][1];

            List<Task> listOfTasks = taskMap.get(enqueueTime);
            if (listOfTasks == null)
                listOfTasks = new ArrayList<>();

            listOfTasks.add(new Task(enqueueTime, processingTime, i));
            taskMap.put(enqueueTime, listOfTasks);
        }

        int totalProcessed = taskMap.firstKey();
        while (!taskMap.isEmpty()) {

            Map.Entry<Integer, List<Task>> entry = taskMap.pollFirstEntry();
            queueOfTasks.addAll(entry.getValue());

            try {
                int nextFetch = taskMap.firstKey();

                while (totalProcessed < nextFetch && !queueOfTasks.isEmpty()) {
                    Task polledTask = queueOfTasks.poll();
                    output[outputIndex++] = polledTask.getIndex();

                    if (totalProcessed < polledTask.getEnqueueTime()) {
                        totalProcessed = polledTask.getEnqueueTime() + polledTask.getProcessingTime();
                    } else {
                        totalProcessed += polledTask.getProcessingTime();
                    }

                }
            } catch (NoSuchElementException ignored) {
            }

            if (taskMap.isEmpty()) {
                // removeAll from queue and add to output
                while (!queueOfTasks.isEmpty()) {
                    output[outputIndex++] = queueOfTasks.poll().getIndex();
                }
            }
        }

//        System.out.println("================");
//        Arrays.stream(output).forEach(o -> System.out.print(o + ","));
        return output;
    }

    static class Task implements Comparator {
        private int enqueueTime;
        private int processingTime;

        private int index;

        public Task(int enqueueTime, int processingTime, int index) {
            this.enqueueTime = enqueueTime;
            this.processingTime = processingTime;
            this.index = index;
        }

        public Task() {
        }

        public int getEnqueueTime() {
            return enqueueTime;
        }

        public int getProcessingTime() {
            return processingTime;
        }

        public int getIndex() {
            return index;
        }

        @Override
        public String toString() {
            return "[" + enqueueTime + "," + processingTime + "," + index + "]";
        }

        @Override
        public int compare(Object o1, Object o2) {
            Task t1 = (Task) o1;
            Task t2 = (Task) o2;
            if (t1.getProcessingTime() == t2.getProcessingTime()) return Integer.compare(t1.getIndex(), t2.getIndex());
            return Integer.compare(t1.getProcessingTime(), t2.getProcessingTime());
        }
    }
}


