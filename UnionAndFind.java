class UnionAndFind {
    private int[] root; // array store the parent of the node

    UnionAndFind(int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i; // in starting each number is its own root
        }
    }

    // TC O(1)
    int find(int x) {
        return root[x];
    }

    void union(int x, int y) {
        int rootX = find(x); // find the parent of x;
        int rootY = find(y);// find the parent of y;
        if (rootX != rootY) {
            for (int i = 0; i < root.length; i++) {
                if (root[i] == rootY) {
                    root[i] = rootX;
                }
            }
        }
    }

    boolean connected(int x, int y) {
        return find(x) == find(y); // same group
    }

    public static void main(String[] args) {
        UnionAndFind u = new UnionAndFind(10); // 10 Array 0 to 9
        u.union(1, 2);
        u.union(2, 5);
        u.union(5, 6);
        u.union(6, 7);
        System.out.println(u.connected(1, 5));

    }
}
