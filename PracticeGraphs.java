import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PracticeGraphs {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }
    public static void bfs(ArrayList<Edge> graph[]){
        boolean vis[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            bfsUtil(graph,vis);
        }
    }
    public static void bfsUtil(ArrayList<Edge> graph[],boolean vis[]){//O(V+E)---V->Vertex,E->Edges
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            int curr=q.remove();
            if(!vis[curr]){
                System.out.print((curr+" "));
                vis[curr]=true;
                for(int i=0;i<graph[curr].size();i++){
                    Edge e=graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }
    public static void dfs(ArrayList<Edge>[] graph){
        boolean vis[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                dfsUtil(graph,i,vis);
            }
        }
    }
    public static void dfsUtil(ArrayList<Edge> graph[],int curr,boolean vis[]){//O(V+E)---V->Vertex,E->Edges
        System.out.print(curr+" ");
        vis[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!vis[e.dest]){
                dfsUtil(graph,e.dest,vis);
            }
        }
    }
    public static void topSort(ArrayList<Edge> graph[]){
        boolean vis[]=new boolean[graph.length];
        Stack<Integer> stack=new Stack<>();

        for(int i = 0;i < graph.length;i++){
            if(!vis[i]){
                topSortUtil(graph,i,vis,stack);
            }
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }
    public static void topSortUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> stack){
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!vis[e.dest]){
                topSortUtil(graph,e.dest,vis,stack);
            }
        }
        stack.push(curr);
    }

    public static void main(String[] args) {
        /*
                        (5)
                     0 --------- 1
                                / \
                            (1)/   \(3)
                              /     \
                             2-------3
                             |   (1)
                          (2)|
                             |
                             4
         */
        int V=6;
        ArrayList<Edge>[] graph=new ArrayList[V];
        for(int i=0;i<V;i++){
            graph[i]=new ArrayList<>();
        }
        //vertex-0
        graph[0].add(new Edge(0,1,5));
        //vertex-1
        graph[1].add(new Edge(1,0,5));
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,3));
        //vertex-2
        graph[2].add(new Edge(2,1,1));
        graph[2].add(new Edge(2,4,1));
        graph[2].add(new Edge(2,5,2));
        //vertex-3
        graph[3].add(new Edge(3,1,3));
        graph[4].add(new Edge(4,2,3));
        graph[5].add(new Edge(5,2,3));

//        bfs(graph);
        dfs(graph);
//        topSort(graph);
    }
}
