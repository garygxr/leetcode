package leetcode.editor.cn;

/**
 * @Author garygan
 * @Date 2022/7/16 19:15
 * @Description
 */
public class RobotWalk {
    public static void main(String[] args) {
        robotwalk();
    }

    public static void robotwalk() {
        int walk = raWalk(1, 8, 3, 8);
        System.out.println(walk);
    }

    // 递归法
    public static int raWalk(int curr, int rest, int aim, int n) {
        if (rest == 0) {
            return curr == aim ? 1 : 0;
        }
        int leftWalk =0;
        if (curr>0){
            leftWalk = raWalk(curr - 1, rest-1, aim, n);
        }
        int rightWalk=0;
        if(curr<n){
            rightWalk = raWalk(curr + 1, rest-1, aim, n);
        }
        return leftWalk+rightWalk;
    }
}
