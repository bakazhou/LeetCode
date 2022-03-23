package DailyCode.topic1036;

public class answer {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return dfs(visited,arr,start);
    }
    public boolean dfs(boolean[] visited,int[] arr,int location){
        if (location<0 || location>=arr.length || visited[location]) return false;
        if (arr[location]==0) return true;
        visited[location]=true;
        return dfs(visited, arr, location+arr[location]) || dfs(visited, arr, location-arr[location]);
    }
}
