import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;



/*
 * Trying to implement graph before the interview
 */
public class Graph {
	
	public int time =0;
	Vertex[] V;
	int size;
	public static final int INFINITY = Integer.MAX_VALUE;
	
	public Graph(int numberofvertices) {
		 V = new Vertex[numberofvertices+1];
		 size = numberofvertices;
		for(int i =1;i<=size;i++)
		{
			V[i] = new Vertex(i);
		}
	}
	
	class Vertex implements Iterable<Vertex>
	{

		public boolean seen;
		public int distance;
		public LinkedList<Edge> adj;
		public int name;
		public Vertex parent;
		public String colour;
		public int starttime;
		public int finishtime;
		
		
		
		
		public Vertex(int i) {
			name =i;
			seen = false;
			distance = INFINITY;
			parent = null;
			adj = new LinkedList<Graph.Edge>();
		}

		@Override
		public String toString() {
			
			return Integer.toString(name);
		}
		@Override
		public Iterator<Vertex> iterator() {
			return new VertexIterator<Vertex>(V,size);
		}
		
		class VertexIterator<Vertex> implements Iterator<Vertex>
		{
			private Vertex[] V;
			private int N;
			private int nodeindex;

			public VertexIterator(Vertex[] v, int size) {
			V=v;
			N=size;
			nodeindex =0;
			}

			@Override
			public boolean hasNext() {
				return (nodeindex!=N);
			}

			@Override
			public Vertex next() {
				nodeindex++;
				return V[nodeindex];
			}
			
		}
		
	}
	
	class Edge 
	{
		Vertex from;
		Vertex to;
		int weight;
		
		Edge(Vertex m, Vertex n , int weight)
		{
			from = m;
			to =n;
			this.weight = weight;
		}
		
		@Override
		public String toString() {
			return "( "+from+","+to+" )";
		}
		
		public Vertex otherEnd(Vertex u) {
		    // if the vertex u is the head of the arc, then return the tail else return the head
		    if (from == u) {
			return to;
		    } else {
			return from;
		    }
		}
	}
	
	
	
	void addEdge(int m, int n,int weight)
	{
		Edge e = new Edge(V[m],V[n],weight);
		V[m].adj.add(e);
		V[n].adj.add(e);
	}

	public static void main(String[] args) {
	
		Scanner in = new Scanner(System.in);
		int numberofvertices = in.nextInt();
		int numberofedges = in.nextInt();
		
		Graph g = new Graph(numberofvertices);
		
		for(int i =0;i<numberofedges;i++)
		{
			int m = in.nextInt();
			int n = in.nextInt();
			int weight = in.nextInt();
			g.addEdge(m, n, weight);
		}
		in.close();
		
	    g.dfs();
		g.bfs();
	}

	

	private void dfs() {
		
		for(Vertex v: V)
		{
			if(v!=null)
			{
			v.colour = "White";
			v.parent = null;
			}
		}
		
		for(Vertex u: V)
		{
			if(u!=null)
			{
				if(u.colour.equals("White")){
				DFS_Visit(u);
			}
		}
		}
	}

	
	
	private void DFS_Visit(Vertex u) {
		u.colour = "Gray";
		u.starttime = ++time;
		for(Edge e : u.adj)
		{
			Vertex v = e.otherEnd(u);
			if(v.colour=="White")
			{
				v.colour="Gray";
				v.parent =u;
				DFS_Visit(v);
			}
			
		}
		
		u.colour = "Black";
		u.finishtime = ++time;
		System.out.print(u+" ");
	}

private void bfs() 
	{
	
	LinkedList<Vertex> queue = new LinkedList<Graph.Vertex>();
	for(Vertex v: V)
	{
		if(v!=null)
		{
		v.seen = false;
		v.parent = null;
		}
	}
	
	queue.add(V[1]);
	
	while(queue.size()!=0)
	{
		Vertex myvertex = queue.poll();
		if(!myvertex.seen)
		{
			for(Edge e:myvertex.adj)
			{
				Vertex v = e.otherEnd(myvertex);
				queue.add(v);
			}
			myvertex.seen = true;
			System.out.print(myvertex+" ");
		}
	}
	
	
		
	}
	

}
