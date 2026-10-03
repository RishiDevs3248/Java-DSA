public class ActivitySelection {

    public static int maxJobs(int jobStart[], int jobEnd[]){
        int maxJobsCount = 1;
        int lastEndTime = jobEnd[0];
        for (int i = 1; i < jobEnd.length; i++) {
            if(jobStart[i] >= lastEndTime){
                maxJobsCount++;
                lastEndTime = jobEnd[i];
            }
        }
        return maxJobsCount;
    }

    public static void main(String[] args) {
        int jobStart[] = {1, 3, 0, 5, 8, 5};
        int jobEnd[] = {2, 4, 6, 7, 9, 9};

        System.out.println(maxJobs(jobStart, jobEnd));
    }
}
