package mouseMigong;


public class miGong {
    public static void main(String[] args) {
        int [][] map = new int[8][7];//设置一个8行7列的map
        //先将第一行和最后一行最不置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //再将第一列和最后一列设置为1
        for (int j = 0; j < 8; j++) {
            map[j][0] = 1;
            map[j][6] = 1;
        }
        //设置单独的为1
        map[3][1]=1;
        map[3][2]=1;
       // map[2][2]=1;//回溯设置



        //遍历map
        System.out.println("====开始时候的迷宫====");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();//换行
        }

        //调用递归
        T t = new T();
        t.findWay( map,1,1);
        System.out.println("\n====老鼠出迷宫的轨迹====");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();//换行
        }

    }


    static class T {
        //使用递归回溯思想来解决老鼠出迷宫
        //1.findWay方法就是专门用来找出迷宫的路劲
        //2.如果找到，就返回true，否则返回false
        //3.map就是二维数组，即表示迷宫
        //4.i，j就是老鼠的位置，初始化位置为（1,1）
        //5.因为我们使用的是递归找路所以我们先规定map数组的各个值的含义
        //0表示可以走，1表示障碍物，2表示可以走，3表示走过但是走不通是死路
        //6.当map[6][5]=2 就说找到通路，就结束，否则继续找
        //7.确定老鼠找路的策略 下—>右->上->左
        public boolean findWay(int [][] map,int i,int j){
            if (map[6][5] == 2){//说明已经找到
                return true;
            }else {
                if (map[i][j] == 0) {//当前位置为0，表明可以走
                    //将设我们可以走通
                    map[i][j] = 2;
                    //使用刚设定的策略开始走
                    if (findWay(map, i + 1, j)) { //开始走上边
                        return true;
                    } else if (findWay(map, i, j + 1)) {//开始走右边
                        return true;
                    } else if (findWay(map, i - 1, j)) {//开始走下边
                        return true;
                    } else if (findWay(map, i, j - 1)) {//开始走左边
                        return true;
                    } else { //如果上下左右都走不通的话那么就将该点设为3，
                        map[i][j] = 3;
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
    }
}
