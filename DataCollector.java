 
/*
 * Problem 2 Sell My Pet Food
 * 
 * V1.0
 * 6/1/2019
 * Copyright(c) 2019 PLTW to present. All rights reserved
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DataCollector {
  private ArrayList<String> socialMediaPosts;
  private ArrayList<String> targetWords;
  private Scanner sc;
  private int currentPost;
  private int currentTargetWord;

  public DataCollector() {
      socialMediaPosts = new ArrayList<>();
      targetWords = new ArrayList<>();
      currentPost = 0;
      currentTargetWord = 0;
  }

  /**
   * Gather the data contained in the files socialMediaPostsFilename and
   * targetWordsFilename, with words separated by a single space.
   *
   * @param socialMediaPostsFilename the name of the file containing social media posts
   * @param targetWordsFilename      the name of the file containing the target words
   */
 
  public void setData(String socialMediaPostsFilename, String targetWordsFilename) {
      // Read in the social media posts
      try {
          sc = new Scanner(new File(socialMediaPostsFilename));
          while (sc.hasNextLine()) {
              String temp = sc.nextLine().trim();
              this.socialMediaPosts.add(temp);
          }
          //System.out.println("Loaded social media posts successfully.");
      } catch (Exception e) {
          System.out.println("Error reading or parsing social media posts: " + e.getMessage());
      }

      // Read in the target words
      try {
          sc = new Scanner(new File(targetWordsFilename));
          while (sc.hasNextLine()) {
              this.targetWords.add(sc.nextLine().trim());
          }
          //System.out.println("Loaded target words successfully.");
      } catch (Exception e) {
          System.out.println("Error reading or parsing target words: " + e.getMessage());
      }
  }

  /**
   * Reset the post index for reuse.
   */
  public void resetPosts() {
      this.currentPost = 0;
  }

  /**
   * Reset the target word index for reuse.
   */
  public void resetTargetWords() {
      this.currentTargetWord = 0;
  }

  /**
   * Get the next post in socialMediaPosts, or "NONE" if there is no more data.
   *
   * @return a string containing one of the lines in socialMediaPosts
   */
  public String getNextPost() {
      if (currentPost < socialMediaPosts.size()) {
          return socialMediaPosts.get(currentPost++);
      } else {
          return "NONE";
      }
  }

  /**
   * Get the next target word, or "NONE" if there is no more data.
   *
   * @return a string containing one of the target words
   */
  public String getNextTargetWord() {
      if (currentTargetWord < targetWords.size()) {
          return targetWords.get(currentTargetWord++);
      } else {
          resetTargetWords(); // Reset index to loop through again if needed
          return "NONE";
      }
  }

  /**
   * Find usernames from posts containing any of the target words.
   *
   * @return a space-separated string of targeted usernames
   */
  public String findTargetedUsernames() {
      StringBuilder targetedUsernames = new StringBuilder();

      for (String post : socialMediaPosts) {
          String username = post.split(" ")[0]; // Extract username from post
          for (String targetWord : targetWords) {
              if (post.contains(targetWord) && !targetedUsernames.toString().contains(username)) {
                  targetedUsernames.append(username).append(" ");
              }
          }
      }
      return targetedUsernames.toString().trim();
  }

  /**
   * Create a file named filename and store all the usernames to target.
   *
   * @param filename       The name to save the file, must include .txt
   * @param usernames      A string containing usernames separated by spaces
   * @param advertisement  The advertisement message
   */
 /**
 * Create a file named filename and store all the usernames to target.
 * Also, output the advertisement to the console for review.
 *
 * @param filename       The name to save the file, must include .txt
 * @param usernames      A string containing usernames separated by spaces
 * @param advertisement  The advertisement message
 */
public void prepareAdvertisement(String filename, String usernames, String advertisement) {
  try {
      FileWriter fw = new FileWriter(filename);
      System.out.println("Advertisement Preview:");
      for (String un : usernames.split(" ")) {
          String adLine = "@" + un + " " + advertisement;
          fw.write(adLine + "\n");
          System.out.println(adLine); // Print the advertisement line to the console
      }
      fw.close();
    
  } catch (IOException e) {
      System.out.println("Could not write to file: " + filename + ". Error: " + e.getMessage());
  }
}

}