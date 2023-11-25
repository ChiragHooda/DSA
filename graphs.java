import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class graphs {
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
                dfsUtil(graph,i,vis);
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
        public static boolean hasPath(ArrayList<Edge> graph[],int src,int dest,boolean vis[]){
            if(src==dest){//O(V+E)
                return true;
            }
            vis[src]=true;
            for(int i=0;i<graph[src].size();i++){
                Edge e=graph[src].get(i);
                if(!vis[e.dest] && hasPath(graph,e.dest,dest,vis)){
                    return true;
                }
            }
            return false;
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
            int V=5;
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
            graph[2].add(new Edge(2,3,1));
            graph[2].add(new Edge(2,4,2));
            //vertex-3
            graph[3].add(new Edge(3,1,3));
            graph[3].add(new Edge(3,2,1));
            //vertex-4
            graph[4].add(new Edge(4,2,2));
            //2's neighbour
            for(int i=0;i<graph[2].size();i++){
                Edge e=graph[2].get(i);
                System.out.println(e.dest);
            }
            bfs(graph);
            System.out.println();
            boolean vis[]=new boolean[graph.length];
            dfs(graph);
            System.out.println();
            System.out.println(hasPath(graph,0,5,new boolean[graph.length]));
        }
    }


