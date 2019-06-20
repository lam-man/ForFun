package graph;

import java.util.*;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // corner case
        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) {
            return false;
        }

        // add courses and prerequisites into hash map
        Map<Integer, List<Integer>> edges = new HashMap<>(); // {0 : [1]}
        Set<Integer> neededPrerequisites = new HashSet<>(); // [1]
        for (int[] pair : prerequisites) {
            neededPrerequisites.add(pair[0]);
            List<Integer> courses = edges.getOrDefault(pair[1], new ArrayList<Integer>());
            courses.add(pair[0]);
            edges.put(pair[1], courses);
        }

        // get all courses needed prerequisites
        int takeFirst = -1; // 0
        for (int i = 0; i < numCourses; i++) {
            if (!neededPrerequisites.contains(i)) {
                takeFirst = i;
                break;
            }
        }

        if (takeFirst == -1) {
            return false;
        }

        return bfsCheck(numCourses, takeFirst, edges);
    }

    private boolean bfsCheck(int numCourses, int takeFirst, Map<Integer, List<Integer>> edges) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(takeFirst);
        Set<Integer> takedCourses = new HashSet<>();

        while (!queue.isEmpty()) {
            int current = queue.poll();
            takedCourses.add(current);
            List<Integer> canTake = edges.getOrDefault(current, new ArrayList<>());
            for (int course : canTake) {
                queue.offer(course);
            }
        }
        return takedCourses.size() == numCourses;
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = new int[][] {{1, 0}};

        CourseSchedule schedule = new CourseSchedule();
        schedule.canFinish(numCourses, prerequisites);
    }

}