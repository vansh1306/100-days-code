class Solution {
  
    public int numUniqueEmails(String[] emails) {
        // Create a hash set to store unique emails
        Set<String> uniqueEmails = new HashSet<>();
      
        // Iterate over each email in the provided array
        for (String email : emails) {
            // Split the email into local and domain parts
            String[] parts = email.split("@");
            String localPart = parts[0];
            String domainPart = parts[1];
          
            // Remove all periods from the local part
            localPart = localPart.replace(".", "");
          
            // Check for a '+' character and cut off any substring after it in the local part
            int plusIndex = localPart.indexOf('+');
            if (plusIndex != -1) {
                localPart = localPart.substring(0, plusIndex);
            }
          
            // Combine the processed local part with the domain part
            String cleanEmail = localPart + "@" + domainPart;
          
            // Add the clean email to the set (duplicates are ignored)
            uniqueEmails.add(cleanEmail);
        }
      
        // Return the number of unique emails found, which is the size of the set
        return uniqueEmails.size();
    }
}