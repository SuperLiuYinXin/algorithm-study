package com.liuyinxin;

/**
 * 874. 行走机器人模拟
 */
public class RobotSim {

    public static void main(String[] args) {

        RobotSim s = new RobotSim();

        int[] cmd = {-2,-1,-2,3,7};

        int[][] obs = {
                {1,-3},{2,-3},{4,0},{-2,5},{-5,2},{0,0},{4,-4},{-2,-5},{-1,-2},{0,2}
        };
        System.out.println(s.robotSim(cmd, obs));

    }

    int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int robotSim(int[] commands, int[][] obstacles) {
        int tmpX, tmpY;
        int curD = 0; // 北
        int x = 0, y = 0;
        int max = Integer.MIN_VALUE;

        for (int cmd: commands) { // 方向
            if (cmd == -2) { // 向左
                curD = (curD + 3) % 4;
            } else if (cmd == -1) { //向右
                curD = (curD + 1) % 4;
            } else {

                tmpX = x + cmd * d[curD][0];
                tmpY = y + cmd * d[curD][1];

                for (int[] obs : obstacles) { // 如果有一个方向相同
                    if (obs[0] == x) {
                        if (y <= obs[1] && obs[1] <= tmpY){
                            tmpY = obs[1] - 1;
                        }else if (tmpY <= obs[1] && obs[1] <= y){
                            tmpY = obs[1] + 1;
                        }
                    } else if (obs[1] == y) {
                        if (x <= obs[0] && obs[0] <= tmpX){
                            tmpX = obs[0] - 1;
                        } else if (tmpX < obs[0] && obs[0] < x){
                            tmpX = obs[0] + 1;
                        }
                    }
                }
                x = tmpX;
                y = tmpY;
                System.out.println(x + "  " + y);
                max = Integer.max(max, x * x + y * y);
            }
        }
        return max;
    }
}
