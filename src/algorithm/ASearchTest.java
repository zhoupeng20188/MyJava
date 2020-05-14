package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A*寻路算法
 * 思路，用两个数组分别存储将要探索的格子和已经探索的格子
 * 从起点开始，找到上下左右的格子，每个格子计算到起点的距离G和到终点的距离H
 * G+H得到F,计算四个格子中F值最小的，把这个格子作为新的当前格子，并放入已探索的格子中
 * 再计算当前格子上下左右的格子的距离G和H，依此循环，直到探索的格子list中有终点为止
 * 已探索的格子中记录了父格子，所以通过父格子即可输出最后的线路
 *
 * @Author zhoupeng
 * @Date 2020-05-14 11:09
 */
public class ASearchTest {
    private static int[][] maze = {
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
    };
    // 起点
    private static MyGrid startPoint = new MyGrid(1, 2);
    // 终点
    private static MyGrid endPoint = new MyGrid(6, 2);

    public static void main(String[] args) {

        ArrayList<MyGrid> searchingList = new ArrayList<>();
        ArrayList<MyGrid> searchedList = new ArrayList<>();
        ArrayList<MyGrid> barrierList = new ArrayList<>();
        barrierList.add(new MyGrid(3, 1));
        barrierList.add(new MyGrid(3, 2));
        barrierList.add(new MyGrid(3, 3));
        startPoint.setG(0);
        searchingList.add(startPoint);
        findPath(startPoint, searchingList, searchedList, barrierList);
    }

    /**
     * 寻找path
     *
     * @param currentGrid
     * @param searchingList
     * @param searchedList
     * @return
     */
    private static MyGrid findPath(MyGrid currentGrid, ArrayList<MyGrid> searchingList
            , ArrayList<MyGrid> searchedList
            , ArrayList<MyGrid> barrierList) {
        if (containGrid(searchingList, endPoint)) {
            showPath(searchingList);
            System.out.println("-----------------");
            showHistoryPath(searchedList);
            return null;
        } else {
            // 取得searchingList中F值最小的格子
            MyGrid minGrid = getMinGrid(searchingList, currentGrid);
            System.out.println("searchingList里最小格子删除" + minGrid);
            searchingList.remove(minGrid);
            System.out.println("加入格子到searchedList:" + minGrid.toString());
            searchedList.add(minGrid);
            // 把minGrid作为当前格子,并寻找其上下左右的格子,如果不在searchingList和searchedList中,则加入searchingList
            findAroundGrid(minGrid, searchingList, searchedList, barrierList);
            // 递归调用
            findPath(minGrid, searchingList, searchedList, barrierList);
        }

        return null;
    }

    /**
     * 打印path
     */
    private static void showPath(ArrayList<MyGrid> searchingList) {
        MyGrid endGrid = new MyGrid(0, 0);
        for (MyGrid myGrid : searchingList) {
            if (myGrid.getX() == endPoint.getX() && myGrid.getY() == endPoint.getY()) {
                endGrid = myGrid;
            }
        }
        ArrayList<MyGrid> pathGrid = new ArrayList<>();
        pathGrid.add(endGrid);
        while (endGrid.getParent() != null) {
            endGrid = endGrid.getParent();
            pathGrid.add(endGrid);
        }
        // 逆序输出
//        for (int i = pathGrid.size()-1; i >=0; i--) {
//            System.out.println(pathGrid.get(i).toString());
//        }
        // 输出迷宫和路径,路径用*表示
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (containGrid(pathGrid, new MyGrid(j, i))) {
                    if (j == startPoint.getX() && i == startPoint.getY()) {
                        System.out.print("S ");
                    } else if (j == endPoint.getX() && i == endPoint.getY()) {
                        System.out.print("E ");
                    } else {
                        System.out.print("* ");
                    }
                } else {
                    System.out.print(maze[i][j] + " ");
                }
            }
            System.out.println();
        }

    }

    private static void showHistoryPath(ArrayList<MyGrid> searchedList) {
        // 输出寻找过的历史记录
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (containGrid(searchedList, new MyGrid(j, i))) {
                    System.out.print("$ ");
                } else {
                    System.out.print(maze[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
    /**
     * 寻找上下左右的格子，并加入searchingList
     *
     * @param currentGrid
     * @param searchingList
     * @param searchedList
     */
    private static void findAroundGrid(MyGrid currentGrid
            , ArrayList<MyGrid> searchingList
            , ArrayList<MyGrid> searchedList
            , ArrayList<MyGrid> barrierList) {
        MyGrid upGrid = new MyGrid(currentGrid.getX(), currentGrid.getY() - 1, currentGrid);
        MyGrid downGrid = new MyGrid(currentGrid.getX(), currentGrid.getY() + 1, currentGrid);
        MyGrid leftGrid = new MyGrid(currentGrid.getX() - 1, currentGrid.getY(), currentGrid);
        MyGrid rightGrid = new MyGrid(currentGrid.getX() + 1, currentGrid.getY(), currentGrid);
        addToSearchingList(upGrid, searchingList, searchedList, barrierList);
        addToSearchingList(downGrid, searchingList, searchedList, barrierList);
        addToSearchingList(leftGrid, searchingList, searchedList, barrierList);
        addToSearchingList(rightGrid, searchingList, searchedList, barrierList);
    }

    private static void addToSearchingList(MyGrid grid
            , ArrayList<MyGrid> searchingList
            , ArrayList<MyGrid> searchedList
            , ArrayList<MyGrid> barrierList) {
        if (checkGrid(grid)
                && !containGrid(searchingList, grid)
                && !containGrid(searchedList, grid)
                && !containGrid(barrierList, grid)) {
            int g = grid.getParent().getG() + 1;
            int h = Math.abs(endPoint.getX() - grid.getX()) + Math.abs(endPoint.getY() - grid.getY());
            grid.setG(g);
            grid.setH(h);
            grid.setF(g + h);
            System.out.println("加入格子到searchingList:" + grid.toString());
            searchingList.add(grid);
        }
    }

    /**
     * 在searchingList中得到父节点为当前格子的F值最小的格子
     *
     * @param searchingList
     * @return
     */
    private static MyGrid getMinGrid(ArrayList<MyGrid> searchingList, MyGrid currentGrid) {
        int minf = 0;
        int mini = 0;
        int index = 0;
        for (int i = 0; i < searchingList.size(); i++) {
            MyGrid myGrid = searchingList.get(i);
            index++;
            int f = myGrid.getF();
            if (index == 1 || f < minf) {
                minf = f;
                mini = i;
            }
        }
        System.out.println("取得最小格子:" + searchingList.get(mini).toString());
        return searchingList.get(mini);
    }

    /**
     * check格子是否有效
     *
     * @param grid
     * @return
     */
    private static boolean checkGrid(MyGrid grid) {
        boolean flg = true;
        if (grid.getX() >= maze[0].length || grid.getX() < 0
                || grid.getY() >= maze.length || grid.getY() < 0) {
            flg = false;
        }
        return flg;
    }

    /**
     * 判断某个ArrayList<MyGrid>是否含有某个MyGrid
     *
     * @param list
     * @param myGrid
     * @return
     */
    private static boolean containGrid(ArrayList<MyGrid> list, MyGrid myGrid) {
        List<MyGrid> collect = list.stream().filter(g -> g.getX() == myGrid.getX() && g.getY() == myGrid.getY())
                .collect(Collectors.toList());
        return collect.isEmpty() ? false : true;
    }
}
