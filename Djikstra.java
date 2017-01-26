import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

public class Djikstra {

	Vertex[] V;
	int size;
	public static final int INFINITY = Integer.MAX_VALUE;
	
	public Djikstra(int numberofvertices) {
		 V = new Vertex[numberofvertices+1];
		 size = numberofvertices;
		for(int i =1;i<=size;i++)
		{
			V[i] = new Vertex(i);
		}
	}
	
	void addEdge(int m, int n)
	{
		Edge e = new Edge(V[m],V[n]);
		V[m].adj.add(e);
		V[n].adj.add(e);
	}
	
	class Vertex implements Iterable<Vertex>, Comparable<Vertex>
	{

		public boolean seen;
		public int distance;
		public LinkedList<Edge> adj;
		public int name;
		
		
		
		
		
		public Vertex(int i) {
			name =i;
			seen = false;
			distance = INFINITY;
			adj = new LinkedList<Edge>();
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
			
			  public void remove() {
					throw new UnsupportedOperationException();
				    }
		}

		
		
		@Override
		public int compareTo(Vertex V) {
			if(this.distance<V.distance)
				return -1;
			else if(this.distance>V.distance)
				return 1;
			else if(this.distance == V.distance)
			{
				if(this.name < V.name)
					return -1;
				else if(this.name > V.name)
					return 1;
				else
					return 0;
			}
			else
		     	return 0;
			
		}
		
	}
	
	class Edge 
	{
		Vertex from;
		Vertex to;
		int distance;
		
		Edge(Vertex m, Vertex n)
		{
			from = m;
			to =n;
			distance =6;
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
	
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int numqueries = in.nextInt();
		Djikstra[] hg = new Djikstra[numqueries];
		
		for(int i =0;i<numqueries;i++)
		{
			int numberofvertices = in.nextInt();
			int numberofedges = in.nextInt();
			
			hg[i] = new Djikstra(numberofvertices);
			
			for(int j =0;j<numberofedges;j++)
			{
				int m = in.nextInt();
				int n = in.nextInt();
			
				hg[i].addEdge(m, n);
			}
			
		int sourcenode = in.nextInt();
			hg[i].djikstra(sourcenode);
		}
		in.close();
		
	}

	private void djikstra(int Source) {
		
		V[Source].distance = 0;
		TreeSet<Vertex> Vertexqueue = new TreeSet<Vertex>();
		for(Vertex v: V)
		{
			if(v!=null)
			{
				Vertexqueue.add(v);
			}
		}
		
		while(Vertexqueue.size()!=0)
		{
			Vertex u = Vertexqueue.pollFirst();
			for(Edge e:u.adj)
			{
				Vertex v = e.otherEnd(u);
				int alternateDistance = u.distance+e.distance;
				
				if(v.distance > alternateDistance)
					v.distance = alternateDistance;
			}
			
		}
		
		for(Vertex v:V)
		{
			if(v!=null)
			{
				if(v.distance!=0)
				{
					if(v.distance == INFINITY)
						System.out.print("-1 ");
					else
						System.out.print(v.distance+" ");
				}
			}
			
		}
		System.out.println();
	}

}
