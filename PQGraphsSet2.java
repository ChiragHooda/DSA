import java.util.ArrayList;

public class PQGraphsSet2 {
    static class Edge{
        int src;
        int dest;
        public Edge(int s,int d){
            this.src=s;
            this.dest=d;
        }
    }
    public static boolean detectCycle(ArrayList<Edge> graph[]){
        boolean vis[]=new boolean[graph.length];
        for(int i=0;i< graph.length;i++){
            if(!vis[i]){
                if(detectCycleUtil(graph,vis,i,-1)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge> graph[],boolean vis[],int curr,int par){
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!vis[e.dest]){
                if(detectCycleUtil(graph,vis,e.dest,curr)){
                    return true;
                }
            }else if(vis[e.dest]&&e.dest!=par){
                return true;
            }
        }
        return false;
    }

    public static void pickNTask(ArrayList<Edge> graph[], int prerequisites[][], int n) {
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][0]].add(new Edge(prerequisites[i][0],prerequisites[i][1]));
            graph[prerequisites[i][1]].add(new Edge(prerequisites[i][1],prerequisites[i][0]));
        }
        if(detectCycle(graph)){
            System.out.println("not possible :(((");
        }else{
            System.out.println("possible :)))");
        }
    }
    static class Edge1{
        int src;
        int dest;
        public Edge1(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public static void dfs(ArrayList<Edge1> graph[],int curr,int par,int dt[],
                           int low[],int time,boolean vis[],boolean ap[]){
        vis[curr]=true;
        dt[curr]=low[curr]=++time;
        int children=0;

        for(int i=0;i<graph[curr].size();i++){
            Edge1 e=graph[curr].get(i);
            int neigh=e.dest;

            if(par==neigh){
                continue;
            }else if(vis[neigh]){
                low[curr]=Math.min(low[curr],dt[neigh]);
            }else{
                dfs(graph,neigh,curr,dt,low,time,vis,ap);
                low[curr]=Math.min(low[curr],low[neigh]);
                if(par!=-1&&dt[curr]<=low[neigh]){
//                    System.out.println("AP: "+curr);
                    ap[curr]=true;
                }
                children++;
            }
        }
        if(par==-1 && children>1){
//            System.out.println("AP :"+curr);
            ap[curr]=true;
        }
    }
    public static void getAP(ArrayList<Edge1> graph[],int V){
        int dt[]=new int[V];
        int low[]=new int[V];
        int time=0;
        boolean vis[]=new boolean[V];
        boolean ap[]=new boolean[V];

        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(graph,i,-1,dt,low,time,vis,ap);
            }
        }

        for(int i=0;i<V;i++){
            if(ap[i]){
                System.out.println("AP : "+i);
            }
        }
    }
    //Bridge in graph
    public static void dfs1(ArrayList<Edge1> graph[],int curr,int par,int low[],int dt[],boolean vis[],int time){
        vis[curr]=true;
        dt[curr]=low[curr]=++time;

        for(int i=0;i<graph[curr].size();i++){
            Edge1 e=graph[curr].get(i);
            int neigh=e.dest;
            if(par==neigh){
                continue;
            }else if(!vis[neigh]){
                dfs1(graph,neigh,curr,low,dt,vis,time);
                low[curr]=Math.min(low[curr],low[neigh]);
                if(dt[curr]< low[neigh]){
                    System.out.println("Bridge : "+curr+"--------"+neigh);
                }
            }else{
                low[curr]=Math.min(low[curr],dt[neigh]);
            }
        }
    }
    public static void tarjanBridge(ArrayList<Edge1> graph[],int V){
        int dt[]=new int[V];
        int low[]=new int[V];
        int time=0;
        boolean vis[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs1(graph,i,-1,low,dt,vis,time);
            }
        }
    }

    public static void main(String[] args) {
        int V=6;
        ArrayList<Edge1>[] graph=new ArrayList[V];
        for(int i=0;i<V;i++){
            graph[i]=new ArrayList<>();
        }
        //vertex-0
        graph[0].add(new Edge1(0,1));
        graph[0].add(new Edge1(0,2));
        graph[0].add(new Edge1(0,3));
        //vertex-1
        graph[1].add(new Edge1(1,0));
        graph[1].add(new Edge1(1,2));
//        graph[1].add(new Edge(1,3));
        //vertex-2
        graph[2].add(new Edge1(2,0));
        graph[2].add(new Edge1(2,1));
//        graph[2].add(new Edge(2,4));
        //vertex-3
        graph[3].add(new Edge1(3,0));
        graph[3].add(new Edge1(3,4));
        graph[3].add(new Edge1(3,5));
        //vertex-4
        graph[4].add(new Edge1(4,3));
        graph[4].add(new Edge1(4,5));
        //vertex-5
        graph[5].add(new Edge1(5,3));
        graph[5].add(new Edge1(5,4));
//        System.out.println(detectCycle(graph));
        int n=6;
        int prerequisites[][]={{0,2},{2,1},{1,3},{3,4},{4,5}};
        ArrayList<Edge> graph1[]=new ArrayList[n];
        for(int i=0;i<graph1.length;i++){
            graph1[i]=new ArrayList<>();
        }
        pickNTask(graph1,prerequisites,n);
        getAP(graph,V);
        tarjanBridge(graph,V);
    }
}

