package com.company;

public class NumberOfProvinces {

    public static boolean[] visited;

    public int findCircleNum(int[][] isConnected) {
        visited = new boolean[isConnected.length];
        int provinces = 0;

        for(int i = 0; i < isConnected.length; i++){
            if(!visited[i]){
                visited[i] = true;
                visitProvince(isConnected, i);
                provinces++;
            }
        }

        return provinces;
    }

    public void visitProvince(int[][] isConnected, int index){
        for(int i=0; i < isConnected[index].length; i++){
            if(isConnected[index][i] == 1 && !visited[i]){
                visited[i] = true;
                visitProvince(isConnected, i);
            }
        }
    }

    public static void main(String[] args) {
        NumberOfProvinces nop = new NumberOfProvinces();
        int[][] cities = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(nop.findCircleNum(cities));
    }

}
