import java.util.*;

public class Airlines {

	public static int radius = 6378;

	public static double[][] weights;
	public static boolean[][] conn;

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		int cases = 1;

		int N = sc.nextInt();

		int M = sc.nextInt();
		int Q = sc.nextInt();
		HashMap<String, Node> hm = new HashMap<String, Node>();

		while (!(N < 0 && M < 0 && Q < 0)) {


			conn = new boolean[N][N];
			weights = new double[N][N];

			for (int i = 0; i < N; i++) {

				Arrays.fill(weights[i], -1);
				Arrays.fill(conn[i], false);
			}


			for (int i = 0; i < N; i++) {

				String city = sc.next();

				double lt = sc.nextDouble();

				double ln = sc.nextDouble();


				hm.put(city, new Node(city, lt, ln, i));

			}

			//DirectFlight
			// it puts the distance of the direct flight into the node that is located
			// in the hashmap.
			// I should put the city in the map by now.
			for (int i = 0; i < M; i++) {

				String firstC = sc.next();
				String secC = sc.next();
				double dist = getDistanceFromLatLonInKm(hm.get(firstC).lt, hm.get(firstC).ln, hm.get(secC).lt, hm.get(secC).ln);

				if(hm.containsKey(firstC) && hm.containsKey(secC)) {

					hm.get(firstC).addN(secC, dist);

				}

				addEdge(hm.get(firstC).getNum(), hm.get(secC).getNum(), dist);

			}


			System.out.println("Case #" + cases);
			//Djikstra
			for (int i = 0; i < Q; i++) {

				String firstCTS = sc.next();
				String secCTS = sc.next();

				double distance = dijkstra(hm.get(firstCTS).getNum(), hm.get(secCTS).getNum());

				if(distance == Integer.MAX_VALUE) {
					System.out.println("no route exists");
				} else {
					System.out.println( distance + " km");
				}


			}



			N = sc.nextInt();
			M = sc.nextInt();
			Q = sc.nextInt();

			cases++;
		}

		sc.close();
	}

	public static double getDistanceFromLatLonInKm(double lat1, double lon1, double lat2, double lon2) {

		double dLat = deg2rad(lat2-lat1);  // deg2rad below
		double dLon = deg2rad(lon2-lon1); 
		double a = 
				Math.sin(dLat/2) * Math.sin(dLat/2) +
				Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * 
				Math.sin(dLon/2) * Math.sin(dLon/2)
				; 
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
		double d = radius * c; // Distance in km
		return d;
	}

	public static double deg2rad(double deg) {
		return deg * (Math.PI/180);
	}

	//add edge
	public static void addEdge(int source, int dest, double weight) { 

		conn[source][dest] = true;
		weights[source][dest] = weight;

	}

	public static void removeEdge(int source, int dest) {
		conn[source][dest] = false;
	}

	public static int size() {
		return conn.length;
	}


	//DJIKSTRA
	public static double dijkstra (int source, int dest) {

		boolean[] visited = new boolean[size()];
		double[] value = new double[size()];
		double[] prev = new double[size()];
		double[] dists = new double[size()];
		Arrays.fill(visited, false);
		Arrays.fill(value, Integer.MAX_VALUE);
		value[source] = 0; 
		prev[source] = -1;
		dists[source] = 1;
		int current = source;

		while(!visited[dest]) {
			for (int i = 0; i < size(); i++) {
				if (visited[i] || i == current) 
					continue;
				if (!conn[current][i]) 
					continue;

				double dist = (int) (value[current] + weights[current][i]);
				if (dist < value[i]) {
					value[i] = dist;
					prev[i] = current;
					dists[i] = dists[current] + 1;

				}

			}

			visited[current] = true;
			current = dest;
			for (int i = 0; i < size(); i++) {

				if (!visited[i] && value[i] < value[current] )
					current = i;

			}
		}

		return value[dest];
	}

}

class Node{

	String name;
	double lt, ln, dist;
	HashMap<String, Double> hm = new HashMap<String, Double>();
	int number;

	public int getNum() {
		return number;
	}

	public Node(String name, double lt, double ln, int number) {
		this.name = name;
		this.number = number;
		this.lt = lt;
		this.ln = ln;
	}

	public void addN(String name, double dist) {

		hm.put(name, dist);

	}




}


