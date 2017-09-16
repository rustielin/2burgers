import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Raymond on 9/15/2017.
 */
public class kSUM
{
    private static int[] parseFile() {
        BufferedReader br = null;
        FileReader fr = null;
        try{
            fr = new FileReader("C:\\Users\\Raymond\\Desktop\\hack_into_it_20177\\Hack-Into-It-2017\\server\\data.csv");
            br = new BufferedReader(fr);

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                String nextLine = br.readLine();
                System.out.println(nextLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
    From: https://www.programcreek.com/2012/12/leetcode-3sum/
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(nums == null || nums.length<3)
            return result;

        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++){
            if(i==0 || nums[i] > nums[i-1]){
                int j=i+1;
                int k=nums.length-1;

                while(j<k){
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> l = new ArrayList<Integer>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[k]);
                        result.add(l);

                        j++;
                        k--;

                        //handle duplicate here
                        while(j<k && nums[j]==nums[j-1])
                            j++;
                        while(j<k && nums[k]==nums[k+1])
                            k--;

                    }else if(nums[i]+nums[j]+nums[k]<0){
                        j++;
                    }else{
                        k--;
                    }
                }
            }

        }

        return result;
    }
    public static void main(String args[]) {
        int[] test = {-1, 0, 1, 2, -1, 4};
        List<List<Integer>> result = kSUM.threeSum(test);
        System.out.println(result);
        kSUM.parseFile();
    }
}
