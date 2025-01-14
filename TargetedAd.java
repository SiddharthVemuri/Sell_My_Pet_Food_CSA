/*
 * Problem 2 Sell My Pet Food
 */
 public class TargetedAd {

  public static void main(String[] args)
  {
    /*  
     * TO DO:
     * PREPARATION WORK
     * (1) Create a file called targetWords.txt. Populate this file with words on each line that
     *     you think would determine if a user is a dog or cat owner.
     * 
     * PROGRAMMING
     * (2) Create a new DataCollector object and set the data to "socialMediaPostsSmall.txt" and "targetWords.txt"
     *     Important: Use the socialMedialPostsSmall to create your algorithm. Using a small file will help you 
     *     generate your solution quicker and give you the ability to double check your work.
     * (3) Create a String variable to hold the names of all the user. (The first word of every post is 
     *     a person's username)
     * (4) Compare each user's post to each target word. If a user mentions a target word, add their username to 
     *     the String of users. Separate usernames with a space. 
     *         Hint: You can use loops to look through each word. 
     *         Hint2: You can use indexOf to check if a word is in a user post. 
     * (5) Once you have all the users, use your DataCollector's prepareAdvertisement method to prepare a file 
     *     with all users and the advertisement you will send them.
     *         Additional Info: The prepareAdvertisement creates a new file on your computer. Check the posts of
     *         some of the usernames to make sure your algorithm worked.
     * 
     * THE FINAL SOLUTION
     * (6) Your solution should work with the socialMedialPostsSmall.txt. Modify your DataCollector initialization
     *    so you use the socialMediaPosts.txt. You should now have a larger file of users to target.
     */


    /* your code here */
    
    try {
      
      DataCollector dataCollector = new DataCollector();

      // Process the small dataset for testing
      //dataCollector.setData("socialMediaPostsSmall.txt", "targetWords.txt");
      
      // Process the Social media Posts 
      dataCollector.setData("socialMediaPosts.txt", "targetWords.txt");


      StringBuilder targetedUsernames = new StringBuilder();
      String post = dataCollector.getNextPost();

      while (!post.equals("NONE")) {
          String username = post.split(" ")[0];
          String targetWord = dataCollector.getNextTargetWord();

          while (!targetWord.equals("NONE")) {
              if (post.contains(targetWord) && !targetedUsernames.toString().contains(username)) {
                  targetedUsernames.append(username).append(" ");
              }
              targetWord = dataCollector.getNextTargetWord();
          }

          post = dataCollector.getNextPost();
      }

      // Prepare the advertisement for the small dataset
      String advertisement = "Check out our premium pet food!";
      String adFileName = "Ad Target File.txt";
      dataCollector.prepareAdvertisement(adFileName, targetedUsernames.toString().trim(), advertisement);
 

      // Debugging: Check content of the second advertisement
     
      System.out.println("Targeted usernames: " + targetedUsernames);

  } catch (Exception e) {
      System.out.println("An error occurred: " + e.getMessage());
  }
}
}