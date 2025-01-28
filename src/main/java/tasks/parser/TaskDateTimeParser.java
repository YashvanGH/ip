package tasks.parser;

public class TaskDateTimeParser {

    /**
     * Returns the parsed and formatted string to create an instance of the Deadlines class.
     *
     * @param line The line used to convert to the command string.
     * @return Parsed input for Deadlines class
     */
    public static String deadlineParser(String line) {
        // Extract description
        int startOfDescription = line.indexOf("] ") + 2;
        int endOfDescription = line.indexOf(" (Priority:");
        String description = line.substring(startOfDescription, endOfDescription).trim();

        // Extract priority
        int startOfPriority = line.indexOf("(Priority:") + 10;
        int endOfPriority = line.indexOf(")", startOfPriority);
        String priority = line.substring(startOfPriority, endOfPriority).trim().toUpperCase();

        // Extract deadline
        int startOfDeadline = line.indexOf("(by:") + 5;
        int endOfDeadline = line.lastIndexOf(")");
        String deadlineRaw = line.substring(startOfDeadline, endOfDeadline).trim();

        // Parse the date and time
        String[] deadlineParts = deadlineRaw.split(",");
        String datePart = deadlineParts[0].trim();
        String timePart = deadlineParts[1].trim();

        // Convert date to "D/M/YYYY"
        String[] dateSplit = datePart.split(" ");
        String formattedDate = dateSplit[0] + "/" + convertMonthToNumber(dateSplit[1]) + "/" + dateSplit[2];

        // Convert time to "HHmm"
        String formattedTime = convertTo24HourFormat(timePart);

        // Create the input
        String deadlineInput = "deadline " + description + " /by " + formattedDate + " " + formattedTime
                + " /priority " + priority;

        return deadlineInput;
    }

    /**
     * Returns the parsed and formatted string to create an instance of the Events class.
     *
     * @param line The line used to convert to the command string.
     * @return Parsed input for Events class
     */
    public static String eventParser(String line) {
        // Extract description
        int startOfDescription = line.indexOf("] ") + 2;
        int endOfDescription = line.indexOf(" (Priority:");
        String description = line.substring(startOfDescription, endOfDescription).trim();

        // Extract priority
        int startOfPriority = line.indexOf("(Priority:") + 10;
        int endOfPriority = line.indexOf(")", startOfPriority);
        String priority = line.substring(startOfPriority, endOfPriority).trim().toUpperCase();

        // Extract "from" time
        int startOfFrom = line.indexOf("(from:") + 7;
        int endOfFrom = line.indexOf("to:", startOfFrom) - 1;
        String from = line.substring(startOfFrom, endOfFrom).trim();

        // Format start date and time
        String[] fromParts = from.split(", ");
        String startDate = convertToDate(fromParts[0]);
        String startTime = convertTo24HourFormat(fromParts[1]);

        // Extract "to" time
        int startOfTo = line.indexOf("to:") + 4;
        int endOfTo = line.lastIndexOf(")");
        String to = line.substring(startOfTo, endOfTo).trim();

        // Format end date and time
        String[] toParts = to.split(", ");
        String endDate = convertToDate(toParts[0]);
        String endTime = convertTo24HourFormat(toParts[1]);

        // Create the input
        String eventInput = "event " + description + " /from " + startDate + " " + startTime +
                " /to " + endDate + " " + endTime + " /priority " + priority;

        return eventInput;
    }

    /**
     * Returns the string integer representation of each month.
     *
     * @param month The month to convert to its string integer representation.
     * @return The month as a string.
     */
    private static String convertMonthToNumber(String month) {
        switch (month.toLowerCase()) {
        case "january": return "1";
        case "february": return "2";
        case "march": return "3";
        case "april": return "4";
        case "may": return "5";
        case "june": return "6";
        case "july": return "7";
        case "august": return "8";
        case "september": return "9";
        case "october": return "10";
        case "november": return "11";
        case "december": return "12";
        default:
        }

        return "";
    }

    /**
     * Returns the 12-hour format string to its 24-hour format.
     *
     * @param time The 12-hour format of the time.
     * @return The 24-hour format of the time.
     */
    private static String convertTo24HourFormat(String time) {
        boolean isPM = time.toLowerCase().endsWith("pm");
        // This gets hours and minutes from 12-hour format
        String[] timeParts = time.substring(0,time.length() - 2).trim().split(":");
        int hours = Integer.parseInt(timeParts[0]);
        int minutes = Integer.parseInt(timeParts[1]);

        if (isPM && hours != 12) {
            hours += 12;
        } else if (!isPM && hours == 12) {
            hours = 0;
        }

        return String.format("%02d%02d", hours, minutes);
    }

    /**
     * Returns the date to this format d/M/yyyy.
     *
     * @param date The string representation of the date.
     * @return The date in the specified format.
     */
    private static String convertToDate(String date) {
        String[] dateParts = date.split(" ");
        String day = dateParts[0];
        String month = convertMonthToNumber(dateParts[1]);
        String year = dateParts[2];
        return day + "/" + month + "/" + year;
    }
}
