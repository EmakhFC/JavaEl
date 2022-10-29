import java.util.Arrays;
class Random{
    int[] m;
    int cnt = 0;
    public Random(int[] m, int[] v){
        for (int i : v) {
            cnt += i;
        }
        this.m = new int[cnt];
        cnt = 0;
        for (int i=0;i<v.length;i++){
            for (int j=0;j<v[i];j++){
                this.m[cnt] = m[i];
                cnt = cnt + 1;
            }
        }
    }
    public int random(){
        return this.m[(int)(Math.random()*(this.m.length))];
    }
}
public class Main {
    public static void main(String[] args) {
        Random r = new Random(new int[]{1, 2, 3}, new int[]{1, 2, 10});
        System.out.println(Arrays.toString(r.m));
        System.out.println("Рандомное число:");
        System.out.println(r.random());


    }
}

