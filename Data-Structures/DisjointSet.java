import java.util.ArrayList;
import java.util.List;

class DisjointSet{

    List<Integer> rank;
    List<Integer> size;
    List<Integer> parent;

    DisjointSet(int n){
        rank = new ArrayList<>(n);
        parent = new ArrayList<>(n);
        size = new ArrayList<>(n);
        for(int i=0; i<n; i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUltimateParent(int n){
        if(parent.get(n) == n){
            return n;
        }
        int uParent = findUltimateParent(parent.get(n));
        parent.set(n, uParent);
        return uParent;
    }

    public void unionByRank(int u, int v){
        int ultimateU = findUltimateParent(u);
        int ultimateV = findUltimateParent(v);
        if(ultimateU == ultimateV){
            return;
        }
        else if(rank.get(ultimateU) > rank.get(ultimateV)){
            parent.set(ultimateV, ultimateU);
        }
        else if(rank.get(ultimateU) < rank.get(ultimateV)){
            parent.set(ultimateU, ultimateV);
        }
        else{
            parent.set(ultimateV, ultimateU);
            int newRank = rank.get(ultimateU) + 1;
            rank.set(ultimateU, newRank);
        }
    }

    public void unionBySize(int u, int v){
        int ultimateU = findUltimateParent(u);
        int ultimateV = findUltimateParent(v);
        if(ultimateU == ultimateV){
            return;
        }
        else if(rank.get(ultimateU) > rank.get(ultimateV)){
            parent.set(ultimateV, ultimateU);
            size.set(ultimateU, ultimateU + ultimateV);
        }
        else{
            parent.set(ultimateU, ultimateV);
            size.set(ultimateV, ultimateU + ultimateV);
        }   
    }


}

class Main{
    public static void main(String[] args){
        DisjointSet ds = new DisjointSet(4);
        ds.unionByRank(0, 1);
        ds.unionByRank(2, 3);
        if(ds.findUltimateParent(0) == ds.findUltimateParent(3)){
            System.out.println("same");
        }
        else{
            System.out.println("not same");
        }
        ds.unionByRank(1, 2);
        if(ds.findUltimateParent(0) == ds.findUltimateParent(3)){
            System.out.println("same");
        }
        else{
            System.out.println("not same");
        }
        ds = new DisjointSet(4);
        ds.unionBySize(0, 1);
        ds.unionBySize(2, 3);
        if(ds.findUltimateParent(0) == ds.findUltimateParent(3)){
            System.out.println("same");
        }
        else{
            System.out.println("not same");
        }
        ds.unionBySize(1, 2);
        if(ds.findUltimateParent(0) == ds.findUltimateParent(3)){
            System.out.println("same");
        }
        else{
            System.out.println("not same");
        }
    }
}