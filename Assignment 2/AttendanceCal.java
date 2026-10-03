public class AttendanceCal {

    public static void main(String[] args) {

        int[] arr = {1, 1, 1, 0, 1, 0, 1, 0, 0, 1};

        int length = arr.length;

        int presentCount = 0;
        int absentCount = 0;

        // Count present and absent days
        for (int i = 0; i < length; i++) {

            if (arr[i] == 1) {
                presentCount++;
            }

            if (arr[i] == 0) {
                absentCount++;
            }
        }

        // Calculate attendance percentage
        double attendancePercentage =
                ((double) presentCount / length) * 100;

        // Variables for longest streaks
        int longestPresent = 0;
        int longestAbsent = 0;

        int presentStreak = 0;
        int absentStreak = 0;

        // Find longest continuous presence and absence
        for (int i = 0; i < length; i++) {

            if (arr[i] == 1) {
                presentStreak++;
                absentStreak = 0;
            } else {
                absentStreak++;
                presentStreak = 0;
            }

            if (presentStreak > longestPresent) {
                longestPresent = presentStreak;
            }

            if (absentStreak > longestAbsent) {
                longestAbsent = absentStreak;
            }
        }

        // Calculate additional days required for 75%
        int daysNeeded = 0;
        int currentPresent = presentCount;
        int currentTotal = length;

        while (((double) currentPresent / currentTotal) * 100 < 75) {

            currentPresent++;
            currentTotal++;
            daysNeeded++;
        }

        // Display report
        System.out.println("Number of present days: " + presentCount);
        System.out.printf("Attendance percentage: %.2f%%%n",
                attendancePercentage);

        System.out.println(attendancePercentage >= 75
                ? "Eligible: YES"
                : "Eligible: NO");

        System.out.println("Longest continuous presence: "
                + longestPresent);

        System.out.println("Longest continuous absence: "
                + longestAbsent);

        System.out.println("Number of additional continuous present days required: "
                + daysNeeded);
    }
}
