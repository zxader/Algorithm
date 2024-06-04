import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb;
	static class Point{
		long x;
		long y;

		public Point(long x, long y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
	}
	public static void main(String[] args) throws Exception {
		sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		List<Point> points = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine().trim());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			points.add(new Point(x, y));
		}

		Stack<Point> result = grahamScan(points);
		sb.append(result.size());
		System.out.println(sb);
	}


	static Point root = new Point(Long.MAX_VALUE, Long.MAX_VALUE);

	static Stack<Point> grahamScan(List<Point> input) throws IOException {

		// 기준점 찾기
		for (int i = 0; i < input.size(); i++) {
			if (input.get(i).x < root.x) {
				root = input.get(i);
			} else if (input.get(i).x == root.x) {
				if (input.get(i).y < root.y) {
					root = input.get(i);
				}
			}
		}

		// 모든 점들을 반시계 방향으로 정렬하기
		input.sort(new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {    // return 1이면 자리를 바꾼다
				int result = ccw(root, p1, p2);

				if (result > 0) { // 반시계
					return -1;
				} else if (result < 0) { // 시계
					return 1;
				} else { // 직선
					long distance1 = dist(root, p1);
					long distance2 = dist(root, p2);

					if (distance1 > distance2) {    // 거리가 더 가까운 순으로 정렬
						return 1;
					}
                    else {
                        return -1;
                    }
				}
			}
		});

		Stack<Point> stack = new Stack<>();
		stack.add(root);

		for (int i = 1; i < input.size(); i++) {
			while (stack.size() > 1 && (ccw(stack.get(stack.size() - 2), stack.get(stack.size() - 1), input.get(i)) <= 0)) {    // first, second, next
				stack.pop();    // second 빼기
			}
			stack.add(input.get(i));    // next 넣기
		}

		return stack;
	}

	static int ccw(Point p1, Point p2, Point p3) {
		long result = (p2.x-p1.x)*(p3.y-p1.y)-(p3.x-p1.x)*(p2.y-p1.y);
		
		if (result > 0) {   // 반시계 방향
			return 1;
		} else if (result < 0) {    // 시계 방향
			return -1;
		} else {
			return 0;
		}
	}

	static long dist(Point p1, Point p2) {
		return (p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y);
	}
}