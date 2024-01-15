//Tasks with memory required to process are given which should be run in a processor.
//        Tasks : [1,4,5,2,3] (the numbers represent memory needed)
//        Type of tasks are given in another array
//        Task Type : [1,2,1,3,4]
//        Another input is given which is the max memory the processor can run at a time.
//        Max_memory : 6
//        Now only two tasks with same task type can run in parallel. Assume each tasks take 1 unit of time. Find out the time taken to complete all the tasks.
//        Sample output : 4 units. Because there are two tasks of type 1 and adding their memory is 6 which is eq to max_memory. So they ll run in parallel. All other tasks are of different types and their memories are less than max_memory. So they ll each take 1 unit of time.
import java.util.*;

public class TaskProcessor {

    public static void main(String[] args) {
        int[] taskType = {1, 3, 4, 2, 1};
        int[] taskSpace = {1, 2, 3, 0, 5};
        int maxSpace = 6;
        int n = taskType.length;

        Map<Integer, List<Integer>> typeNSpace = new HashMap<>();
        for (int i = 0; i < n; i++) {
            typeNSpace.computeIfAbsent(taskType[i], k -> new ArrayList<>()).add(taskSpace[i]);
        }
        System.out.println(typeNSpace.entrySet());
        int count = 0;
        for (Integer i : typeNSpace.keySet()) {
            List<Integer> list = typeNSpace.get(i);
            int sum = list.stream().mapToInt(Integer::intValue).sum();
            if (sum <= maxSpace) {
                count++;
            } else {
                int rem = sum % maxSpace == 0 ? 0 : 1;
                count = count + (sum / maxSpace) + rem;
            }
        }
        System.out.println("Number of operations = " + count);
    }
//    public static void main(String[] args) {
//        int[] tasks = {1, 4, 5, 2, 3};
//        int[] taskTypes = {1, 2, 1, 3, 4};
//        int maxMemory = 6;
//
//        int timeTaken = getTimeTaken(tasks, taskTypes, maxMemory);
//        System.out.println("Time taken to complete all tasks: " + timeTaken + " units");
//    }

    public static int getTimeTaken(int[] tasks, int[] taskTypes, int maxMemory) {
        Map<Integer, Queue<Integer>> taskTypeMemoryMap = new HashMap<>();
        int timeTaken = 0;

        for (int i = 0; i < tasks.length; i++) {
            int taskType = taskTypes[i];
            int memory = tasks[i];

            if (!taskTypeMemoryMap.containsKey(taskType)) {
                taskTypeMemoryMap.put(taskType, new LinkedList<>());
            }

            Queue<Integer> taskMemoryQueue = taskTypeMemoryMap.get(taskType);
            taskMemoryQueue.offer(memory);

            if (taskMemoryQueue.size() == 2) {
                int totalMemory = taskMemoryQueue.poll() + taskMemoryQueue.poll();
                if (totalMemory <= maxMemory) {
                    taskMemoryQueue.offer(totalMemory);
                } else {
                    taskTypeMemoryMap.get(taskType).offer(totalMemory - maxMemory);
                }
                timeTaken += 1; // Two tasks of the same type running in parallel take 1 unit of time
            } else {
                timeTaken += 1; // Single task or the first task of the type takes 1 unit of time
            }
        }

        return timeTaken;
    }
}
