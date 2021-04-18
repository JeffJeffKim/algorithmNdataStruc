package proEdu.day4;

import java.io.*;
import java.util.StringTokenizer;

class Node {
    int y, x;
    Node(int a, int b) {
        y = a;
        x = b;
    }
}

class ThrowCoin_Soltion {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int w;
    static int h;
    static char[][] map;

    static int[][] cmds;
    static int[] invalidCmds; //�߸��� ��ɾ��϶� (���� �ִµ� ���� �� ������) 1 ����
    static int cmdCnt;

    static int[][] coin_BossToCnt; //�׷��� ������ �ִ� ������ ����
    static int[] coin_SizeToCnt; //Ư�� ������ � �ִ��� ����
    static int coin_Result; //��� ��� ����

    static int[][] bin_BossToCnt;
    static int[] bin_SizeToCnt;
    static int bin_Result;

    static Node[][] uArr; //���Ͽ����ε� �迭

    static void input() throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        map = new char[h][w];

        for (int y= 0; y<h; y++) {
            String line = br.readLine();
            for (int x = 0; x<w; x++) {
                map[y][x] = line.charAt(x); 
            }
        }

        cmdCnt = Integer.parseInt(br.readLine());        
        cmds = new int[cmdCnt][3];
        invalidCmds = new int[cmdCnt];

        for (int i = 0; i<cmdCnt; i++) {
            st = new StringTokenizer(br.readLine());
            cmds[i][0] = Integer.parseInt(st.nextToken());
            if (cmds[i][0] == 1) {
                cmds[i][1] = Integer.parseInt(st.nextToken());
                cmds[i][2] = Integer.parseInt(st.nextToken());
            }
            else {
                cmds[i][1] = Integer.parseInt(st.nextToken());
            }
        }

        coin_BossToCnt = new int[h][w];
        coin_SizeToCnt = new int[h * w * 2 + 2];
        bin_BossToCnt = new int[h][w];
        bin_SizeToCnt = new int[h * w + 1];
    }

    static Node getFind(int ty, int tx) {
        Node par = uArr[ty][tx];
        if (par.y == ty && par.x == tx) return par;
        Node ret = getFind(par.y, par.x);
        uArr[ty][tx].y = ret.y;
        uArr[ty][tx].x = ret.x;
        return ret;
    }

    static void setUnion(int dy, int dx, int ny, int nx, int tar) {
        Node ret;
        ret = getFind(dy, dx);
        Node a = new Node(ret.y, ret.x);

        ret = getFind(ny, nx);
        Node b = new Node(ret.y, ret.x);

        if (a.y == b.y && a.x == b.x) return;
        uArr[b.y][b.x].y = a.y; 
        uArr[b.y][b.x].x = a.x;

        //����� �۾�
        if (tar == '0') {
            int aCnt = coin_BossToCnt[a.y][a.x];
            int bCnt = coin_BossToCnt[b.y][b.x];
            coin_SizeToCnt[aCnt * 2]--;
            coin_SizeToCnt[bCnt * 2]--;

            coin_BossToCnt[a.y][a.x] += coin_BossToCnt[b.y][b.x];
            coin_BossToCnt[b.y][b.x] = 0;

            int newCnt = coin_BossToCnt[a.y][a.x];
            coin_SizeToCnt[newCnt * 2]++;
        }
        else {
            int aCnt = bin_BossToCnt[a.y][a.x];
            int bCnt = bin_BossToCnt[b.y][b.x];
            bin_SizeToCnt[aCnt]--;
            bin_SizeToCnt[bCnt]--;

            bin_BossToCnt[a.y][a.x] += bin_BossToCnt[b.y][b.x];
            bin_BossToCnt[b.y][b.x] = 0;

            int newCnt = bin_BossToCnt[a.y][a.x];
            bin_SizeToCnt[newCnt]++;
        }
    }

    static void makeUnion(int dy, int dx) {
        int[][] direct = {{-1, 0},{1, 0},{0, 1}, {0, -1}};
        char tar = map[dy][dx]; 

        for (int t = 0; t<4; t++) {
            int ny = dy + direct[t][0];
            int nx = dx + direct[t][1];
            if (ny < 0 || nx < 0 || ny >= h || nx >= w) continue;
            if (map[ny][nx] != tar) continue;

            setUnion(dy, dx, ny, nx, tar);
        }
    }

    static void insertThing(int y, int x, char tar) {
        map[y][x] = tar;
        if (tar == '0') {
            coin_SizeToCnt[2]++;
            coin_BossToCnt[y][x] = 1;
        }
        else {
            bin_SizeToCnt[1]++;
            bin_BossToCnt[y][x] = 1;
        }
    }

    static void initSetting(char tar)
    {   
        uArr = new Node[h][w];
        for (int y = 0; y<h; y++) {
            for (int x =0 ; x<w; x++) {
                uArr[y][x] = new Node(y, x); 
            }
        }

        int[][] list = new int[w * h][2];
        int t = 0;

        //������ ����Ʈ���ٰ� ���ȭ
        for (int y =0; y<h; y++) {
            for (int x = 0; x<w; x++) {
                if (map[y][x] == tar) {
                    list[t][0] = y;
                    list[t][1] = x;
                    t++;

                    if (tar == '0') map[y][x] = '_';
                    else map[y][x] = '0';
                }
            }
        }

        //������ �ϳ��� �ø���.
        for (int i = 0; i<t; i++) {
            int y = list[i][0];
            int x = list[i][1];
            map[y][x] = tar;
            insertThing(y, x, tar);
            makeUnion(y, x);
        }
    }

    public static void main(String[] args) throws IOException {        

        input();

        //���� ����
        initSetting('0');
        for (int i = 0; i < cmdCnt; i++) {            
            if (cmds[i][0] == 2) {
                coin_Result += coin_SizeToCnt[cmds[i][1]];
            }
            if (cmds[i][0] == 1) {
                //�̹� ������ �ִ°��� �� �ø��ٸ�
                if (map[cmds[i][1]][cmds[i][2]] == '0') {
                    invalidCmds[i] = 1;
                    continue;
                }

                //������ �ϳ��� �ø���.
                insertThing(cmds[i][1], cmds[i][2], '0');
                makeUnion(cmds[i][1], cmds[i][2]);
            }
        }

        //��ĭ ���� (���÷���)
        initSetting('_');
        for (int i = cmdCnt - 1; i >= 0; i--) {   
            if (cmds[i][0] == 2) {
                bin_Result += bin_SizeToCnt[cmds[i][1]];
            }
            if (cmds[i][0] == 1) {
                if (invalidCmds[i] == 1) continue;
                insertThing(cmds[i][1], cmds[i][2], '_');
                makeUnion(cmds[i][1], cmds[i][2]);
            }
        }

        bw.write((coin_Result + bin_Result) + "\n");

        br.close();
        bw.close();
    }
}