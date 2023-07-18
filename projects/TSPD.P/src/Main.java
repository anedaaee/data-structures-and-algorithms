
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private final int N, start;
    private final int[][] distance;
    private List<Integer> tour = new ArrayList<>();
    private double minTourCost = Double.POSITIVE_INFINITY;
    private boolean ranSolver = false;

    public Main(int[][] distance) {
        this(0, distance);
    }

    public Main(int start, int[][] distance) {
        N = distance.length;

        if (N <= 2) throw new IllegalStateException("N <= 2 not yet supported.");
        if (N != distance[0].length) throw new IllegalStateException("Matrix must be square (n x n)");
        if (start < 0 || start >= N) throw new IllegalArgumentException("Invalid start node.");

        this.start = start;
        this.distance = distance;
    }


    public List<Integer> getTour() {
        if (!ranSolver) solve();
        return tour;
    }


    public double getTourCost() {
        if (!ranSolver) solve();
        return minTourCost;
    }

    public void solve() {

        if (ranSolver) return;

        final int END_STATE = (1 << N) - 1;
        Double[][] memo = new Double[N][1 << N];

        for (int end = 0; end < N; end++) {
            if (end == start) continue;
            memo[end][(1 << start) | (1 << end)] = (double) distance[start][end];
        }

        for (int r = 3; r <= N; r++) {
            for (int subset : combinations(r, N)) {
                if (notIn(start, subset)) continue;
                for (int next = 0; next < N; next++) {
                    if (next == start || notIn(next, subset)) continue;
                    int subsetWithoutNext = subset ^ (1 << next);
                    double minDist = Double.POSITIVE_INFINITY;
                    for (int end = 0; end < N; end++) {
                        if (end == start || end == next || notIn(end, subset)) continue;
                        double newDistance = memo[end][subsetWithoutNext] + distance[end][next];
                        if (newDistance < minDist) {
                            minDist = newDistance;
                        }
                    }
                    memo[next][subset] = minDist;
                }
            }
        }


        for (int i = 0; i < N; i++) {
            if (i == start) continue;
            double tourCost = memo[i][END_STATE] + distance[i][start];
            if (tourCost < minTourCost) {
                minTourCost = tourCost;
            }
        }

        int lastIndex = start;
        int state = END_STATE;
        tour.add(start);


        for (int i = 1; i < N; i++) {

            int bestIndex = -1;
            double bestDist = Double.POSITIVE_INFINITY;
            for (int j = 0; j < N; j++) {
                if (j == start || notIn(j, state)) continue;
                double newDist = memo[j][state] + distance[j][lastIndex];
                if (newDist < bestDist) {
                    bestIndex = j;
                    bestDist = newDist;
                }
            }

            tour.add(bestIndex);
            state = state ^ (1 << bestIndex);
            lastIndex = bestIndex;
        }

        tour.add(start);
        Collections.reverse(tour);

        ranSolver = true;
    }

    private static boolean notIn(int elem, int subset) {
        return ((1 << elem) & subset) == 0;
    }

    public static List<Integer> combinations(int r, int n) {
        List<Integer> subsets = new ArrayList<>();
        combinations(0, 0, r, n, subsets);
        return subsets;
    }

    private static void combinations(int set, int at, int r, int n, List<Integer> subsets) {

        int elementsLeftToPick = n - at;
        if (elementsLeftToPick < r) return;

        if (r == 0) {
            subsets.add(set);
        } else {
            for (int i = at; i < n; i++) {

                set ^= (1 << i);

                combinations(set, i + 1, r - 1, n, subsets);

                set ^= (1 << i);
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        W w = new W();
        int [][] W = w.getW();


        int startNode = 0;
        Main solver =
                new Main(0,W);

        System.out.println("Tour: " + solver.getTour());

        System.out.println("Tour cost: " + solver.getTourCost());
    }
}