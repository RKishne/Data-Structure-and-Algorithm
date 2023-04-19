import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int V=sc.nextInt();//number of vertex

        int E=sc.nextInt();//number of edges

        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();

        for(int i=0;i<V;i++) graph.add(new ArrayList<Integer>());

        for(int i=0;i<E;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            graph.get(u).add(v);//only write that line of code,means it is directed graph
            graph.get(v).add(u);//we wrote those both lines,means it is undirected graph

        }
        System.out.print(graph);
        sc.close();


	}
}