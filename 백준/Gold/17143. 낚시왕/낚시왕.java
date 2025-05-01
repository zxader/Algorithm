import java.io.*;
import java.util.*;

public class Main {
	static class Shark {
		int r, c, s, d, z;
		
		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
		
		public void move() {
			if (this.d == 1 || this.d == 2) {
				move(d, this.s % (2 * (R - 1)));
			}
			else {
				move(d, this.s % (2 * (C - 1)));
			}
		}
		
		public void move(int d, int s) {
			while (--s >= 0) {
				switch(d) {
				case 1:
					this.r--;
					if (this.r < 1) {
						this.r = 2; 
						d = 2;
					}
					break;
				case 2:
					this.r++;
					if (this.r > R) {
						this.r = R - 1; 
						d = 1;
					}
					break;
				case 3:
					this.c++;
					if (this.c > C) {
						this.c = C - 1; 
						d = 4;
					}
					break;
				case 4:
					this.c--;;
					if (this.c < 1) {
						this.c = 2; 
						d = 3;
					}
					break;
				}
			}
			this.d = d;
		}
	}
	
	static int R, C, M, result;
	static Map<Integer, TreeMap<Integer, Shark>> map;
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	R = Integer.parseInt(st.nextToken());
    	C = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	map = new HashMap<>();
    	
    	for (int i = 1; i <= C; i++) {
    		map.put(i, new TreeMap<>());
    	}
    	
    	for (int i = 0; i < M; i++) {
    		st = new StringTokenizer(br.readLine());
    		int r = Integer.parseInt(st.nextToken());
    		int c = Integer.parseInt(st.nextToken());
    		int s = Integer.parseInt(st.nextToken());
    		int d = Integer.parseInt(st.nextToken());
    		int z = Integer.parseInt(st.nextToken());
    		
    		map.get(c).put(r, new Shark(r, c, s, d, z));
    	}
    	
    	for (int i = 1; i <= C; i++) {
    		getFish(i);
    		moveShark();
    	}
    	
    	System.out.println(result);
	}
	
	static public void getFish(int i) {
		if (map.get(i).isEmpty()) return;
		int key = map.get(i).firstKey();
		result += map.get(i).get(key).z;
		map.get(i).remove(key);
	}
	
	static public void moveShark() {
		List<Shark> list = new ArrayList();
		for (int i = 1; i <= C; i++) {
			for (Map.Entry<Integer, Shark> entry : map.get(i).entrySet()) {
				Shark shark = entry.getValue();
				shark.move();
				list.add(shark);
			}
			map.put(i, new TreeMap<>());
		}
		
		for (Shark shark : list) {
			if (map.get(shark.c).containsKey(shark.r)) {
				Shark temp = map.get(shark.c).get(shark.r);
				if (shark.z > temp.z) {
					map.get(shark.c).put(shark.r, shark);
				}
			}
			else {
				map.get(shark.c).put(shark.r, shark);
			}
		}
	}
}
