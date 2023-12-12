import java.util.*;

public class TarjansAlgo {
//    static int time=0;
//    static void APUtil(ArrayList<ArrayList<Integer>> adj,int u,boolean vis[], int disc[],int low[],
//                       int parent,boolean isAP[]){
//        int children=0;
//        vis[u]=true;
//        disc[u]=low[u]=++time;
//        for(Integer v:adj.get(u)){
//            if(!vis[v]){
//                children++;
//                APUtil(adj,v,vis,disc,low,u,isAP);
//                low[u]=Math.min(low[u],low[v]);
//                if(parent!=-1&&low[v]>disc[u]){
//                    isAP[u]=true;
//                }
//            }else if(v!=parent){
//                low[u]=Math.min(low[u],disc[v]);
//            }
//        }
//        if(parent==-1&&children>1){
//            isAP[u]=true;
//        }
//    }
//    static void AP(ArrayList<ArrayList<Integer>> adj, int V){
//        boolean vis[]=new boolean[V];
//        int disc[]=new int[V];
//        int low[]=new int[V];
//        boolean[] isAP=new boolean[V];
//        for(int u=0;u<V;u++){
//            if(vis[u]==false){
//                APUtil(adj,u,vis,disc,low,-1,isAP);
//            }
//        }
//        for(int u=0;u<V;u++){
//            if(isAP[u]==true){
//                System.out.print(u+" ");
//            }
//        }
//        System.out.println();
//    }
    static class Edge{
        int src;
        int dest;
        public Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public static void dfs(ArrayList<Edge> graph[],int curr,int par,int dt[],
                           int low[],int time,boolean vis[],boolean ap[]){
        vis[curr]=true;
        dt[curr]=low[curr]=++time;
        int children=0;

        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
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
    public static void getAP(ArrayList<Edge> graph[],int V){
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

    public static void main(String[] args) {
        int V=10;
        ArrayList<ArrayList<Integer>> adj1=new ArrayList<ArrayList<Integer>>(V);
        for(int i=0;i<V;i++){
            adj1.add(new ArrayList<Integer>());
        }
        adj1.get(0).add(1);
//        adj1.get(0).add(0);
        adj1.get(1).add(2);
        adj1.get(1).add(3);
        adj1.get(2).add(0);
//        adj1.get(2).add(1);
//        adj1.get(3).add(0);
        adj1.get(3).add(4);
        adj1.get(4).add(9);
        adj1.get(9).add(3);
        adj1.get(4).add(5);
        adj1.get(5).add(6);
        adj1.get(6).add(7);
        adj1.get(7).add(8);
        adj1.get(8).add(6);
//        adj1.get(5).add(6);
        System.out.println(adj1);
        System.out.println("APs are : ");
//        AP(adj1,V);
    }
}
